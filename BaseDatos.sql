drop table if exists cuenta cascade
drop table if exists movimiento cascade
drop sequence if exists cuenta_seq
drop sequence if exists movimiento_seq
create sequence cuenta_seq start with 1 increment by 50
create sequence movimiento_seq start with 1 increment by 50
create table cuenta (estado boolean not null, saldo_inicial numeric(38,2), tipo_cuenta smallint check (tipo_cuenta between 0 and 1), id bigint not null, id_cliente bigint, version bigint, numero_cuenta varchar(255), primary key (id))
create table movimiento (saldo numeric(38,2), tipo_movimiento smallint check (tipo_movimiento between 0 and 1), valor numeric(38,2), cuenta_id bigint, fecha_movimiento timestamp(6), id bigint not null, version bigint, primary key (id))
alter table if exists movimiento add constraint FK4ea11fe7p3xa1kwwmdgi9f2fi foreign key (cuenta_id) references cuenta