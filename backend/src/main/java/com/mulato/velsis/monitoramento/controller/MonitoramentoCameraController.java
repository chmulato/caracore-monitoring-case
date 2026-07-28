package com.mulato.velsis.monitoramento.controller;

import com.mulato.velsis.monitoramento.entity.Camera;
import com.mulato.velsis.monitoramento.entity.MonitoramentoCamera;
import com.mulato.velsis.monitoramento.service.CameraMonitoramentoService;
import com.mulato.velsis.monitoramento.service.CameraService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/monitoramento-camera")
public class MonitoramentoCameraController {

    private final CameraMonitoramentoService monitoramentoService;
    private final CameraService cameraService;

    public MonitoramentoCameraController(CameraMonitoramentoService monitoramentoService,
                                         CameraService cameraService) {
        this.monitoramentoService = monitoramentoService;
        this.cameraService = cameraService;
    }

    @PostMapping("/registrar/{cameraId}")
    public MonitoramentoCamera registrar(@PathVariable Long cameraId,
                                         @RequestParam Boolean status,
                                         @RequestParam Long tempoPing,
                                         @RequestParam(required = false) String frame,
                                         @RequestParam(required = false) String erro) {

        Camera camera = cameraService.buscarPorId(cameraId);
        return monitoramentoService.registrar(camera, status, tempoPing, frame, erro);
    }
}
