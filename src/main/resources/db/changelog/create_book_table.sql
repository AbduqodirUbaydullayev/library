--liquibase formatted sql
--changeset abduqodir:LIB-1

create table books (
    id BIGSERIAL not null PRIMARY KEY,
    title varchar(150) not null,
    author varchar(150) not null,
    description varchar(150)
);