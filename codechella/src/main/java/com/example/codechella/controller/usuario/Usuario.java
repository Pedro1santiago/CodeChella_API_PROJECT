package com.example.codechella.controller.usuario;

import com.example.codechella.models.users.UsuarioAdminDTO;
import com.example.codechella.models.users.UsuarioDTO;
import com.example.codechella.serivce.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/usuario")
public class Usuario {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/cadastrar/usuario")
    public Mono<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO usuario){
        return usuarioService.cadastrar(usuario);
    }
}
