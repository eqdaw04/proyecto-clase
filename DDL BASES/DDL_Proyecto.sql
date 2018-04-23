
CREATE TABLE Persona(
Id_persona GENERATED ALWAYS AS IDENTITY, --Autoincremental
Nombre VARCHAR2 (45),
Apellido1 VARCHAR2 (45),
Apellido2 VARCHAR2 (45),
Fecha_alta DATE,
Usuario VARCHAR2 (45),
Contraseña VARCHAR2 (255),
Email VARCHAR2 (60),
Id_perfil  INTEGER,
CONSTRAINT Pers_persid_pk PRIMARY KEY (Id_persona),
CONSTRAINT Pers_perfid_fk FOREIGN KEY (Id_perfil) REFERENCES Perfil (Id_perfil)
);

CREATE TABLE Perfil(
Id_perfil GENERATED ALWAYS AS IDENTITY, --AUTOINCREMENTAL
Nombre VARCHAR2 (45),
CONSTRAINT Perf_perfid_pk PRIMARY KEY (Id_perfil)
-- Administrador, dueño, usuario
);

CREATE TABLE Equipo(
Id_equipo GENERATED ALWAYS AS IDENTITY, --Autoincremental
Nombre VARCHAR2 (45),
Fecha_creacion DATE,
Comentario VARCHAR2 (150),
Id_persona INTEGER,
CONSTRAINT Equi_equid_pk PRIMARY KEY (Id_equipo),
CONSTRAINT Equi_persid_fk FOREIGN KEY (Id_persona) REFERENCES Persona (Id_persona)
);

CREATE TABLE Jugador(
Id_jugador GENERATED ALWAYS AS IDENTITY, --Autoincremental
Nombre VARCHAR2 (45),
Apellido1 VARCHAR2 (45),
Apellido2 VARCHAR2 (45),
Nickname VARCHAR2 (20),
Sueldo NUMBER (3,2),
Fecha_alta DATE,
Comentario VARCHAR2 (150),
Id_equipo INTEGER,
CONSTRAINT Jug_jugid_pk PRIMARY KEY (Id_jugador),
CONSTRAINT Jug_equid_fk FOREIGN KEY (Id_equipo) REFERENCES Equipo (Id_equipo)
)