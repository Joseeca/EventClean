package br.com.joseoliveira.EventClean.infrastructure.mapper;

import br.com.joseoliveira.EventClean.core.entities.Event;
import br.com.joseoliveira.EventClean.infrastructure.dtos.EventoDto;
import org.springframework.stereotype.Component;

@Component
public class EventoDtoMapper {

    public EventoDto toDto(Event event) {
        return EventoDto.builder()
                .id(event.id())
                .name(event.name())
                .description(event.location())
                .location(event.location())
                .dataInicio(event.dataInicio())
                .dataFim(event.dataFim())
                .identificator(event.identificator())
                .organizator(event.organizator())
                .capacity(event.capacity())
                .type(event.type())
                .build();
    }

    public Event toDomain(EventoDto eventDto) {
        return new Event(
                eventDto.id(),
                eventDto.name(),
                eventDto.description(),
                eventDto.location(),
                eventDto.dataInicio(),
                eventDto.dataFim(),
                eventDto.identificator(),
                eventDto.organizator(),
                eventDto.capacity(),
                eventDto.type()
        );
    }
}
