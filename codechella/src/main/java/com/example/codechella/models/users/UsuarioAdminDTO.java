package com.example.codechella.models.users;

public record UsuarioAdminDTO(Long id, String nome, String email, String senha, TipoUsuario tipoUsuario) {

    public static UsuarioAdminDTO toDTO(UserAdmin userAdmin) {
        return new UsuarioAdminDTO(
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

