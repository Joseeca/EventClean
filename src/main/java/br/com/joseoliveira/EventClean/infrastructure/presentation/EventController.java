package br.com.joseoliveira.EventClean.infrastructure.presentation;

import br.com.joseoliveira.EventClean.core.entities.Event;
import br.com.joseoliveira.EventClean.core.useCases.CriarEventoCase;
import br.com.joseoliveira.EventClean.infrastructure.dtos.EventoDto;
import br.com.joseoliveira.EventClean.infrastructure.mapper.EventoDtoMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@AllArgsConstructor
@RequiredArgsConstructor
public class EventController {

    private final CriarEventoCase criarEventoCase;
    private final EventoDtoMapper eventoDtoMapper;

    @PostMapping("criarevento")
    public EventoDto criarEvento(@RequestBody EventoDto eventoDto) {
        Event novoEvento = criarEventoCase.execute(eventoDtoMapper.toDomain(eventoDto));
        return eventoDtoMapper.toDto(novoEvento);
    }

}
