create table cepbr_cidade (
    id_cidade int(6) PRIMARY KEY,
    cidade varchar(50),
    uf varchar(2)
);

create table cepbr_endereco (
    cep varchar(10) PRIMARY KEY,
    logradouro varchar(255),
    tipo_logradouro varchar (10),
    complemento varchar (255),
    local varchar(80),
    id_cidade int(6),
    id_bairro varchar (50)
);

create table cepbr_estado (
    uf varchar(2) PRIMARY KEY,
    estado varchar (20)
);

create table cidade_search (
    id_cidade int(6) PRIMARY KEY,
    estado varchar (20),
    cidade varchar(50)
);

create table codigo_telefone (
    estado varchar(2),
    cod_telefone int(2),
    PRIMARY KEY (estado, cod_telefone)
);