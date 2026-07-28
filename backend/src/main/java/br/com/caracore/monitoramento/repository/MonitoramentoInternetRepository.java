package br.com.caracore.monitoramento.repository;

import br.com.caracore.monitoramento.entity.MonitoramentoInternet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoramentoInternetRepository extends JpaRepository<MonitoramentoInternet, Long> {
}
