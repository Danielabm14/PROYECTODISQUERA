CREATE DATABASE Disquera_Java;
USE Disquera_Java;

CREATE TABLE Disquera
(
	idDisquera INT PRIMARY KEY AUTO_INCREMENT,
	nitDisquera VARCHAR (20) NOT NULL,
    nombreDisquera VARCHAR (100) NOT NULL,
    telefonoDisquera INT NOT NULL,
    direccionDisquera VARCHAR (100) NOT NULL,
    estadoDisquera boolean
);

CREATE TABLE Artista
(
	idArtista INT PRIMARY KEY AUTO_INCREMENT,
    numeroDocumento INT NOT NULL,
    tipoDocumento VARCHAR (100) NOT NULL,
    nombreArtista VARCHAR (50) NOT NULL,
    apellidoArtista VARCHAR (50) NOT NULL,
    nombreArtistico VARCHAR (50) NOT NULL,
    fechaNacimiento DATE NOT NULL,
    emailArtista VARCHAR (100) NOT NULL,
    estadoArtista boolean
);

CREATE TABLE Album
(
	idAlbum INT PRIMARY KEY AUTO_INCREMENT,
    nombreAlbum VARCHAR (70) NOT NULL,
    anoPublicado YEAR NOT NULL,
    estadoAlbum boolean
);
     
insert into album values
(null,"Mariposa",2021, 1);

select * from album;
