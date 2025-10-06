package com.example.codechella.models.users;

public interface UserBase {
    Long getIdUsuario();
    String getNome();
    String getEmail();
    String getSenha();
    TipoUsuario getTipoUsuario();
}
