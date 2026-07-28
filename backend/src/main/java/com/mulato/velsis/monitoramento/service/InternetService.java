package com.mulato.velsis.monitoramento.service;

import com.mulato.velsis.monitoramento.entity.MonitoramentoInternet;
import com.mulato.velsis.monitoramento.repository.MonitoramentoInternetRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InternetService {

    private final MonitoramentoInternetRepository repository;

    public InternetService(MonitoramentoInternetRepository repository) {
        this.repository = repository;
    }

    public MonitoramentoInternet registrar(Boolean status, Long tempoResposta, String erro) {
        MonitoramentoInternet m = new MonitoramentoInternet();
        m.setDataHora(LocalDateTime.now());
        m.setStatus(status);
        m.setTempoRespostaMs(tempoResposta);
        m.setMensagemErro(erro);
        return repository.save(m);
    }
}
