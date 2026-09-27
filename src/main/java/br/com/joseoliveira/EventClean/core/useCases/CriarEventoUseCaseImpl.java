package br.com.joseoliveira.EventClean.core.useCases;

import br.com.joseoliveira.EventClean.core.entities.Event;
import br.com.joseoliveira.EventClean.core.gateway.EventoGateway;
import br.com.joseoliveira.EventClean.infrastructure.exception.DuplicateEventException;

public class CriarEventoUseCaseImpl implements CriarEventoUseCase {

    private final EventoGateway eventoGateway;

    public CriarEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Event execute(Event event) {

        if (eventoGateway.existePorIdentificador(event.identificator())) {
            throw new DuplicateEventException("O identificador número: " + event.identificator() + " já está em uso por outro evento.");
        }
        return eventoGateway.criarEvento(event);
    }
}
