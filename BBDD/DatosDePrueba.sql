--Insert de personas
INSERT INTO Persona VALUES (DEFAULT,'Usuario1','Apellidorandom2',null,TO_DATE(SYSDATE,'DD/MM/RRRR'),'usu','sus',null,3);
INSERT INTO Persona (Nombre, Apellido1, Fecha_alta, Usuario, Contrasenna, Id_perfil) VALUES ('Dueño1','Ape1',TO_DATE(SYSDATE,'DD/MM/RRRR'), 'dueño1','d1',2);
INSERT INTO Persona (Nombre, Apellido1, Fecha_alta, Usuario, Contrasenna, Id_perfil) VALUES ('Dueño2','Ape12',TO_DATE(SYSDATE,'DD/MM/RRRR'), 'dueño2','d2',2);
INSERT INTO Persona (Nombre, Apellido1, Fecha_alta, Usuario, Contrasenna, Id_perfil) VALUES ('Dueño3','Apellido',TO_DATE(SYSDATE,'DD/MM/RRRR'), 'd3','d3',2);
INSERT INTO Persona (Nombre, Apellido1, Fecha_alta, Usuario, Contrasenna, Id_perfil) VALUES ('Dueño4','Apellido',TO_DATE(SYSDATE,'DD/MM/RRRR'), 'd4','d4',2);
INSERT INTO Persona (Nombre, Apellido1, Fecha_alta, Usuario, Contrasenna, Id_perfil) VALUES ('Dueño5','Apellido',TO_DATE(SYSDATE,'DD/MM/RRRR'), 'd5','d5',2);
INSERT INTO Persona (Nombre, Apellido1, Fecha_alta, Usuario, Contrasenna, Id_perfil) VALUES ('Dueño6','Apellido',TO_DATE(SYSDATE,'DD/MM/RRRR'), 'd6','d6',2);
INSERT INTO Persona (Nombre, Apellido1, Fecha_alta, Usuario, Contrasenna, Id_perfil) VALUES ('Dueño7','Apellido',TO_DATE(SYSDATE,'DD/MM/RRRR'), 'd7','d7',2);
INSERT INTO Persona (Nombre, Apellido1, Fecha_alta, Usuario, Contrasenna, Id_perfil) VALUES ('Dueño8','Apellido',TO_DATE(SYSDATE,'DD/MM/RRRR'), 'd8','d8',2);

--Insert de equipos
INSERT INTO Equipo (Nombre,FECHA_CREACION,COMENTARIO,Lugar,Id_persona) VALUES ('Equipo1',TO_DATE(SYSDATE,'DD/MM/RRRR'),'Las rosas son rosas','Vitoria',3);
INSERT INTO Equipo (Nombre,FECHA_CREACION,COMENTARIO,Lugar,Id_persona) VALUES ('Equipo2',TO_DATE(SYSDATE,'DD/MM/RRRR'),'Las rosas son muy azules','Bilbao',4);
INSERT INTO Equipo (Nombre,FECHA_CREACION,COMENTARIO,Lugar,Id_persona) VALUES ('Equipo3',TO_DATE(SYSDATE,'DD/MM/RRRR'),'Las rosas son muy azules','Jerez',5);
INSERT INTO Equipo (Nombre,FECHA_CREACION,COMENTARIO,Lugar,Id_persona) VALUES ('Equipo4',TO_DATE(SYSDATE,'DD/MM/RRRR'),'Las rosas son muy azules','Madrid',6);
INSERT INTO Equipo (Nombre,FECHA_CREACION,COMENTARIO,Lugar,Id_persona) VALUES ('Equipo5',TO_DATE(SYSDATE,'DD/MM/RRRR'),'Las rosas son muy azules','Tenerife',7);
INSERT INTO Equipo (Nombre,FECHA_CREACION,COMENTARIO,Lugar,Id_persona) VALUES ('Equipo6',TO_DATE(SYSDATE,'DD/MM/RRRR'),'Las rosas son muy azules','Sitio1',8);
INSERT INTO Equipo (Nombre,FECHA_CREACION,COMENTARIO,Lugar,Id_persona) VALUES ('Equipo7',TO_DATE(SYSDATE,'DD/MM/RRRR'),'Las rosas son muy azules','Sitio2',9);
INSERT INTO Equipo (Nombre,FECHA_CREACION,COMENTARIO,Lugar,Id_persona) VALUES ('Equipo8',TO_DATE(SYSDATE,'DD/MM/RRRR'),'Las rosas son muy azules','Donosti',10);


