    DROP TABLE Perfil CASCADE CONSTRAINTS;

CREATE TABLE Perfil(
Id_perfil INTEGER GENERATED ALWAYS AS IDENTITY, 
Nombre VARCHAR2 (45) NOT NULL,
CONSTRAINT Perf_perfid_pk PRIMARY KEY (Id_perfil)
-- Administrador, dueño, usuario
);

   DROP TABLE Persona CASCADE CONSTRAINTS;

CREATE TABLE Persona(
Id_persona INTEGER GENERATED ALWAYS AS IDENTITY, --Autoincremental
Nombre VARCHAR2 (45) NOT NULL,
Apellido1 VARCHAR2 (45) NOT NULL,
Apellido2 VARCHAR2 (45),
Fecha_alta DATE NOT NULL,
Usuario VARCHAR2 (45) NOT NULL,
Contraseña VARCHAR2 (255) NOT NULL,
Email VARCHAR2 (60),
Id_perfil  INTEGER,
CONSTRAINT Pers_persid_pk PRIMARY KEY (Id_persona),
CONSTRAINT Pers_perfid_fk FOREIGN KEY (Id_perfil) REFERENCES Perfil (Id_perfil)
);

    DROP TABLE Equipo CASCADE CONSTRAINTS;

CREATE TABLE Equipo(
Id_equipo INTEGER GENERATED ALWAYS AS IDENTITY,
Nombre VARCHAR2 (45) NOT NULL,
Fecha_creacion DATE NOT NULL,
Comentario VARCHAR2 (150),
Id_persona INTEGER,
CONSTRAINT Equi_equid_pk PRIMARY KEY (Id_equipo),
CONSTRAINT Equi_persid_fk FOREIGN KEY (Id_persona) REFERENCES Persona (Id_persona)
);

INSERT INTO Equipo (Nombre, Fecha_creacion, Comentario, Id_persona) VALUES ('Equipo1', TO_DATE ('24/04/2018', 'DD/MM/YYYY'), NULL, NULL);
INSERT INTO Equipo (Nombre, Fecha_creacion, Comentario, Id_persona) VALUES ('Equipo2', TO_DATE ('20/04/2018', 'DD/MM/YYYY'), NULL, NULL);
INSERT INTO Equipo (Nombre, Fecha_creacion, Comentario, Id_persona) VALUES ('Equipo3', TO_DATE ('18/04/2018', 'DD/MM/YYYY'), NULL, NULL);
    
    DROP TABLE Jugador CASCADE CONSTRAINTS;

CREATE TABLE Jugador(
Id_jugador INTEGER GENERATED ALWAYS AS IDENTITY,
Dni VARCHAR2 (9) NOT NULL,
Nombre VARCHAR2 (45) NOT NULL,
Apellido1 VARCHAR2 (45) NOT NULL,
Apellido2 VARCHAR2 (45) NOT NULL,
Nickname VARCHAR2 (20) NOT NULL,
Sueldo NUMBER (8,2) NOT NULL,
Fecha_alta DATE NOT NULL,
Comentario VARCHAR2 (150),
Id_equipo INTEGER,
CONSTRAINT Jug_jugid_pk PRIMARY KEY (Id_jugador),
CONSTRAINT Jug_equid_fk FOREIGN KEY (Id_equipo) REFERENCES Equipo (Id_equipo)
);

INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario) VALUES ('72848256A','Mikel','Ferreiro','Guridi','Joylife',30000,TO_DATE(SYSDATE,'DD/MM/YYYY'),'Las rosas son rosas');
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario) VALUES ('62348256A','Yaiza','dasfo','Guridi','jaiz',30000,TO_DATE(SYSDATE,'DD/MM/YYYY'),'Las rosas son rojas');
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario) VALUES ('56878256A','JonXu','asd','Guridi','gold',30000,TO_DATE(SYSDATE,'DD/MM/YYYY'),'Las rosas son amarillas');
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario) VALUES ('42898256A','Imanol','fgh','Guridi','ima',30000,TO_DATE(SYSDATE,'DD/MM/YYYY'),'Las rosas son azules');
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario) VALUES ('35842556A','Mikel2','Ferreiro2','Guridi2','Joylife',30000,TO_DATE(SYSDATE,'DD/MM/YYYY'),'Las rosas son violetas');


    DROP TABLE Jornada CASCADE CONSTRAINTS;

CREATE TABLE Jornada(
Id_jornada INTEGER GENERATED ALWAYS AS IDENTITY,
CONSTRAINT Jorn_jornid_pk PRIMARY KEY (Id_jornada)
);

    DROP TABLE Partido CASCADE CONSTRAINTS;

CREATE TABLE Partido(
Id_partido INTEGER GENERATED ALWAYS AS IDENTITY,
Fecha DATE NOT NULL,
Lugar VARCHAR2 (30) NOT NULL,
Id_jornada INTEGER,
CONSTRAINT Part_partid_fk PRIMARY KEY (Id_partido),
CONSTRAINT Part_jornid_fk FOREIGN KEY (Id_jornada) REFERENCES Jornada (Id_jornada)
);

    DROP TABLE Marcador CASCADE CONSTRAINTS;

CREATE TABLE Marcador(
Id_marcador INTEGER GENERATED ALWAYS AS IDENTITY,
Puntuacion INTEGER NOT NULL,
Visitante NUMBER(1),
Id_partido INTEGER,
CONSTRAINT Marc_marcid_pk PRIMARY KEY (Id_marcador),
CONSTRAINT Marc_partid_fk FOREIGN KEY (Id_partido) REFERENCES Partido (Id_partido),
CONSTRAINT Marc_vis_ck CHECK (Visitante = 0 or Visitante = 1)
);


