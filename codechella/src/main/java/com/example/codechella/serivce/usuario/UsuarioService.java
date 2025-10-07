package com.example.codechella.serivce.usuario;

import com.example.codechella.models.users.TipoUsuario;
import com.example.codechella.models.users.Usuario;
import com.example.codechella.models.users.UsuarioDTO;
import com.example.codechella.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Mono<UsuarioDTO> cadastrar(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioDTO.toEntity();
        usuario.setTipoUsuario(TipoUsuario.USUARIO);
        return usuarioRepository.save(usuario).map(UsuarioDTO::toDTO);
    }
}
