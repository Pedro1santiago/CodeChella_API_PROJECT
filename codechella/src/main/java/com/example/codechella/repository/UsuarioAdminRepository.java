package com.example.codechella.repository;

import com.example.codechella.models.users.UserAdmin;
import com.example.codechella.models.users.UsuarioDTO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UsuarioAdminRepository extends ReactiveCrudRepository<UserAdmin, Long > {
}
