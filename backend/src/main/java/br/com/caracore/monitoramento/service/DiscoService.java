package br.com.caracore.monitoramento.service;

import br.com.caracore.monitoramento.entity.MonitoramentoDisco;
import br.com.caracore.monitoramento.repository.MonitoramentoDiscoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DiscoService {

    private final MonitoramentoDiscoRepository repository;

    public DiscoService(MonitoramentoDiscoRepository repository) {
        this.repository = repository;
    }

    public MonitoramentoDisco registrar(Long total, Long usado, Long livre, Double percentual, Boolean alerta) {
        MonitoramentoDisco m = new MonitoramentoDisco();
        m.setDataHora(LocalDateTime.now());
        m.setEspacoTotal(total);
        m.setEspacoUtilizado(usado);
        m.setEspacoLivre(livre);
        m.setPercentualUtilizado(percentual);
        m.setAlerta(alerta);
        return repository.save(m);
    }
}
