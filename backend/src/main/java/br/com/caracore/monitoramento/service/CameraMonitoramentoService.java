package br.com.caracore.monitoramento.service;

import br.com.caracore.monitoramento.entity.Camera;
import br.com.caracore.monitoramento.entity.MonitoramentoCamera;
import br.com.caracore.monitoramento.repository.MonitoramentoCameraRepository;
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
