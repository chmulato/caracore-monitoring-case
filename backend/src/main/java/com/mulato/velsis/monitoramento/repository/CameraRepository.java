package com.mulato.velsis.monitoramento.repository;

import com.mulato.velsis.monitoramento.entity.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraRepository extends JpaRepository<Camera, Long> {
}
