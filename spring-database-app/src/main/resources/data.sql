create table car (
	id integer not null,
	model varchar(20) not null,
	brand varchar(20) not null
	primary key(id)
);

INSERT INTO car (id, model, brand) VALUES
(10001, 'Civic', 'Honda'),
(10002, 'Model 3', 'Tesla'),
(10003, 'Corolla', 'Toyota');
