package br.com.caracore.monitoramento.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "monitoramento_camera")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonitoramentoCamera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    private Boolean status;
    private Long tempoPingMs;
    private String resultadoFrame;
    private String mensagemErro;

    @ManyToOne
    @JoinColumn(name = "camera_id")
    private Camera camera;
}
