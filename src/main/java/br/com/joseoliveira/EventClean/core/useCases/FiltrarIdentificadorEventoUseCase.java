package br.com.joseoliveira.EventClean.core.useCases;

import br.com.joseoliveira.EventClean.core.entities.Event;

public interface FiltrarIdentificadorEventoUseCase {

    public Event execute(String identificator);

}