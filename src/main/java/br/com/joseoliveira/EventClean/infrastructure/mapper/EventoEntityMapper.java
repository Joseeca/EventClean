package br.com.joseoliveira.EventClean.infrastructure.mapper;

import br.com.joseoliveira.EventClean.core.entities.Event;
import br.com.joseoliveira.EventClean.infrastructure.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventoEntityMapper {

    public EventEntity toEntity(Event event) {
        return new EventEntity(
                event.id(),
                event.name(),
                event.description(),
                event.location(),
                event.dataInicio(),
                event.dataFim(),
                event.identificator(),
                event.organizator(),
                event.capacity(),
                event.type());
    }

    public Event toDomain(EventEntity eventEntity) {
        return new Event(
                eventEntity.getId(),
                eventEntity.getName(),
                eventEntity.getDescription(),
                eventEntity.getLocation(),
                eventEntity.getDataInicio(),
                eventEntity.getDataFim(),
                eventEntity.getIdentificator(),
                eventEntity.getOrganizator(),
                eventEntity.getCapacity(),
                eventEntity.getType());
    }
}