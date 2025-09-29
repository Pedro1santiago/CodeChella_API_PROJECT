package com.example.codechella.serivce;

import com.example.codechella.models.Evento;
import com.example.codechella.models.EventoDTO;
import com.example.codechella.models.TipoEvento;
import com.example.codechella.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public class EventoService {
    @Autowired
    private EventoRepository repository;

    public Flux<EventoDTO> listarTodos(){
        return repository.findAll().map(EventoDTO::toDto);
    }

    public Mono<EventoDTO> buscarPorId(Long id){
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map(EventoDTO::toDto);
    }

    public Mono<EventoDTO> cadastrarEvento(EventoDTO dto){
        return repository.save(dto.toEntity()).map(EventoDTO::toDto);
    }

    public Mono<Void> excluir(Long id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .flatMap(repository::delete);
    }

    public Mono<EventoDTO> atualizarId(Long id, EventoDTO dto){
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .flatMap( eventoExistente -> {
                eventoExistente.setTipo(dto.tipo());
                eventoExistente.setNome(dto.nome());
                eventoExistente.setData(dto.data());
                eventoExistente.setDescricao(dto.descricao());
                return repository.save(eventoExistente);
            }).map(EventoDTO::toDto);
    }
}
