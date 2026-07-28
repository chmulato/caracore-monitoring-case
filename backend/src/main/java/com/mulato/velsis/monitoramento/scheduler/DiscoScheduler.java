package com.mulato.velsis.monitoramento.scheduler;

import com.mulato.velsis.monitoramento.entity.Configuracao;
import com.mulato.velsis.monitoramento.service.AlertaService;
import com.mulato.velsis.monitoramento.service.ConfiguracaoService;
import com.mulato.velsis.monitoramento.service.DiscoService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DiscoScheduler {

    private final ConfiguracaoService configuracaoService;
    private final DiscoService discoService;
    private final AlertaService alertaService;

    public DiscoScheduler(ConfiguracaoService configuracaoService,
                          DiscoService discoService,
                          AlertaService alertaService) {
        this.configuracaoService = configuracaoService;
        this.discoService = discoService;
        this.alertaService = alertaService;
    }

    @Scheduled(fixedRateString = "#{@configuracaoService.buscar().get().periodicidadeDisco * 1000}")
    public void executar() {

        Configuracao cfg = configuracaoService.buscar().orElse(null);
        if (cfg == null) return;

        String os = System.getProperty("os.name").toLowerCase();
        File root = new File(os.contains("win") ? "C:/" : "/");

        long total = root.getTotalSpace();
        long livre = root.getFreeSpace();
        long usado = total - livre;

        double percentual = (double) usado / total * 100;

        boolean alerta = percentual > cfg.getLimiteDiscoPercentual();

        discoService.registrar(total, usado, livre, percentual, alerta);

        if (alerta) {
            alertaService.registrar("disco",
                    "Uso de disco acima do limite: " + percentual + "%",
                    "alta",
                    null);
        }
    }
}
