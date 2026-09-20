package br.com.joseoliveira.EventClean.core.gateway;

import br.com.joseoliveira.EventClean.core.entities.Event;

public interface EventoGateway {

    Event criarEvento(Event event);

}
