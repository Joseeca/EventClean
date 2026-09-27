package br.com.joseoliveira.EventClean.core.useCases;

import br.com.joseoliveira.EventClean.core.entities.Event;
import br.com.joseoliveira.EventClean.core.gateway.EventoGateway;
import br.com.joseoliveira.EventClean.infrastructure.exception.DuplicateEventException;
import br.com.joseoliveira.EventClean.infrastructure.exception.NotFoundEventException;

public class FiltrarIdentificadorEventoUseCaseImpl implements FiltrarIdentificadorEventoUseCase {

    private final EventoGateway eventoGateway;

    public FiltrarIdentificadorEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Event execute(String identificator) {
        return eventoGateway.filtrarPorIdentificador(identificator)
                .orElseThrow(() -> new NotFoundEventException("Evento com identificador: " + identificator + " não encontrando"));
    }
}
