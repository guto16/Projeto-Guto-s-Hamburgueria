drop database regist;
drop user 'cliente';

create database regist;

CREATE USER 'Cliente'@'localhost' IDENTIFIED BY '159';
GRANT ALL PRIVILEGES ON * . * TO 'Cliente'@'localhost';
FLUSH PRIVILEGES;

use regist;

create table clientData (
	id int auto_increment primary key,
    nameClient varchar(30),
	address varchar(40),
	phone varchar(15)
);