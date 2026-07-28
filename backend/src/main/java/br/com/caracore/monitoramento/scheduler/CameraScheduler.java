package br.com.caracore.monitoramento.scheduler;

import br.com.caracore.monitoramento.entity.Camera;
import br.com.caracore.monitoramento.entity.Configuracao;
import br.com.caracore.monitoramento.service.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CameraScheduler {

    private final CameraService cameraService;
    private final CameraMonitoramentoService monitoramentoService;
    private final ConfiguracaoService configuracaoService;
    private final AlertaService alertaService;
    private final RtspCaptureService rtspCaptureService;

    public CameraScheduler(CameraService cameraService,
                           CameraMonitoramentoService monitoramentoService,
                           ConfiguracaoService configuracaoService,
                           AlertaService alertaService,
                           RtspCaptureService rtspCaptureService) {
        this.cameraService = cameraService;
        this.monitoramentoService = monitoramentoService;
        this.configuracaoService = configuracaoService;
        this.alertaService = alertaService;
        this.rtspCaptureService = rtspCaptureService;
    }

    @Scheduled(fixedRateString = "#{@configuracaoService.buscar().get().periodicidadeCamera * 1000}")
    public void executar() {

        Configuracao cfg = configuracaoService.buscar().orElse(null);
        if (cfg == null) return;

        List<Camera> cameras = cameraService.listar();

        for (Camera cam : cameras) {

            long inicio = System.currentTimeMillis();

            try {
                String os = System.getProperty("os.name").toLowerCase();
                String pingCmd = os.contains("win") ? "ping -n 1 " : "ping -c 1 ";
                Process p = Runtime.getRuntime().exec(pingCmd + cam.getIp());
                int status = p.waitFor();

                long tempo = System.currentTimeMillis() - inicio;

                boolean pingOk = (status == 0);
                boolean rtspOk = false;
                
                if (pingOk) {
                    rtspOk = rtspCaptureService.capturarFrame(cam);
                }
                
                boolean cameraOnline = pingOk && rtspOk;

                String mensagemErro = null;
                if (!pingOk) {
                    mensagemErro = "Falha no ping da câmera";
                } else if (!rtspOk) {
                    mensagemErro = "Falha na captura do frame RTSP";
                }

                monitoramentoService.registrar(cam, cameraOnline, tempo,
                        rtspOk ? "frame_ok" : null,
                        mensagemErro);

                if (!cameraOnline) {
                    alertaService.registrar("camera",
                            "Câmera offline: " + cam.getNome() + " (" + mensagemErro + ")",
                            "alta",
                            cam);
                }

            } catch (Exception e) {
                monitoramentoService.registrar(cam, false, 0L, null, e.getMessage());
                alertaService.registrar("camera", e.getMessage(), "alta", cam);
            }
        }
    }
}
