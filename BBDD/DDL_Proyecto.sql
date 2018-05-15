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
Usuario VARCHAR2 (45) NOT NULL,
Contrasenna VARCHAR2 (255) NOT NULL,
Email VARCHAR2 (60),
Id_perfil  INTEGER NOT NULL,
CONSTRAINT Pers_persid_pk PRIMARY KEY (Id_persona),
CONSTRAINT Pers_perfid_fk FOREIGN KEY (Id_perfil) REFERENCES Perfil (Id_perfil),
CONSTRAINT Pers_nom_ck  CHECK (Nombre = INITCAP(Nombre)),
CONSTRAINT Pers_ape1_ck  CHECK (Apellido1 = INITCAP(Apellido1)),
CONSTRAINT Pers_ape2_ck  CHECK (Apellido2 = INITCAP(Apellido2))
);

INSERT INTO Persona (Nombre, Apellido1, Fecha_alta, Usuario, Contrasenna, Id_perfil) VALUES ('Dueño1','Ape1',TO_DATE(SYSDATE,'DD/MM/YYYY'), 'dueño1','d1',2);
INSERT INTO Persona (Nombre, Apellido1, Fecha_alta, Usuario, Contrasenna, Id_perfil) VALUES ('Dueño2','Ape12',TO_DATE(SYSDATE,'DD/MM/YYYY'), 'dueño2','d2',2);
INSERT INTO Persona VALUES (DEFAULT,'Admin1','Apellidorandom',null,TO_DATE(SYSDATE,'DD/MM/YYYY'),'admin','root',null,1);
INSERT INTO Persona VALUES (DEFAULT,'Usuario1','Apellidorandom2',null,TO_DATE(SYSDATE,'DD/MM/YYYY'),'usu','sus',null,3);

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

INSERT INTO Equipo (Nombre,FECHA_CREACION,COMENTARIO,Lugar,Id_persona) VALUES ('Equipo1',TO_DATE(SYSDATE,'DD/MM/YYYY'),'Las rosas son rosas','Vitoria',1);
INSERT INTO Equipo (Nombre,FECHA_CREACION,COMENTARIO,Lugar,Id_persona) VALUES ('Equipo2',TO_DATE(SYSDATE,'DD/MM/YYYY'),'Las rosas son muy azules','Bilbao',2);

CREATE TABLE Jugador(
Id_jugador NUMBER (4) GENERATED ALWAYS AS IDENTITY,
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
CONSTRAINT Jug_equid_fk FOREIGN KEY (Id_equipo) REFERENCES Equipo (Id_equipo),
CONSTRAINT Jug_suel_ck CHECK (Sueldo > 735.90),
CONSTRAINT Jug_nom_ck CHECK (Nombre = INITCAP(Nombre)),
CONSTRAINT Jug_ape1_ck CHECK (Apellido1 = INITCAP(Apellido1)),
CONSTRAINT Jug_ape2_ck CHECK (Apellido2 = INITCAP(Apellido2))
);

INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario,ID_EQUIPO) VALUES ('72848256A','Mikel','Ferreiro','Guridi','Joylife',30000,TO_DATE(SYSDATE,'DD/MM/YYYY'),'Las rosas son rosas',1);
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario) VALUES ('62348256A','Yaiza','Dasfo','Guridi','Jaiz',30000,TO_DATE(SYSDATE,'DD/MM/YYYY'),'Las rosas son rojas');
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario) VALUES ('56878256A','Jonxu','Asd','Guridi','gold',30000,TO_DATE(SYSDATE,'DD/MM/YYYY'),'Las rosas son amarillas');
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario) VALUES ('42898256A','Imanol','Fgh','Guridi','ima',30000,TO_DATE(SYSDATE,'DD/MM/YYYY'),'Las rosas son azules');
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario,ID_EQUIPO) VALUES ('35842556A','Mikel2','Ferreiro2','Guridi2','Joylife2',30000,TO_DATE(SYSDATE,'DD/MM/YYYY'),'Las rosas son rosas2',2);
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario,ID_EQUIPO) VALUES ('25842553A','Mikel3','Ferreiro3','Guridi3','Joylife3',30000,TO_DATE(SYSDATE,'DD/MM/YYYY'),'Las rosas son rosas3',2);
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario) VALUES ('62348256A','Yaiza','Dasfo','Guridi','jaaaaaz',10000,TO_DATE(SYSDATE,'DD/MM/YYYY'),'Las rosas son rojas');
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario) VALUES ('56878256A','Jon','Asd','Guridi','luffie',10000,TO_DATE(SYSDATE,'DD/MM/YYYY'),'Las rosas son amarillas');
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario) VALUES ('42898256A','Imanol','Fgh','Guridi','asd',30000,TO_DATE(SYSDATE,'DD/MM/YYYY'),'Las rosas son azules');

