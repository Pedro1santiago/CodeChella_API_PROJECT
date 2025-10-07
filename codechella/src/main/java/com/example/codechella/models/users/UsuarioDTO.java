package com.example.codechella.models.users;

public record UsuarioDTO(Long id, String nome, String email, String senha,  TipoUsuario tipoUsuario) {

    public static UsuarioDTO toDTO(Usuario usuario){
        return new UsuarioDTO(usuario.getIdUsuario(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getTipoUsuario());
    }

    public Usuario toEntity(){
        Usuario usuario = new Usuario();
        usuario.setId(this.id);
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        usuario.setTipoUsuario(this.tipoUsuario);
        return usuario;
    }
}


