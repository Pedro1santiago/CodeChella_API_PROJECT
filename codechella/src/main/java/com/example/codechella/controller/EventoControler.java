package com.example.codechella.controller;

import com.example.codechella.models.EventoDTO;
import com.example.codechella.serivce.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/eventos")
public class EventoControler {

    @Autowired
    EventoService service;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventoDTO> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Mono<EventoDTO> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping()
    public Mono<EventoDTO> cadastrar(@RequestBody EventoDTO dto){
        return service.cadastrarEvento(dto);
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
