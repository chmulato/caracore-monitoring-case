package br.com.caracore.monitoramento.repository;

import br.com.caracore.monitoramento.entity.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraRepository extends JpaRepository<Camera, Long> {
}
