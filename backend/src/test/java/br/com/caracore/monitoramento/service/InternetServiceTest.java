package br.com.caracore.monitoramento.service;

import br.com.caracore.monitoramento.entity.MonitoramentoInternet;
import br.com.caracore.monitoramento.repository.MonitoramentoInternetRepository;
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
