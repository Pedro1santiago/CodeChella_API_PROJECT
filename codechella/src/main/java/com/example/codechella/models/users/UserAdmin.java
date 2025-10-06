package com.example.codechella.models.users;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("usuario_adm")
public class UserAdmin implements UserBase{

    @Id
    private Long idUsuario;

    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario = TipoUsuario.ADMINISTRADOR;

    public UserAdmin(){}

    public UserAdmin( Long idUsuario, String nome, String email, String senha, TipoUsuario tipoUsuario){
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public Long getIdUsuario() {return idUsuario;}
    public void setIdUsuario(Long idUsuario){this.idUsuario = idUsuario;}

    @Override
    public String getNome() {return nome;}
    public void setNome(String nome){ this.nome = nome;}

    @Override
    public String getEmail() {return email;}
    public void setEmail(String email){this.email = email;}

    @Override
    public String getSenha() {return senha;}
    public void setSenha(String senha){this.senha = senha;}

    @Override
    public TipoUsuario getTipoUsuario() {return tipoUsuario;}
    public void setTipoUsuario(TipoUsuario tipoUsuario){this.tipoUsuario = TipoUsuario.ADMINISTRADOR;}
}
