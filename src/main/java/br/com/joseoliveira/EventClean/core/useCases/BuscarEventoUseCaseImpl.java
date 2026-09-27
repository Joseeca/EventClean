package br.com.joseoliveira.EventClean.core.useCases;

import br.com.joseoliveira.EventClean.core.entities.Event;
import br.com.joseoliveira.EventClean.core.gateway.EventoGateway;

import java.util.List;

public class BuscarEventoUseCaseImpl implements BuscarEventoUseCase {

    private final EventoGateway eventoGateway;

    public BuscarEventoUseCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public List<Event> execute() {
        return eventoGateway.buscarEventos();
    }
}
