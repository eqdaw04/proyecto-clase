DROP TABLE Marcador CASCADE CONSTRAINTS;
DROP TABLE Partido CASCADE CONSTRAINTS;
DROP TABLE Jornada CASCADE CONSTRAINTS;
DROP TABLE Jugador CASCADE CONSTRAINTS;
DROP TABLE Equipo CASCADE CONSTRAINTS;
DROP TABLE Persona CASCADE CONSTRAINTS;
DROP TABLE Perfil CASCADE CONSTRAINTS;

CREATE TABLE Perfil(
Id_perfil NUMBER (1) GENERATED ALWAYS AS IDENTITY, 
Nombre VARCHAR2 (45) NOT NULL,
CONSTRAINT Perf_perfid_pk PRIMARY KEY (Id_perfil),
-- Administrador, dueño, usuario
CONSTRAINT Perf_nom_ck Check (Nombre = INITCAP(Nombre))
);
INSERT INTO Perfil (Nombre) VALUES ('Admin');
INSERT INTO Perfil (Nombre) VALUES ('Dueño');
INSERT INTO Perfil VALUES (DEFAULT,'Usuario');

CREATE TABLE Persona(
Id_persona NUMBER (4) GENERATED ALWAYS AS IDENTITY, --Autoincremental
Nombre VARCHAR2 (45) NOT NULL,
Apellido1 VARCHAR2 (45) NOT NULL,
Apellido2 VARCHAR2 (45),
Fecha_alta DATE NOT NULL,
Usuario VARCHAR2 (45) NOT NULL UNIQUE,
Contrasenna VARCHAR2 (255) NOT NULL,
Email VARCHAR2 (60),
Id_perfil  INTEGER NOT NULL,
CONSTRAINT Pers_persid_pk PRIMARY KEY (Id_persona),
CONSTRAINT Pers_perfid_fk FOREIGN KEY (Id_perfil) REFERENCES Perfil (Id_perfil),
CONSTRAINT Pers_nom_ck  CHECK (Nombre = INITCAP(Nombre)),
CONSTRAINT Pers_ape1_ck  CHECK (Apellido1 = INITCAP(Apellido1)),
CONSTRAINT Pers_ape2_ck  CHECK (Apellido2 = INITCAP(Apellido2))
);

INSERT INTO Persona VALUES (DEFAULT,'Admin1','Apellidorandom',null,TO_DATE(SYSDATE,'DD/MM/RRRR'),'admin','root',null,1);

CREATE TABLE Equipo(
Id_equipo NUMBER (3)GENERATED ALWAYS AS IDENTITY,
Nombre VARCHAR2 (45) NOT NULL,
Fecha_creacion DATE NOT NULL,
Comentario VARCHAR2 (150),
Lugar VARCHAR2 (45) NOT NULL,
Id_persona INTEGER NOT NULL,
CONSTRAINT Equi_equid_pk PRIMARY KEY (Id_equipo),
CONSTRAINT Equi_persid_fk FOREIGN KEY (Id_persona) REFERENCES Persona (Id_persona),
CONSTRAINT Equi_nom_ck  CHECK (Nombre = INITCAP(Nombre))
);


CREATE TABLE Jugador(
Id_jugador NUMBER (4) GENERATED ALWAYS AS IDENTITY,
Dni VARCHAR2 (9) NOT NULL,
Nombre VARCHAR2 (45) NOT NULL,
Apellido1 VARCHAR2 (45) NOT NULL,
Apellido2 VARCHAR2 (45) NOT NULL,
Nickname VARCHAR2 (20) NOT NULL UNIQUE,
Sueldo NUMBER (8,2) NOT NULL,
Fecha_alta DATE NOT NULL,
Comentario VARCHAR2 (150),
Id_equipo INTEGER,
CONSTRAINT Jug_jugid_pk PRIMARY KEY (Id_jugador),
CONSTRAINT Jug_equid_fk FOREIGN KEY (Id_equipo) REFERENCES Equipo (Id_equipo),
CONSTRAINT Jug_suel_ck CHECK (Sueldo > 735.90),
CONSTRAINT Jug_nom_ck CHECK (Nombre = INITCAP(Nombre)),
CONSTRAINT Jug_ape1_ck CHECK (Apellido1 = INITCAP(Apellido1)),
CONSTRAINT Jug_ape2_ck CHECK (Apellido2 = INITCAP(Apellido2))
);


CREATE TABLE Jornada(
Id_jornada NUMBER (2)  NOT NULL,
Fecha_inicio DATE NOT NULL,
Fecha_fin DATE,
CONSTRAINT Jorn_jornid_pk PRIMARY KEY (Id_jornada),
CONSTRAINT Jorn_fech_ck CHECK (Fecha_fin > Fecha_inicio)
);


CREATE TABLE Partido(
Id_partido NUMBER (4) NOT NULL,
Fecha TIMESTAMP NOT NULL,
Id_jornada INTEGER NOT NULL,
CONSTRAINT Part_partid_fk PRIMARY KEY (Id_partido),
CONSTRAINT Part_jornid_fk FOREIGN KEY (Id_jornada) REFERENCES Jornada (Id_jornada)
);

CREATE TABLE Marcador(
Id_marcador NUMBER (3) GENERATED ALWAYS AS IDENTITY,
Puntuacion INTEGER NOT NULL,
Visitante NUMBER(1),
Id_partido INTEGER NOT NULL,
Id_equipo INTEGER NOT NULL,
CONSTRAINT Marc_marcid_pk PRIMARY KEY (Id_marcador),
CONSTRAINT Marc_partid_fk FOREIGN KEY (Id_partido) REFERENCES Partido (Id_partido),
CONSTRAINT Marc_equi_fk FOREIGN KEY (Id_equipo) REFERENCES Equipo (Id_equipo),
-- Cuando visitante es = 0 , el equipo al que hace referenia el marcador (Foreign Key de Id_equipo) juega como Local
CONSTRAINT Marc_vis_ck CHECK (Visitante = 0 or Visitante = 1)
);

