package com.example.codechella.models.users;

import com.example.codechella.models.evento.EventoDTO;

public record CadastroEventoRequest(UserAdmin userAdmin, EventoDTO eventoDTO) {
}
