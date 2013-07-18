create table persona (
	id int not null,
	nombre varchar(255) null,
	apellido varchar(255) null,
	edad int null,
	primary key (id)
);

create table usuario (
	id int not null,
	nickname varchar(255) not null,
	password varchar(255) not null,
	primary key (id),
	foreign key (id) references persona(id)
);

create table usuario_sigue_usuario (
	id_usuario_seguidor int not null,
	id_usuario_seguido int not null,
	primary key (id_usuario_seguidor, id_usuario_seguido)
	foreign key (id_usuario_seguidor) references usuario (id),
	foreign key (id_usuario_seguido) references usuario (id)
);

create table mensaje (
	id int not null,
	mensaje varchar(140) not null,
	id_usuario int not null,
	primary key (id)
	foreign key (id_usuario) references usuario (id)
);

insert into persona values (1,'Cosme', 'Fulanito', 42);