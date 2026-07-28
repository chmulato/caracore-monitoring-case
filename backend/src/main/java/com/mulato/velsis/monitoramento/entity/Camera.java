package com.mulato.velsis.monitoramento.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "camera")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String ip;
    private Integer portaHttp;
    private Integer portaRtsp;
    private String usuario;
    private String senha;

    private Boolean ativa;
}
