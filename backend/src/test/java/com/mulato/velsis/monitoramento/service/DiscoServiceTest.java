package com.mulato.velsis.monitoramento.service;

import com.mulato.velsis.monitoramento.entity.MonitoramentoDisco;
import com.mulato.velsis.monitoramento.repository.MonitoramentoDiscoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class DiscoServiceTest {

    @Test
    void deveRegistrarMonitoramentoDisco() {
        var repo = Mockito.mock(MonitoramentoDiscoRepository.class);
        var service = new DiscoService(repo);

        Mockito.when(repo.save(any())).thenAnswer(inv -> inv.getArgument(0));

        MonitoramentoDisco m = service.registrar(1000L, 800L, 200L, 80.0, true);

        assertEquals(1000L, m.getEspacoTotal());
        assertEquals(800L, m.getEspacoUtilizado());
        assertEquals(200L, m.getEspacoLivre());
        assertEquals(80.0, m.getPercentualUtilizado());
        assertTrue(m.getAlerta());
    }
}
