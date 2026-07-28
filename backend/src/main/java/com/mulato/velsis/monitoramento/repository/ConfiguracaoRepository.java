package com.mulato.velsis.monitoramento.repository;

import com.mulato.velsis.monitoramento.entity.Configuracao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Long> {
}
