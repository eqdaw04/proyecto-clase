SET SERVEROUTPUT ON

--Creamos el paquete Pkg_Resultados, que contiene el procedimiento Resul, el cual devuelve los resultados de la liga
CREATE OR REPLACE PACKAGE Pkg_Resultados IS
--Declaramos Tcursor de tipo ref cursor
      TYPE TCURSOR IS REF CURSOR;
-- Declaramos el procedimiento Resul con el parametro de salida C_partjor de tipo TCURSOR
      PROCEDURE Resul (C_partjor OUT TCURSOR);
END Pkg_resultados;
/
--Declaramos el cuerpo del paquete
CREATE OR REPLACE PACKAGE BODY Pkg_Resultados IS
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
END Pkg_Resultados;
/
--Procedimiento anónimo de llamada
DECLARE
      V_Cur  Pkg_Resultados.TCURSOR;
      V_Id_jornada Partido.Id_jornada%TYPE;
      V_Id_partido Partido.Id_partido%TYPE;
      V_Id_equipo Marcador.Id_equipo%TYPE;
      V_Puntuacion Marcador.Puntuacion%TYPE;
BEGIN
    Pkg_Resultados.Resul(V_Cur);
    LOOP
        FETCH V_Cur INTO V_Id_jornada,V_Id_partido,V_Id_equipo,V_Puntuacion;
        EXIT WHEN V_CUR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(V_Id_jornada || ' ' || V_Id_partido || ' ' || V_Id_equipo || ' ' || V_Puntuacion);
    END LOOP;
END;
