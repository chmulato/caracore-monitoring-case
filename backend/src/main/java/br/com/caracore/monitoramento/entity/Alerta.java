package br.com.caracore.monitoramento.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alerta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // internet, disco, camera
    private String mensagem;
    private LocalDateTime dataHora;

    private String severidade; // opcional
    private Boolean resolvido;

    @ManyToOne
    @JoinColumn(name = "camera_id")
    private Camera camera; // opcional
}
