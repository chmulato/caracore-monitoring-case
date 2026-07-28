package br.com.caracore.monitoramento.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "configuracao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Configuracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Internet
    private String ipTesteInternet;
    private Integer timeoutInternet;
    private Integer periodicidadeInternet;

    // Disco
    private Long limiteDiscoPercentual;
    private Integer periodicidadeDisco;

    // Câmeras
    private Integer periodicidadeCamera;
}
