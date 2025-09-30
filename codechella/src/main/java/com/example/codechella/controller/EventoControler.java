package com.example.codechella.controller;

import com.example.codechella.models.EventoDTO;
import com.example.codechella.repository.EventoRepository;
import com.example.codechella.serivce.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.Duration;

@RestController
@RequestMapping("/eventos")
public class EventoControler {

    private final EventoService service;

    private final Sinks.Many<EventoDTO> eventoSink;

    public EventoControler(EventoService service) {
        this.service = service;
        this.eventoSink = Sinks.many().multicast().onBackpressureBuffer();
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventoDTO> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping(value = "/categoria/{tipo}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventoDTO> obterPorTipo(@PathVariable String tipo){
        return Flux.merge(service.obterPorTipo(tipo), eventoSink.asFlux())
                .delayElements(Duration.ofSeconds(4));
    }

    @GetMapping("/{id}")
    public Mono<EventoDTO> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping()
    public Mono<EventoDTO> cadastrar(@RequestBody EventoDTO dto){
        return service.cadastrarEvento(dto)
                .doOnSuccess( e -> eventoSink.tryEmitNext(e));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> excluir(@PathVariable Long id){
        return service.excluir(id);
    }

    @PutMapping("/{id}")
    public Mono<EventoDTO> atualizar(@PathVariable Long id, @RequestBody EventoDTO dto){
        return service.atualizarId(id, dto);
    }

}
