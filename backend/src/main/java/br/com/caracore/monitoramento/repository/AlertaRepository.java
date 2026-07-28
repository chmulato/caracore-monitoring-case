package br.com.caracore.monitoramento.repository;

import br.com.caracore.monitoramento.entity.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}
