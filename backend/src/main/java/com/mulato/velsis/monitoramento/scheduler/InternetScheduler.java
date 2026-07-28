package com.mulato.velsis.monitoramento.scheduler;

import com.mulato.velsis.monitoramento.entity.Configuracao;
import com.mulato.velsis.monitoramento.service.AlertaService;
import com.mulato.velsis.monitoramento.service.ConfiguracaoService;
import com.mulato.velsis.monitoramento.service.InternetService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class InternetScheduler {

    private final ConfiguracaoService configuracaoService;
    private final InternetService internetService;
    private final AlertaService alertaService;

    public InternetScheduler(ConfiguracaoService configuracaoService,
                             InternetService internetService,
                             AlertaService alertaService) {
        this.configuracaoService = configuracaoService;
        this.internetService = internetService;
        this.alertaService = alertaService;
    }

    @Scheduled(fixedRateString = "#{@configuracaoService.buscar().get().periodicidadeInternet * 1000}")
    public void executar() {

        Configuracao cfg = configuracaoService.buscar().orElse(null);
        if (cfg == null) return;

        long inicio = System.currentTimeMillis();

        try {
            String os = System.getProperty("os.name").toLowerCase();
            String pingCmd = os.contains("win") ? "ping -n 1 " : "ping -c 1 ";
            Process p = Runtime.getRuntime().exec(pingCmd + cfg.getIpTesteInternet());
            int status = p.waitFor();

            long tempo = System.currentTimeMillis() - inicio;

            boolean ok = (status == 0);

            internetService.registrar(ok, tempo, ok ? null : "Falha no ping");

            if (!ok) {
                alertaService.registrar("internet", "Falha no ping", "alta", null);
            }

        } catch (Exception e) {
            internetService.registrar(false, 0L, e.getMessage());
            alertaService.registrar("internet", e.getMessage(), "alta", null);
        }
    }
}
