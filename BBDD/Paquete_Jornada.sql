SET SERVEROUTPUT ON

--Creamos el paquete Pkg_Resultados, que contiene el procedimiento Resul, el cual devuelve los partidos y equipos que intervienen para la jornada indicada
CREATE OR REPLACE PACKAGE Pkg_Jornada IS
--Declaramos Tcursor de tipo ref cursor
      TYPE TCURSOR IS REF CURSOR;
-- Declaramos el procedimiento PartidosPorJornada con el parametro de entrada P_id_jor de tipo Integer y de salida C_partidos de tipo TCURSOR
      PROCEDURE PartidosPorJornada (P_id_jor integer,C_partidos OUT TCURSOR);
END Pkg_Jornada;
/
--Declaramos el cuerpo del paquete
CREATE OR REPLACE PACKAGE BODY Pkg_Jornada IS
  PROCEDURE PartidosPorJornada (P_id_jor integer,C_partidos OUT TCURSOR) AS
  BEGIN
-- Abrimos el cursor
  OPEN C_partidos for
--Llenamos el cursor con el Id de partido y equipo, su nombre su "lugar" y si es visitante o no
      SELECT  M.Id_partido,E.Id_equipo,E.Nombre,M.Visitante,E.Lugar 
      FROM Equipo E, MARCADOR M
      WHERE E.Id_equipo = M.Id_equipo
      AND M.Id_partido in (SELECT Id_partido FROM Partido WHERE Id_jornada = P_id_jor)
      ORDER BY M.Id_partido,M.Visitante;
  END;
END Pkg_Jornada;
/
/*
--Procedimiento anónimo de llamada
DECLARE
      V_Cur  Pkg_Jornada.TCURSOR;
      V_Visitante Marcador.Visitante%TYPE;
      V_Id_partido Marcador.Id_partido%TYPE;
      V_Id_equipo Equipo.Id_equipo%TYPE;
      V_Nombre Equipo.Nombre%TYPE;     
      V_Lugar Equipo.Lugar%TYPE;
      V_Id_jornada Partido.Id_jornada%TYPE:=1;
BEGIN
    Pkg_Jornada.PartidosPorJornada( V_Id_jornada,V_Cur);
    LOOP
        FETCH V_Cur INTO V_Id_partido,V_Id_equipo,V_Nombre,V_Visitante, V_Lugar;
        EXIT WHEN V_CUR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(V_Id_partido|| ' ' || V_Id_equipo || ' ' || V_Nombre || ' ' || V_Visitante|| ' ' ||V_Lugar);
    END LOOP;
END;
*/