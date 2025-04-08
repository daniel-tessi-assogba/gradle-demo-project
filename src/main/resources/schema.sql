CREATE SCHEMA IF NOT EXISTS tenant1;
CREATE SCHEMA IF NOT EXISTS tenant2;
CREATE SCHEMA IF NOT EXISTS tenant3;

CREATE TABLE IF NOT EXISTS tenant1.tenant
(
    id    integer primary key,
    name  varchar(64)  not null,
    age   integer      not null,
    email varchar(265) not null
);

CREATE TABLE IF NOT EXISTS tenant2.tenant
(
    id    integer primary key,
    name  varchar(64)  not null,
    age   integer      not null,
    email varchar(265) not null
);

CREATE TABLE IF NOT EXISTS tenant3.tenant
(
    id    integer primary key,
    name  varchar(64)  not null,
    age   integer      not null,
    email varchar(265) not null
);

CREATE TABLE IF NOT EXISTS public.tenant
(
    id    integer primary key,
    name  varchar(64)  not null,
    age   integer      not null,
    email varchar(265) not null
);

CREATE SEQUENCE IF NOT EXISTS  tenant1.tenant_id_seq;
CREATE SEQUENCE IF NOT EXISTS  tenant2.tenant_id_seq;
CREATE SEQUENCE IF NOT EXISTS  tenant3.tenant_id_seq;
CREATE SEQUENCE IF NOT EXISTS  public.tenant_id_seq;
