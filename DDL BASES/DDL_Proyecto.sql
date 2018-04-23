
CREATE TABLE Persona (
Id_persona GENERATED ALWAYS AS IDENTITY, --Autoincremental
Nombre VARCHAR2 (45),
Apellido1 VARCHAR2 (45),
Apellido2 VARCHAR2 (45),
Fecha_alta DATE,
Usuario VARCHAR2 (45),
Contraseña VARCHAR2 (255),
Email VARCHAR2 (60),
Id_perfil  INTEGER,
CONSTRAINT Pers_id_pk PRIMARY KEY (Id_persona),
CONSTRAINT Pers_id_fk FOREIGN KEY (Id_perfil) REFERENCES Perfil (Id_perfil)
);

CREATE TABLE Perfil (
Id_perfil GENERATED ALWAYS AS IDENTITY, --AUTOINCREMENTAL
Nombre VARCHAR2 (45),
CONSTRAINT Perf_id_pk PRIMARY KEY (Id_perfil)
)