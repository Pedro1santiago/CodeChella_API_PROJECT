package com.example.codechella.controller.usuarioAdmin;

import com.example.codechella.models.evento.EventoDTO;
import com.example.codechella.models.ingresso.IngressoDTO;
import com.example.codechella.models.users.CadastroEventoRequest;
import com.example.codechella.models.users.UserAdmin;
import com.example.codechella.models.users.UsuarioDTO;
import com.example.codechella.serivce.eventoService.EventoService;
import com.example.codechella.serivce.ingressoService.IngressoService;
import com.example.codechella.serivce.usuarioAdmin.UsuarioAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/usuario/Admin")
public class UsuarioAdminController {

    @Autowired
    EventoService eventoService;

    @Autowired
    UsuarioAdminService usuarioAdminService;

    @Autowired
    IngressoService ingressoService;

    @PostMapping("/cadastrar/evento")
    public Mono<EventoDTO> cadastrar(@RequestBody CadastroEventoRequest request){
        return eventoService.cadastrarEvento(request.userAdmin(), request.eventoDTO());
    }

    @GetMapping("/listarTodos/eventos")
    public Flux<EventoDTO> listarEventos(){
        return eventoService.listarTodos();
    }

    @GetMapping("/listarTodos/usuarios")
    public Flux<UsuarioDTO> listarUsuarios(){
        return usuarioAdminService.listarTodos();
    }

    @GetMapping("/listarTodos/ingressos")
    public Flux<IngressoDTO> listarIngressos(){
        return ingressoService.listarTodos();
    }



    @DeleteMapping("/excluir/evento/{id}")
    public Mono<Void> excluirEvento(@PathVariable Long id, @RequestBody UserAdmin userAdmin){
        return eventoService.excluir(id, userAdmin);
    }

    @DeleteMapping("/cancelar/ingresso/{id}")
    public Mono<IngressoDTO> cancelarIngresso(Long id){
        return ingressoService.cancelarIngresso(id);
    }

}

