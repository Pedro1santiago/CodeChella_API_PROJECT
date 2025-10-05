create table ingressos (
    id bigserial not null,
    evento_id bigint not null,
    date date,
    quantidade integer not null,
    quantidade_total bigint not null,
    valor integer not null,
    descricao varchar(200) not null,
    status varchar(30) not null,
    primary key(id)
);
