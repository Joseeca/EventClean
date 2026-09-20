package br.com.joseoliveira.EventClean.core.useCases;

import br.com.joseoliveira.EventClean.core.entities.Event;
import br.com.joseoliveira.EventClean.core.gateway.EventoGateway;
import org.springframework.stereotype.Service;

@Service
public class CriarEventoCaseImpl implements CriarEventoCase{

    private final EventoGateway eventGateway;

    public CriarEventoCaseImpl(EventoGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {
        return null;
    }
}
