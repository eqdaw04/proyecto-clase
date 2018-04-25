-- Generado por Oracle SQL Developer Data Modeler 18.1.0.082.1035
--   en:        2018-04-25 09:18:55 CEST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



CREATE TABLE equipo (
    id_equipo            INTEGER NOT NULL,
    nombre               VARCHAR2(30) NOT NULL,
    fecha_creacion       DATE NOT NULL,
    comentario           VARCHAR2(300),
    persona_id_persona   INTEGER NOT NULL
);

CREATE UNIQUE INDEX equipo__idx ON
    equipo (
        persona_id_persona
    ASC );

ALTER TABLE equipo ADD CONSTRAINT equipo_pk PRIMARY KEY ( id_equipo );

CREATE TABLE jornada (
    id_jornada   INTEGER NOT NULL
);

ALTER TABLE jornada ADD CONSTRAINT jornada_pk PRIMARY KEY ( id_jornada );

CREATE TABLE jugador (
    id_jugador         INTEGER NOT NULL,
    dni                VARCHAR2(9) NOT NULL,
    nombre             VARCHAR2(30) NOT NULL,
    apellido1          VARCHAR2(30) NOT NULL,
    apellido2          VARCHAR2(30) NOT NULL,
    nickname           VARCHAR2(30) NOT NULL,
    sueldo             INTEGER NOT NULL,
    fechaalta          DATE NOT NULL,
    comentario         VARCHAR2(300),
    equipo_id_equipo   INTEGER NOT NULL
);

ALTER TABLE jugador ADD CONSTRAINT jugador_pk PRIMARY KEY ( id_jugador );

CREATE TABLE marcador (
    equipo_id_equipo     INTEGER NOT NULL,
    partido_id_partido   INTEGER NOT NULL,
    puntuacion           INTEGER NOT NULL,
    visitante            CHAR(1)
);

ALTER TABLE marcador ADD CONSTRAINT marcador_pk PRIMARY KEY ( equipo_id_equipo,
                                                              partido_id_partido );

CREATE TABLE partido (
    id_partido           INTEGER NOT NULL,
    fecha                DATE NOT NULL,
    hora                 TIMESTAMP WITH TIME ZONE NOT NULL,
    lugar                VARCHAR2(45) NOT NULL,
    jornada_id_jornada   INTEGER NOT NULL
);

ALTER TABLE partido ADD CONSTRAINT partido_pk PRIMARY KEY ( id_partido );

CREATE TABLE perfil (
    id_perfil   INTEGER NOT NULL,
    nombre      VARCHAR2 
--  ERROR: VARCHAR2 size not specified 
     NOT NULL
);

ALTER TABLE perfil ADD CONSTRAINT perfil_pk PRIMARY KEY ( id_perfil );

CREATE TABLE persona (
    id_persona         INTEGER NOT NULL,
    nombre             VARCHAR2(30) NOT NULL,
    apellido1          VARCHAR2(30) NOT NULL,
    apellido2          VARCHAR2(30),
    fecha_alta         DATE NOT NULL,
    usuario            VARCHAR2(30) NOT NULL,
    contrasena         VARCHAR2(30) NOT NULL,
    perfil_id_perfil   INTEGER NOT NULL,
    email              VARCHAR2(50)
);

ALTER TABLE persona ADD CONSTRAINT persona_pk PRIMARY KEY ( id_persona );

ALTER TABLE equipo
    ADD CONSTRAINT equipo_persona_fk FOREIGN KEY ( persona_id_persona )
        REFERENCES persona ( id_persona );

ALTER TABLE jugador
    ADD CONSTRAINT jugador_equipo_fk FOREIGN KEY ( equipo_id_equipo )
        REFERENCES equipo ( id_equipo );

ALTER TABLE marcador
    ADD CONSTRAINT marcador_equipo_fk FOREIGN KEY ( equipo_id_equipo )
        REFERENCES equipo ( id_equipo );

ALTER TABLE marcador
    ADD CONSTRAINT marcador_partido_fk FOREIGN KEY ( partido_id_partido )
        REFERENCES partido ( id_partido );

ALTER TABLE partido
    ADD CONSTRAINT partido_jornada_fk FOREIGN KEY ( jornada_id_jornada )
        REFERENCES jornada ( id_jornada );

ALTER TABLE persona
    ADD CONSTRAINT persona_perfil_fk FOREIGN KEY ( perfil_id_perfil )
        REFERENCES perfil ( id_perfil );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                             1
-- ALTER TABLE                             13
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   1
-- WARNINGS                                 0
