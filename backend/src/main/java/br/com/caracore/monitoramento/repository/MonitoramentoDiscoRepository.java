package br.com.caracore.monitoramento.repository;

import br.com.caracore.monitoramento.entity.MonitoramentoDisco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoramentoDiscoRepository extends JpaRepository<MonitoramentoDisco, Long> {
}
