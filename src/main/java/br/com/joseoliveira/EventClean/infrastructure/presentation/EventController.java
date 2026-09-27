package br.com.joseoliveira.EventClean.infrastructure.presentation;

import br.com.joseoliveira.EventClean.core.entities.Event;
import br.com.joseoliveira.EventClean.core.useCases.BuscarEventoUseCase;
import br.com.joseoliveira.EventClean.core.useCases.CriarEventoUseCase;
import br.com.joseoliveira.EventClean.core.useCases.FiltrarIdentificadorEventoUseCase;
import br.com.joseoliveira.EventClean.infrastructure.dtos.EventoDto;
import br.com.joseoliveira.EventClean.infrastructure.mapper.EventoDtoMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
public class EventController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final EventoDtoMapper eventoDtoMapper;
    private final BuscarEventoUseCase buscarEventoUseCase;
    private final FiltrarIdentificadorEventoUseCase filtrarIdentificadorEventoUseCase;

    public EventController(CriarEventoUseCase criarEventoUseCase, EventoDtoMapper eventoDtoMapper, BuscarEventoUseCase buscarEventoUseCase, FiltrarIdentificadorEventoUseCase filtrarIdentificadorEventoUseCase) {
        this.criarEventoUseCase = criarEventoUseCase;
        this.eventoDtoMapper = eventoDtoMapper;
        this.buscarEventoUseCase = buscarEventoUseCase;
        this.filtrarIdentificadorEventoUseCase = filtrarIdentificadorEventoUseCase;
    }

    @PostMapping("criarevento")
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDto eventoDto) {
        Event novoEvento = criarEventoUseCase.execute(eventoDtoMapper.toDomain(eventoDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message:", " Evento cadastrado com sucesso em nosso banco de dados.");
        response.put("Dados do evento:", eventoDtoMapper.toDto(novoEvento));
        return ResponseEntity.ok(response);
    }

    @GetMapping("buscarevento")
    public List<EventoDto> buscarEventos() {
        return buscarEventoUseCase.execute()
                .stream()
                .map(eventoDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("identificador/{identificador}")
    public ResponseEntity<Event> buscarPorIdentificador(@PathVariable String identificator) {
        Event event = filtrarIdentificadorEventoUseCase.execute(identificator);
        return ResponseEntity.ok(event);
    }
}