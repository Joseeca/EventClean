package br.com.joseoliveira.EventClean.infrastructure.gateway;

import br.com.joseoliveira.EventClean.core.entities.Event;
import br.com.joseoliveira.EventClean.core.gateway.EventoGateway;
import br.com.joseoliveira.EventClean.infrastructure.mapper.EventoEntityMapper;
import br.com.joseoliveira.EventClean.infrastructure.persistence.EventEntity;
import br.com.joseoliveira.EventClean.infrastructure.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventoRepositoryGateway implements EventoGateway {

    private final EventRepository eventRepository;
    private final EventoEntityMapper eventEntityMapper;

    @Override
    public Event criarEvento(Event event) {
        EventEntity entity = eventEntityMapper.toEntity(event);
        EventEntity novoEvento = eventRepository.save(entity);
        return eventEntityMapper.toDomain(novoEvento);
    }
}
