package br.com.joseoliveira.EventClean.core.useCases;

import br.com.joseoliveira.EventClean.core.entities.Event;

import java.util.List;

public interface BuscarEventoUseCase {

    public List<Event> execute();
}
