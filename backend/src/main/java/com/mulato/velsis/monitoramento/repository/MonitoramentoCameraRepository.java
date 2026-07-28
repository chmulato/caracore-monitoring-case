package com.mulato.velsis.monitoramento.repository;

import com.mulato.velsis.monitoramento.entity.MonitoramentoCamera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoramentoCameraRepository extends JpaRepository<MonitoramentoCamera, Long> {
}
