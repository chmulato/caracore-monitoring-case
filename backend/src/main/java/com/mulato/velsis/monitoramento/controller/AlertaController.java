package com.mulato.velsis.monitoramento.controller;

import com.mulato.velsis.monitoramento.entity.Alerta;
import com.mulato.velsis.monitoramento.entity.Camera;
import com.mulato.velsis.monitoramento.service.AlertaService;
import com.mulato.velsis.monitoramento.service.CameraService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alerta")
public class AlertaController {

    private final AlertaService service;
    private final CameraService cameraService;

    public AlertaController(AlertaService service, CameraService cameraService) {
        this.service = service;
        this.cameraService = cameraService;
    }

    @PostMapping
    public Alerta registrar(@RequestParam String tipo,
                            @RequestParam String mensagem,
                            @RequestParam(required = false) String severidade,
                            @RequestParam(required = false) Long cameraId) {

        Camera camera = cameraId != null ? cameraService.buscarPorId(cameraId) : null;

        return service.registrar(tipo, mensagem, severidade, camera);
    }

    @PutMapping("/{id}/resolver")
    public void resolver(@PathVariable Long id) {
        service.resolver(id);
    }
}
