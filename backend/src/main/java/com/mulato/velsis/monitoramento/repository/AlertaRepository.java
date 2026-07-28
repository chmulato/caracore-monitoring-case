package com.mulato.velsis.monitoramento.repository;

import com.mulato.velsis.monitoramento.entity.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}
