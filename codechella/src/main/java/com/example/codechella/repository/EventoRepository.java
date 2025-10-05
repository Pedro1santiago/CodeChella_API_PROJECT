package com.example.codechella.repository;

import com.example.codechella.models.evento.Evento;
import com.example.codechella.models.evento.TipoEvento;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface EventoRepository extends ReactiveCrudRepository<Evento, Long> {
    Flux<Evento> findByTipo(TipoEvento tipoEvento);
}
