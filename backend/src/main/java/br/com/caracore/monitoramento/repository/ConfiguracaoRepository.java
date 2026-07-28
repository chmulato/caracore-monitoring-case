package br.com.caracore.monitoramento.repository;

import br.com.caracore.monitoramento.entity.Configuracao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfiguracaoRepository extends JpaRepository<Configuracao, Long> {
}
