create database deer;

create table t_table_user
(
	id int auto_increment primary key,
	username varchar(50) not null,
	password varchar(64) not null
)

create table t_table_role
(
	id int auto_increment primary key,
	role varchar(24) not null
)

create table t_user_role
(
	user_id int not null,
	role_id int not null,
	CONSTRAINT primary key(user_id, role_id)
)