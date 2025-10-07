package com.example.codechella.serivce.usuarioAdmin;

import com.example.codechella.models.users.UsuarioAdminDTO;
import com.example.codechella.repository.UsuarioAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class UsuarioAdminService {

    @Autowired
    UsuarioAdminRepository repository;

    public Flux<UsuarioAdminDTO> listarTodos() {
        return repository.findAll().map(UsuarioAdminDTO::toDTO);
    }
}
