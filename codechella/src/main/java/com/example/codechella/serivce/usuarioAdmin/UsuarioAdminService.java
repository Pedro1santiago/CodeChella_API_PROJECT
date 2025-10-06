package com.example.codechella.serivce.usuarioAdmin;

import com.example.codechella.models.users.UsuarioDTO;
import com.example.codechella.repository.UsuarioAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class UsuarioAdminService {

    @Autowired
    UsuarioAdminRepository repository;

    public Flux<UsuarioDTO> listarTodos() {
        return repository.findAll().map(UsuarioDTO::toDTO);
    }
}
