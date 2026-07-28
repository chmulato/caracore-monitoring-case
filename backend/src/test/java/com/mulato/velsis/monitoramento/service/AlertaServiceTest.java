package com.mulato.velsis.monitoramento.service;

import com.mulato.velsis.monitoramento.entity.Alerta;
import com.mulato.velsis.monitoramento.entity.Camera;
import com.mulato.velsis.monitoramento.repository.AlertaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class AlertaServiceTest {

    @Test
    void deveRegistrarAlerta() {
        var repo = Mockito.mock(AlertaRepository.class);
        var service = new AlertaService(repo);

        Mockito.when(repo.save(any())).thenAnswer(inv -> inv.getArgument(0));

        Camera cam = new Camera();
        cam.setId(1L);

        Alerta a = service.registrar("camera", "Falha", "alta", cam);

        assertEquals("camera", a.getTipo());
        assertEquals("Falha", a.getMensagem());
        assertEquals("alta", a.getSeveridade());
        assertEquals(cam, a.getCamera());
        assertFalse(a.getResolvido());
    }

    @Test
    void deveResolverAlerta() {
        var repo = Mockito.mock(AlertaRepository.class);
        var service = new AlertaService(repo);

        Alerta alerta = new Alerta();
        alerta.setId(1L);
        alerta.setResolvido(false);

        Mockito.when(repo.findById(1L)).thenReturn(Optional.of(alerta));
        Mockito.when(repo.save(any())).thenAnswer(inv -> inv.getArgument(0));

        service.resolver(1L);

        assertTrue(alerta.getResolvido());
    }
}
