package com.mulato.velsis.monitoramento.service;

import com.mulato.velsis.monitoramento.entity.MonitoramentoInternet;
import com.mulato.velsis.monitoramento.repository.MonitoramentoInternetRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class InternetServiceTest {

    @Test
    void deveRegistrarMonitoramentoInternet() {
        var repo = Mockito.mock(MonitoramentoInternetRepository.class);
        var service = new InternetService(repo);

        Mockito.when(repo.save(any())).thenAnswer(inv -> inv.getArgument(0));

        MonitoramentoInternet m = service.registrar(true, 120L, null);

        assertNotNull(m.getDataHora());
        assertTrue(m.getStatus());
        assertEquals(120L, m.getTempoRespostaMs());
        assertNull(m.getMensagemErro());
    }
}
