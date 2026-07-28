package br.com.caracore.monitoramento.service;

import br.com.caracore.monitoramento.entity.Configuracao;
import br.com.caracore.monitoramento.repository.ConfiguracaoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class ConfiguracaoServiceTest {

    @Test
    void deveSalvarConfiguracao() {
        var repo = Mockito.mock(ConfiguracaoRepository.class);
        var service = new ConfiguracaoService(repo);

        Mockito.when(repo.save(any())).thenAnswer(inv -> inv.getArgument(0));

        Configuracao cfg = new Configuracao();
        cfg.setPeriodicidadeInternet(10);

        Configuracao salvo = service.salvar(cfg);

        assertEquals(1L, salvo.getId());
        assertEquals(10, salvo.getPeriodicidadeInternet());
    }

    @Test
    void deveBuscarConfiguracao() {
        var repo = Mockito.mock(ConfiguracaoRepository.class);
        var service = new ConfiguracaoService(repo);

        Configuracao cfg = new Configuracao();
        cfg.setId(1L);

        Mockito.when(repo.findById(1L)).thenReturn(Optional.of(cfg));

        Optional<Configuracao> resultado = service.buscar();

        assertTrue(resultado.isPresent());
        assertEquals(1L, resultado.get().getId());
    }
}
