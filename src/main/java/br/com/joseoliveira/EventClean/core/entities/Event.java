package br.com.joseoliveira.EventClean.core.entities;

import br.com.joseoliveira.EventClean.core.enums.EventType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Event(Long id,
                    String name,
                    String description,
                    String location,
                    LocalDateTime dataInicio,
                    LocalDateTime dataFim,
                    String identificator,
                    String organizator,
                    Integer capacity,
                    EventType type
                    ) {
}