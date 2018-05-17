SET SERVEROUTPUT ON

--Creamos el paquete Pkg_clasificación, que contiene el procedimiento clasif, el cual devuelve la puntuación total por equipo
CREATE OR REPLACE PACKAGE Pkg_Clasificacion IS
--Declaramos Tcursor de tipo ref cursor
      TYPE TCURSOR IS REF CURSOR;
-- Declaramos el procedimiento Clasif con el parametro de salida C_partidos de tipo TCURSOR
      PROCEDURE Clasif (C_partidos OUT TCURSOR);
END Pkg_Clasificacion;
/
--Declaramos el cuerpo del paquete
CREATE OR REPLACE PACKAGE BODY Pkg_Clasificacion IS
  PROCEDURE Clasif (C_partidos OUT TCURSOR) AS
  BEGIN
-- Abrimos el cursor 
  OPEN C_partidos for
--Llenamos el cursor con el nombre del equipo y el sumatorio de sus puntuaciones, y se ordena por la puntuación de forma descendente
      SELECT E.Nombre AS Equipo, SUM(M.Puntuacion) AS punto FROM EQUIPO E,MARCADOR M 
            WHERE E.ID_EQUIPO = M.ID_EQUIPO
            GROUP BY  E.Nombre
            ORDER BY punto DESC;
  END;
END Pkg_Clasificacion;
/
--Procedimiento anónimo de llamada
DECLARE
      V_Cur  Pkg_Clasificacion.TCURSOR;
      V_nombre Equipo.Nombre%TYPE;
      V_Puntuacion Marcador.Puntuacion%TYPE;
BEGIN
    Pkg_Clasificacion.Clasif(V_Cur);
    LOOP
        FETCH V_Cur INTO V_nombre,V_Puntuacion;
        EXIT WHEN V_CUR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(V_nombre || ' ' ||  V_Puntuacion);
    END LOOP;
END;


