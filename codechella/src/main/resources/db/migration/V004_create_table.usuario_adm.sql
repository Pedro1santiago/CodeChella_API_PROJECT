CREATE TABLE usuario_admin (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    tipo_usuario VARCHAR(30) NOT NULL CHECK (tipo_usuario IN ('ADMINISTRADOR'))
);


