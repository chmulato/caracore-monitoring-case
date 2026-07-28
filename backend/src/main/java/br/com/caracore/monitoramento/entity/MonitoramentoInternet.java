package br.com.caracore.monitoramento.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "monitoramento_internet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonitoramentoInternet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    private Boolean status;
    private Long tempoRespostaMs;
    private String mensagemErro;
}
