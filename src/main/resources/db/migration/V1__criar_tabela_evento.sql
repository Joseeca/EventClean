-- V1__criar_tabela_evento.sql
CREATE TABLE Eventos (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    identificator VARCHAR(255) NOT NULL UNIQUE,
    data_inicio TIMESTAMP NOT NULL,
    data_fim TIMESTAMP NOT NULL,
    location VARCHAR(255) NOT NULL,
    capacity INTEGER NOT NULL,
    organizator VARCHAR(255) NOT NULL,
    tipo_evento VARCHAR(50) NOT NULL
);