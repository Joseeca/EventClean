package br.com.joseoliveira.EventClean.infrastructure.dtos;

import br.com.joseoliveira.EventClean.core.enums.EventType;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record EventoDto(Long id,
                        String name,
                        String description,
                        String location,
                        LocalDateTime dataInicio,
                        LocalDateTime dataFim,
                        String identificator,
                        String organizator,
                        Integer capacity,
                        EventType type) {
}
