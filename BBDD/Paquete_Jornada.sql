SET SERVEROUTPUT ON

--Creamos el paquete Pkg_Resultados, que contiene el procedimiento Resul, el cual devuelve los partidos y equipos que intervienen para la jornada indicada
CREATE OR REPLACE PACKAGE Pkg_Jornada IS
--Declaramos Tcursor de tipo ref cursor
      TYPE TCURSOR IS REF CURSOR;
-- Declaramos el procedimiento PartidosPorJornada con el parametro de entrada P_id_jor de tipo Integer y de salida C_partidos de tipo TCURSOR
      PROCEDURE PartidosPorJornada (P_id_jor integer,C_partidos OUT TCURSOR);
      PROCEDURE Jornadas (C_jornadas OUT TCURSOR);
END Pkg_Jornada;
/
--Declaramos el cuerpo del paquete
CREATE OR REPLACE PACKAGE BODY Pkg_Jornada IS
  PROCEDURE PartidosPorJornada (P_id_jor integer,C_partidos OUT TCURSOR) AS
  BEGIN
-- Abrimos el cursor
  OPEN C_partidos for
--Llenamos el cursor con el Id de partido y equipo, su nombre su "lugar" y si es visitante o no
      SELECT  M.Id_partido,E.Id_equipo,E.Nombre,M.Visitante,E.Lugar ,P.Fecha
      FROM Equipo E, MARCADOR M, Partido P
      WHERE E.Id_equipo = M.Id_equipo
      AND P.Id_partido = M.Id_partido
      AND M.Id_partido in (SELECT Id_partido FROM Partido WHERE Id_jornada = P_id_jor)
      ORDER BY M.Id_partido,M.Visitante;
  END;
  PROCEDURE Jornadas (C_jornadas OUT TCURSOR) AS
  BEGIN
-- Abrimos el cursor
  OPEN C_jornadas for
--Llenamos el cursor con la id de jornada el Id de partido y equipo, su nombre su "lugar" y si es visitante o no
      SELECT J.Id_jornada, J.Fecha_inicio, J.Fecha_fin, P.Id_partido, P.Fecha, E.Lugar , E.Id_equipo, E.Nombre, E.Comentario, M.Puntuacion, M.Visitante
      FROM Equipo E, MARCADOR M, Partido P,Jornada J
      WHERE E.Id_equipo = M.Id_equipo
      AND P.Id_partido = M.Id_partido
      AND P.Id_jornada = J.Id_jornada
      ORDER BY J.Id_jornada,M.Id_partido,M.Visitante;
  END;
END Pkg_Jornada;
/
