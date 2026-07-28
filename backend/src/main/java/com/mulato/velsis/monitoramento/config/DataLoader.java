package com.mulato.velsis.monitoramento.config;

import com.mulato.velsis.monitoramento.entity.Camera;
import com.mulato.velsis.monitoramento.entity.Configuracao;
import com.mulato.velsis.monitoramento.repository.CameraRepository;
import com.mulato.velsis.monitoramento.repository.ConfiguracaoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ConfiguracaoRepository configuracaoRepository;
    private final CameraRepository cameraRepository;

    public DataLoader(ConfiguracaoRepository configuracaoRepository,
                      CameraRepository cameraRepository) {
        this.configuracaoRepository = configuracaoRepository;
        this.cameraRepository = cameraRepository;
    }

    @Override
    public void run(String... args) {

        if (configuracaoRepository.count() == 0) {
            Configuracao cfg = new Configuracao();
            cfg.setId(1L);
            cfg.setIpTesteInternet("8.8.8.8");
            cfg.setPeriodicidadeInternet(10);
            cfg.setPeriodicidadeDisco(15);
            cfg.setPeriodicidadeCamera(20);
            cfg.setLimiteDiscoPercentual(80L);
            configuracaoRepository.save(cfg);
        }

        if (cameraRepository.count() == 0) {

            cameraRepository.save(new Camera(
                    null,
                    "Entrada Principal",
                    "192.168.0.10",
                    "Câmera da entrada",
                    1280,
                    720,
                    "admin",
                    "1234",
                    true
            ));

            cameraRepository.save(new Camera(
                    null,
                    "Estacionamento",
                    "192.168.0.11",
                    "Câmera do estacionamento",
                    1280,
                    720,
                    "admin",
                    "1234",
                    true
            ));

            cameraRepository.save(new Camera(
                    null,
                    "Recepção",
                    "192.168.0.12",
                    "Câmera da recepção",
                    1280,
                    720,
                    "admin",
                    "1234",
                    true
            ));
        }
    }
}
