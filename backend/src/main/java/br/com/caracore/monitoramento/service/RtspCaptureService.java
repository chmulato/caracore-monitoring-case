package br.com.caracore.monitoramento.service;

import br.com.caracore.monitoramento.entity.Camera;

/**
 * Interface para abstrair a captura de frames via RTSP.
 * Demonstra a aplicação do Princípio da Inversão de Dependência (DIP - SOLID).
 */
public interface RtspCaptureService {
    
    /**
     * Tenta capturar um frame do canal RTSP da câmera.
     * 
     * @param camera A câmera a ser verificada.
     * @return true se obteve sucesso, false caso contrário.
     */
    boolean capturarFrame(Camera camera);
}
