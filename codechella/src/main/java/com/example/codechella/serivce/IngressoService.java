package com.example.codechella.serivce;

import com.example.codechella.models.ingresso.IngressoDTO;
import com.example.codechella.models.ingresso.TipoStatus;
import com.example.codechella.repository.IngressoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class IngressoService {

    @Autowired
    private IngressoRepository repository;

    public Mono<IngressoDTO> cadastrarIngresso(IngressoDTO dto) {
        var ingresso = dto.toEntity();
        ingresso.setStatus(TipoStatus.DISPONIVEL);
        return repository.save(ingresso).map(IngressoDTO::toDTO);
    }

    public Flux<IngressoDTO> listartodos() {
        return repository.findAll().map(IngressoDTO::toDTO);
    }

    public Flux<IngressoDTO> venderIngresso(Long eventoId, int quantidade) {
        return repository.findByEventoIdAndStatus(eventoId, TipoStatus.DISPONIVEL)
                .collectList()
                .flatMapMany(lista -> {
                    if (lista.size() < quantidade) {
                        return Flux.error(new IllegalArgumentException("Ingressos insuficientes disponíveis."));
                    }

                    var ingressosParaVender = lista.stream()
                            .limit(quantidade)
                            .toList();

                    return Flux.fromIterable(ingressosParaVender)
                            .flatMap(ingresso -> {
                                ingresso.setStatus(TipoStatus.VENDIDO);
                                return repository.save(ingresso);
                            })
                            .map(IngressoDTO::toDTO);
                });
    }

    public Mono<IngressoDTO> cancelarIngresso(Long ingressoId){
        return repository.findById(ingressoId).flatMap(ingresso ->{
            ingresso.setStatus(TipoStatus.DISPONIVEL);
            ingresso.setQuantidadeTotal(ingresso.getQuantidadeTotal()+1);
            return repository.save(ingresso);
        }).map(IngressoDTO::toDTO);


    }
}
