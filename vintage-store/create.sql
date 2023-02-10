create sequence hibernate_sequence start 1 increment 1;
create table Customer (id int8 not null, createdDate timestamp, email varchar(255), firstName varchar(255), lastName varchar(255), primary key (id));
create table Publisher (id int8 not null, createdDate timestamp, name varchar(255), primary key (id));
create table t_artist (id int8 not null, bio varchar(255), createdDate timestamp, name varchar(255), primary key (id));
