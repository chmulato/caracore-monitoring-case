package com.mulato.velsis.monitoramento.service;

import com.mulato.velsis.monitoramento.entity.Camera;
import com.mulato.velsis.monitoramento.repository.CameraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraService {

    private final CameraRepository repository;

    public CameraService(CameraRepository repository) {
        this.repository = repository;
    }

    public List<Camera> listar() {
        return repository.findAll();
    }

    public Camera salvar(Camera camera) {
        return repository.save(camera);
    }

    public Camera buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
