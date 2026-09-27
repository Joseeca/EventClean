package br.com.joseoliveira.EventClean.core.gateway;

import br.com.joseoliveira.EventClean.core.entities.Event;

import java.util.List;
import java.util.Optional;

public interface EventoGateway {

    Optional<Event> filtrarPorIdentificador(String identificator);
    Event criarEvento(Event event);
    List<Event> buscarEventos();
    boolean existePorIdentificador(String identificador);
}
