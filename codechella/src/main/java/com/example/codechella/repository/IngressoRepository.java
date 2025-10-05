package com.example.codechella.repository;

import com.example.codechella.models.ingresso.Ingresso;
import com.example.codechella.models.ingresso.TipoStatus;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface IngressoRepository extends ReactiveCrudRepository<Ingresso, Long> {

     Flux<Ingresso> findByEventoIdAndStatus(Long eventoId, TipoStatus tipoStatus);
}
