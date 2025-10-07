package com.example.codechella.repository;

import com.example.codechella.models.users.Usuario;
import com.example.codechella.models.users.UsuarioDTO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, Long> {
}
