package br.com.caracore.monitoramento.controller;

import br.com.caracore.monitoramento.entity.Camera;
import br.com.caracore.monitoramento.service.CameraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camera")
public class CameraController {

    private final CameraService service;

    public CameraController(CameraService service) {
        this.service = service;
    }

    @GetMapping
    public List<Camera> listar() {
        return service.listar();
    }

    @PostMapping
    public Camera salvar(@RequestBody Camera camera) {
        return service.salvar(camera);
    }

    @GetMapping("/{id}")
    public Camera buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}
