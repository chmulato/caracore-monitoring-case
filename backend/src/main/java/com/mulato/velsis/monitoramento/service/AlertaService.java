package com.mulato.velsis.monitoramento.service;

import com.mulato.velsis.monitoramento.entity.Alerta;
import com.mulato.velsis.monitoramento.entity.Camera;
import com.mulato.velsis.monitoramento.repository.AlertaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AlertaService {

    private final AlertaRepository repository;

    public AlertaService(AlertaRepository repository) {
        this.repository = repository;
    }

    public Alerta registrar(String tipo, String mensagem, String severidade, Camera camera) {
        Alerta alerta = new Alerta();
        alerta.setTipo(tipo);
        alerta.setMensagem(mensagem);
        alerta.setSeveridade(severidade);
        alerta.setCamera(camera);
        alerta.setDataHora(LocalDateTime.now());
        alerta.setResolvido(false);
        return repository.save(alerta);
    }

    public void resolver(Long id) {
        repository.findById(id).ifPresent(a -> {
            a.setResolvido(true);
            repository.save(a);
        });
    }
}
