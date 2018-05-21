SET SERVEROUTPUT ON

--Creamos el paquete Pkg_Resultados, que contiene el procedimiento Resul, el cual devuelve los resultados de la liga
CREATE OR REPLACE PACKAGE Pkg_Resultados IS
--Declaramos Tcursor de tipo ref cursor
      TYPE TCURSOR IS REF CURSOR;
-- Declaramos el procedimiento Resul con el parametro de salida C_partjor de tipo TCURSOR
      PROCEDURE Resul (C_partjor OUT TCURSOR);
-- Declaramos el procedimiento Resul con el parametro con el parametro de entrada P_id_jor de tipo Integer  y el de salida C_resultados de tipo TCURSOR
      PROCEDURE ResultadosPorJornada (P_id_jor integer,C_resultados OUT TCURSOR);
END Pkg_resultados;
/
--Declaramos el cuerpo del paquete
CREATE OR REPLACE PACKAGE BODY Pkg_Resultados IS
--Creamos el procedimiento Resul  
  PROCEDURE Resul (C_partjor OUT TCURSOR) AS
  BEGIN
-- Abrimos el cursor 
  OPEN C_partjor for
--Llenamos el cursor con el Id de Jornada, partido, equipo y la puntuación
      SELECT P.Id_jornada, P.Id_partido,M.Id_equipo,M.Puntuacion
      FROM Partido P, MARCADOR M
      WHERE P.Id_partido = M.Id_partido
      ORDER BY P.Id_jornada, P.Id_partido,M.Id_equipo;
  END;  
--Creamos el procedimiento ResultadosPorJornada
  PROCEDURE ResultadosPorJornada (P_id_jor integer,C_resultados OUT TCURSOR) AS
  BEGIN
-- Abrimos el cursor
  OPEN C_resultados for
--Llenamos el cursor con el Id de partido y equipo, su nombre su "lugar" y si es visitante o no
      SELECT  P.Id_partido,P.Fecha,E.Lugar,E.Id_equipo,E.Nombre,E.Comentario,M.Puntuacion,M.Visitante
      FROM Equipo E, MARCADOR M, Partido P
      WHERE E.Id_equipo = M.Id_equipo
      AND P.Id_partido = M.Id_partido
      AND M.Id_partido in (SELECT Id_partido FROM Partido WHERE Id_jornada = P_id_jor)
      ORDER BY M.Id_partido,M.Visitante;
  END;
END Pkg_Resultados;
/
