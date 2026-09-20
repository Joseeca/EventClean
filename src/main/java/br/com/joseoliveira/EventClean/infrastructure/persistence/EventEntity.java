package br.com.joseoliveira.EventClean.infrastructure.persistence;

import br.com.joseoliveira.EventClean.core.enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Eventos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String location;
    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;
    @Column(name = "data_fim")
    private LocalDateTime dataFim;
    private String identificator;
    private String organizator;
    private Integer capacity;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento")
    private EventType type;
}
