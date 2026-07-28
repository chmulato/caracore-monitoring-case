package br.com.caracore.monitoramento.service;

import br.com.caracore.monitoramento.entity.Camera;
import br.com.caracore.monitoramento.repository.CameraRepository;
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
