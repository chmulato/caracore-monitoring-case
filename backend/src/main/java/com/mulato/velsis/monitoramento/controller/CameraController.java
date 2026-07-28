package com.mulato.velsis.monitoramento.controller;

import com.mulato.velsis.monitoramento.entity.Camera;
import com.mulato.velsis.monitoramento.service.CameraService;
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
