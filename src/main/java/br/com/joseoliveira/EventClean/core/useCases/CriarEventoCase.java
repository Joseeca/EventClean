package br.com.joseoliveira.EventClean.core.useCases;

import br.com.joseoliveira.EventClean.core.entities.Event;

public interface CriarEventoCase {

    public Event execute(Event event);
}