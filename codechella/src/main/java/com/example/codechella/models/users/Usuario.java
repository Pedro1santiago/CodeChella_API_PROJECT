package com.example.codechella.models.users;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("usuario")
public class Usuario implements UserBase {

    @Id
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario = TipoUsuario.USUARIO;

    public Usuario(){}

    public Usuario(Long id, String nome, String email, String senha, TipoUsuario tipoUsuario){}

    @Override
    public Long getIdUsuario() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    @Override
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario){
        this.tipoUsuario = TipoUsuario.USUARIO;
    }
}
