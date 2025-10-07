package com.example.codechella.models.evento;

import java.time.LocalDate;

public record EventoDTO(Long id, TipoEvento tipo, String nome, LocalDate data, String descricao, StatusEvento statusEvento) {

    public static EventoDTO toDto(Evento evento){
        return new EventoDTO(evento.getId(), evento.getTipo(), evento.getNome(), evento.getData(), evento.getDescricao(), evento.getStatusEvento());
    }

    public Evento toEntity(){
        Evento evento = new Evento();
        evento.setId(this.id);
        evento.setTipo(this.tipo);
        evento.setNome(this.nome);
        evento.setData(this.data);
        evento.setDescricao(this.descricao);
        evento.setStatusEvento(this.statusEvento);
        return evento;
    }
}
