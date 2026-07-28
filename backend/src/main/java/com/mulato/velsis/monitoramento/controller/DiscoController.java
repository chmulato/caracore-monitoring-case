package com.mulato.velsis.monitoramento.controller;

import com.mulato.velsis.monitoramento.entity.MonitoramentoDisco;
import com.mulato.velsis.monitoramento.service.DiscoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/disco")
public class DiscoController {

    private final DiscoService service;

    public DiscoController(DiscoService service) {
        this.service = service;
    }

    @PostMapping("/registrar")
    public MonitoramentoDisco registrar(@RequestParam Long total,
                                        @RequestParam Long usado,
                                        @RequestParam Long livre,
                                        @RequestParam Double percentual,
                                        @RequestParam Boolean alerta) {
        return service.registrar(total, usado, livre, percentual, alerta);
    }
}
