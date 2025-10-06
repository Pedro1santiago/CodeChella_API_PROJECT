package com.example.codechella.models.users;

public record UsuarioDTO(Long id, String nome, String email, String senha, TipoUsuario tipoUsuario) {

    public static UsuarioDTO toDTO(UserAdmin userAdmin) {
        return new UsuarioDTO(
                userAdmin.getIdUsuario(),
                userAdmin.getNome(),
                userAdmin.getEmail(),
                userAdmin.getSenha(),
                userAdmin.getTipoUsuario()
        );
    }

    public UserAdmin toEntity() {
        UserAdmin userAdmin = new UserAdmin();
        userAdmin.setIdUsuario(this.id);
        userAdmin.setNome(this.nome);
        userAdmin.setEmail(this.email);
        userAdmin.setSenha(this.senha);
        userAdmin.setTipoUsuario(this.tipoUsuario);
        return userAdmin;
    }
}

