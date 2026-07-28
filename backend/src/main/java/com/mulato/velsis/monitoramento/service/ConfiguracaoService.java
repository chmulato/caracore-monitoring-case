package com.mulato.velsis.monitoramento.service;

import com.mulato.velsis.monitoramento.entity.Configuracao;
import com.mulato.velsis.monitoramento.repository.ConfiguracaoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConfiguracaoService {

    private final ConfiguracaoRepository repository;

    public ConfiguracaoService(ConfiguracaoRepository repository) {
        this.repository = repository;
    }

    public Optional<Configuracao> buscar() {
        return repository.findById(1L);
    }

    public Configuracao salvar(Configuracao configuracao) {
        configuracao.setId(1L);
        return repository.save(configuracao);
    }
}
