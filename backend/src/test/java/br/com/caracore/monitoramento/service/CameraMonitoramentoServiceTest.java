package br.com.caracore.monitoramento.service;

import br.com.caracore.monitoramento.entity.Camera;
import br.com.caracore.monitoramento.entity.MonitoramentoCamera;
import br.com.caracore.monitoramento.repository.MonitoramentoCameraRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class CameraMonitoramentoServiceTest {

    @Test
    void deveRegistrarMonitoramentoCamera() {
        var repo = Mockito.mock(MonitoramentoCameraRepository.class);
        var service = new CameraMonitoramentoService(repo);

        Mockito.when(repo.save(any())).thenAnswer(inv -> inv.getArgument(0));

        Camera cam = new Camera();
        cam.setId(1L);
        cam.setNome("Cam 1");

        MonitoramentoCamera m = service.registrar(cam, true, 50L, "frame_ok", null);

        assertEquals(cam, m.getCamera());
        assertTrue(m.getStatus());
        assertEquals(50L, m.getTempoPingMs());
        assertEquals("frame_ok", m.getResultadoFrame());
        assertNull(m.getMensagemErro());
    }
}
