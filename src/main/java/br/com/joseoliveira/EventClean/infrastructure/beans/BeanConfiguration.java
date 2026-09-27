package br.com.joseoliveira.EventClean.infrastructure.beans;

import br.com.joseoliveira.EventClean.core.gateway.EventoGateway;
import br.com.joseoliveira.EventClean.core.useCases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoUseCase criarEventoUseCase(EventoGateway eventoGateway) {
        return new CriarEventoUseCaseImpl(eventoGateway);
    }

    @Bean
    public BuscarEventoUseCase buscarEventoUseCase(EventoGateway eventoGateway) {
        return new BuscarEventoUseCaseImpl(eventoGateway);
    }

    @Bean
    public FiltrarIdentificadorEventoUseCase filtrarIdentificadorEventoUseCase(EventoGateway eventoGateway) {
        return new FiltrarIdentificadorEventoUseCaseImpl(eventoGateway);
    }
}
