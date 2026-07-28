package br.com.caracore.monitoramento.repository;

import br.com.caracore.monitoramento.entity.MonitoramentoCamera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoramentoCameraRepository extends JpaRepository<MonitoramentoCamera, Long> {
}
