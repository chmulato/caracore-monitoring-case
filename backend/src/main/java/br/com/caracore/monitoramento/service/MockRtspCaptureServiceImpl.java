package br.com.caracore.monitoramento.service;

import br.com.caracore.monitoramento.entity.Camera;
import org.springframework.stereotype.Service;

/**
 * Implementação Mock/Conceitual para avaliação técnica.
 * Em produção real, esta classe utilizaria OpenCV (JavaCV) ou FFmpeg
 * para extrair o frame do endpoint RTSP.
 */
@Service
public class MockRtspCaptureServiceImpl implements RtspCaptureService {

    @Override
    public boolean capturarFrame(Camera camera) {
        try {
            // Simula um atraso de rede/processamento (ex: 200ms)
            Thread.sleep(200);
            
            // Simula sucesso em 90% das vezes e falha em 10%
            return Math.random() > 0.1;
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
