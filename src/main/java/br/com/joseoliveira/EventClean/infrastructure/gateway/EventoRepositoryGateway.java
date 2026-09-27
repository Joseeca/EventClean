package br.com.joseoliveira.EventClean.infrastructure.gateway;

import br.com.joseoliveira.EventClean.core.entities.Event;
import br.com.joseoliveira.EventClean.core.gateway.EventoGateway;
import br.com.joseoliveira.EventClean.infrastructure.mapper.EventoEntityMapper;
import br.com.joseoliveira.EventClean.infrastructure.persistence.EventEntity;
import br.com.joseoliveira.EventClean.infrastructure.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Event> buscarEventos() {
        return eventRepository.findAll().stream().map(eventEntityMapper::toDomain).toList();
    }

    @Override
    public boolean existePorIdentificador(String identificador) {
        return eventRepository.findAll().stream()
                .anyMatch(evento -> evento.getIdentificator()
                        .equalsIgnoreCase(identificador));
    }

    @Override
    public Optional<Event> filtrarPorIdentificador(String identificator) {
        return eventRepository.findByIdentificator(identificator);
    }
}
