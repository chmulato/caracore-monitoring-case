package com.mulato.velsis.monitoramento.controller;

import com.mulato.velsis.monitoramento.entity.MonitoramentoInternet;
import com.mulato.velsis.monitoramento.service.InternetService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internet")
public class InternetController {

    private final InternetService service;

    public InternetController(InternetService service) {
        this.service = service;
    }

    @PostMapping("/registrar")
    public MonitoramentoInternet registrar(@RequestParam Boolean status,
                                           @RequestParam Long tempoResposta,
                                           @RequestParam(required = false) String erro) {
        return service.registrar(status, tempoResposta, erro);
    }
}