CREATE TABLE Jornada(
Id_jornada NUMBER (2)  NOT NULL,
Fecha_inicio DATE NOT NULL,
Fecha_fin DATE,
CONSTRAINT Jorn_jornid_pk PRIMARY KEY (Id_jornada),
CONSTRAINT Jorn_fech_ck CHECK (Fecha_fin > Fecha_inicio)
);

INSERT INTO Jornada VALUES (1,TO_DATE(SYSDATE,'DD/MM/YYYY'),TO_DATE('26/12/2018','DD/MM/YYYY'));
INSERT INTO Jornada  VALUES (2,TO_DATE(SYSDATE,'DD/MM/YYYY'),TO_DATE('28/12/2018','DD/MM/YYYY'));

CREATE TABLE Partido(
Id_partido NUMBER (4) NOT NULL,
Fecha TIMESTAMP NOT NULL,
Id_jornada INTEGER NOT NULL,
CONSTRAINT Part_partid_fk PRIMARY KEY (Id_partido),
CONSTRAINT Part_jornid_fk FOREIGN KEY (Id_jornada) REFERENCES Jornada (Id_jornada)
);
INSERT INTO Partido VALUES (1,TO_TIMESTAMP(SYSDATE,'DD/MM/YYYY HH24:MI:SS.FF'),1);
INSERT INTO Partido VALUES (2,TO_TIMESTAMP(SYSDATE,'DD/MM/YYYY HH24:MI:SS.FF'),1);
INSERT INTO Partido VALUES (3,TO_TIMESTAMP(SYSDATE,'DD/MM/YYYY HH24:MI:SS.FF'),1);
INSERT INTO Partido VALUES (4,TO_TIMESTAMP(SYSDATE,'DD/MM/YYYY HH24:MI:SS.FF'),1);
INSERT INTO Partido VALUES (5,TO_TIMESTAMP(SYSDATE,'DD/MM/YYYY HH24:MI:SS.FF'),2);
INSERT INTO Partido VALUES (6,TO_TIMESTAMP(SYSDATE,'DD/MM/YYYY HH24:MI:SS.FF'),2);
INSERT INTO Partido VALUES (7,TO_TIMESTAMP(SYSDATE,'DD/MM/YYYY HH24:MI:SS.FF'),2);
INSERT INTO Partido VALUES (8,TO_TIMESTAMP(SYSDATE,'DD/MM/YYYY HH24:MI:SS.FF'),2);

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

INSERT INTO MARCADOR VALUES (DEFAULT,10,0,1,1);
INSERT INTO MARCADOR VALUES (DEFAULT,30,1,1,2);
INSERT INTO MARCADOR VALUES (DEFAULT,22,0,2,2);
INSERT INTO MARCADOR VALUES (DEFAULT,15,1,2,1);
INSERT INTO MARCADOR VALUES (DEFAULT,20,0,3,1);
INSERT INTO MARCADOR VALUES (DEFAULT,40,1,3,2);
INSERT INTO MARCADOR VALUES (DEFAULT,14,0,4,2);
INSERT INTO MARCADOR VALUES (DEFAULT,12,1,4,1);

