package br.com.caracore.monitoramento.controller;

import br.com.caracore.monitoramento.entity.Configuracao;
import br.com.caracore.monitoramento.service.ConfiguracaoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/configuracao")
public class ConfiguracaoController {

    private final ConfiguracaoService service;

    public ConfiguracaoController(ConfiguracaoService service) {
        this.service = service;
    }

    @GetMapping
    public Configuracao buscar() {
        return service.buscar().orElse(null);
    }

    @PutMapping
    public Configuracao salvar(@RequestBody Configuracao configuracao) {
        return service.salvar(configuracao);
    }
}
