package br.com.caracore.speedviolation.service;

import br.com.caracore.speedviolation.config.ToleranceProperties;
import br.com.caracore.speedviolation.model.entity.Violation;
import br.com.caracore.speedviolation.model.enums.Origin;
import br.com.caracore.speedviolation.model.enums.Severity;
import br.com.caracore.speedviolation.model.request.ViolationRequest;
import br.com.caracore.speedviolation.model.response.ViolationResponse;
import br.com.caracore.speedviolation.repository.ViolationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ViolationServiceTest {

    private ToleranceProperties tolerance;
    private ViolationRepository repository;
    private ViolationService service;

    @BeforeEach
    void setup() {
        tolerance = new ToleranceProperties();
        tolerance.setFixed(7);
        tolerance.setPercent(7);
        tolerance.setLimitForPercent(100);

        repository = mock(ViolationRepository.class);
        service = new ViolationService(tolerance, repository);
    }

    @Test
    void shouldNotGenerateViolationWhenConsideredSpeedIsBelowLimit() {
        ViolationRequest request = new ViolationRequest(
                "ABC1234",
                67,
                60,
                "EQ-01",
                Instant.now()
        );

        ViolationResponse response = service.evaluate(Origin.FIXED, request);

        assertFalse(response.hasViolation());
        assertNull(response.violation());
        verify(repository, never()).save(anyString(), any());
    }

    @Test
    void shouldGenerateMediumViolation() {
        ViolationRequest request = new ViolationRequest(
                "ABC1234",
                79,
                60,
                "EQ-01",
                Instant.now()
        );

        ViolationResponse response = service.evaluate(Origin.FIXED, request);

        assertTrue(response.hasViolation());
        assertNotNull(response.violation());
        assertEquals(Severity.MEDIUM, response.violation().severity());
        assertEquals("218-I", response.violation().ctbCode());
    }

    @Test
    void shouldGenerateSeriousViolation() {
        ViolationRequest request = new ViolationRequest(
                "ABC1234",
                97,
                60,
                "EQ-01",
                Instant.now()
        );

        ViolationResponse response = service.evaluate(Origin.FIXED, request);

        assertTrue(response.hasViolation());
        assertEquals(Severity.SERIOUS, response.violation().severity());
        assertEquals("218-II", response.violation().ctbCode());
    }

    @Test
    void shouldGenerateVerySeriousViolation() {
        ViolationRequest request = new ViolationRequest(
                "ABC1234",
                160,
                60,
                "EQ-01",
                Instant.now()
        );

        ViolationResponse response = service.evaluate(Origin.FIXED, request);

        assertTrue(response.hasViolation());
        assertEquals(Severity.VERY_SERIOUS, response.violation().severity());
        assertEquals("218-III", response.violation().ctbCode());
    }

    @Test
    void shouldApplyFixedToleranceWhenSpeedIsBelowLimitForPercent() {
        ViolationRequest request = new ViolationRequest(
                "ABC1234",
                95,
                60,
                "EQ-01",
                Instant.now()
        );

        ViolationResponse response = service.evaluate(Origin.FIXED, request);

        assertEquals(88, response.consideredSpeed()); // 95 - 7
    }

    @Test
    void shouldApplyPercentToleranceWhenSpeedIsAboveLimitForPercent() {
        ViolationRequest request = new ViolationRequest(
                "ABC1234",
                150,
                60,
                "EQ-01",
                Instant.now()
        );

        ViolationResponse response = service.evaluate(Origin.FIXED, request);

        int expected = (int) Math.round(150 - (150 * 0.07));
        assertEquals(expected, response.consideredSpeed());
    }

    @Test
    void shouldSaveViolationInRepository() {
        ViolationRequest request = new ViolationRequest(
                "ABC1234",
                97,
                60,
                "EQ-01",
                Instant.now()
        );

        service.evaluate(Origin.FIXED, request);

        ArgumentCaptor<Violation> captor = ArgumentCaptor.forClass(Violation.class);
        verify(repository).save(eq("ABC1234"), captor.capture());

        assertEquals(Severity.SERIOUS, captor.getValue().severity());
    }
}
