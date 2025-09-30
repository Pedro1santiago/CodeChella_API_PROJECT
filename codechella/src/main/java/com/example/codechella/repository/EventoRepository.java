package com.example.codechella.repository;

import com.example.codechella.models.Evento;
import com.example.codechella.models.TipoEvento;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface EventoRepository extends ReactiveCrudRepository<Evento, Long> {
    Flux<Evento> findByTipo(TipoEvento tipoEvento);
}