--Insert de Jugadores
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario,ID_EQUIPO) VALUES ('72848256A','Mikel','Ferreiro','Guridi','Joylife',30000,TO_DATE(SYSDATE,'DD/MM/RRRR'),'Las rosas son rosas',1);
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario) VALUES ('62348256A','Yaiza','Dasfo','Guridi','Jaiz',30000,TO_DATE(SYSDATE,'DD/MM/RRRR'),'Las rosas son rojas');
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario) VALUES ('56878256A','Jonxu','Asd','Guridi','gold',30000,TO_DATE(SYSDATE,'DD/MM/RRRR'),'Las rosas son amarillas');
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario) VALUES ('42898256A','Imanol','Fgh','Guridi','ima',30000,TO_DATE(SYSDATE,'DD/MM/RRRR'),'Las rosas son azules');
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario,ID_EQUIPO) VALUES ('35842556A','Mikel2','Ferreiro2','Guridi2','Joylife2',30000,TO_DATE(SYSDATE,'DD/MM/RRRR'),'Las rosas son rosas2',2);
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario,ID_EQUIPO) VALUES ('25842553A','Mikel3','Ferreiro3','Guridi3','Joylife3',30000,TO_DATE(SYSDATE,'DD/MM/RRRR'),'Las rosas son rosas3',2);
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario) VALUES ('62348256A','Yaiza','Dasfo','Guridi','jaaaaaz',10000,TO_DATE(SYSDATE,'DD/MM/RRRR'),'Las rosas son rojas');
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario) VALUES ('56878256A','Jon','Asd','Guridi','luffie',10000,TO_DATE(SYSDATE,'DD/MM/RRRR'),'Las rosas son amarillas');
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario) VALUES ('42898256A','Imanol','Fgh','Guridi','asd',30000,TO_DATE(SYSDATE,'DD/MM/RRRR'),'Las rosas son azules');

--Insert de Jornadas
INSERT INTO Jornada VALUES (1,TO_DATE(SYSDATE,'DD/MM/RRRR'),TO_DATE('26/12/2018','DD/MM/RRRR'));
INSERT INTO Jornada  VALUES (2,TO_DATE(SYSDATE,'DD/MM/RRRR'),TO_DATE('28/12/2018','DD/MM/RRRR'));

--Insert de Partidos
INSERT INTO Partido VALUES (1,TO_TIMESTAMP(SYSDATE,'DD/MM/RRRR HH24:MI:SS.FF'),1);
INSERT INTO Partido VALUES (2,TO_TIMESTAMP(SYSDATE,'DD/MM/RRRR HH24:MI:SS.FF'),1);
INSERT INTO Partido VALUES (3,TO_TIMESTAMP(SYSDATE,'DD/MM/RRRR HH24:MI:SS.FF'),1);
INSERT INTO Partido VALUES (4,TO_TIMESTAMP(SYSDATE,'DD/MM/RRRR HH24:MI:SS.FF'),1);
INSERT INTO Partido VALUES (5,TO_TIMESTAMP(SYSDATE,'DD/MM/RRRR HH24:MI:SS.FF'),2);
INSERT INTO Partido VALUES (6,TO_TIMESTAMP(SYSDATE,'DD/MM/RRRR HH24:MI:SS.FF'),2);
INSERT INTO Partido VALUES (7,TO_TIMESTAMP(SYSDATE,'DD/MM/RRRR HH24:MI:SS.FF'),2);
INSERT INTO Partido VALUES (8,TO_TIMESTAMP(SYSDATE,'DD/MM/RRRR HH24:MI:SS.FF'),2);

--Insert de Marcadores
INSERT INTO MARCADOR VALUES (DEFAULT,10,0,1,1);
INSERT INTO MARCADOR VALUES (DEFAULT,30,1,1,2);
INSERT INTO MARCADOR VALUES (DEFAULT,22,0,2,3);
INSERT INTO MARCADOR VALUES (DEFAULT,15,1,2,4);
INSERT INTO MARCADOR VALUES (DEFAULT,20,0,3,5);
INSERT INTO MARCADOR VALUES (DEFAULT,40,1,3,6);
INSERT INTO MARCADOR VALUES (DEFAULT,14,0,4,7);
INSERT INTO MARCADOR VALUES (DEFAULT,12,1,4,8);
INSERT INTO MARCADOR VALUES (DEFAULT,10,0,5,8);
INSERT INTO MARCADOR VALUES (DEFAULT,30,1,5,7);
INSERT INTO MARCADOR VALUES (DEFAULT,22,0,6,6);
INSERT INTO MARCADOR VALUES (DEFAULT,15,1,6,5);
INSERT INTO MARCADOR VALUES (DEFAULT,20,0,7,4);
INSERT INTO MARCADOR VALUES (DEFAULT,40,1,7,3);
INSERT INTO MARCADOR VALUES (DEFAULT,14,0,8,2);
INSERT INTO MARCADOR VALUES (DEFAULT,12,1,8,1);

