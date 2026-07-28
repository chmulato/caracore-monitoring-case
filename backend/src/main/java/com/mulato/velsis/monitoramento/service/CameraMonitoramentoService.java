package com.mulato.velsis.monitoramento.service;

import com.mulato.velsis.monitoramento.entity.Camera;
import com.mulato.velsis.monitoramento.entity.MonitoramentoCamera;
import com.mulato.velsis.monitoramento.repository.MonitoramentoCameraRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CameraMonitoramentoService {

    private final MonitoramentoCameraRepository repository;

    public CameraMonitoramentoService(MonitoramentoCameraRepository repository) {
        this.repository = repository;
    }

    public MonitoramentoCamera registrar(Camera camera, Boolean status, Long tempoPing, String frame, String erro) {
        MonitoramentoCamera m = new MonitoramentoCamera();
        m.setCamera(camera);
        m.setDataHora(LocalDateTime.now());
        m.setStatus(status);
        m.setTempoPingMs(tempoPing);
        m.setResultadoFrame(frame);
        m.setMensagemErro(erro);
        return repository.save(m);
    }
}
