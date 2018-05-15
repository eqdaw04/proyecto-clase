SET SERVEROUTPUT ON

DROP PACKAGE Pkg_Jornada;
CREATE OR REPLACE PACKAGE Pkg_Jornada IS
      TYPE TCURSOR IS REF CURSOR;
      PROCEDURE PartidosPorJornada (P_id_jor Partido.Id_jornada%TYPE,C_partidos OUT TCURSOR);
END Pkg_Jornada;
/
CREATE OR REPLACE PACKAGE BODY Pkg_Jornada IS
  PROCEDURE PartidosPorJornada (P_id_jor Partido.Id_jornada%TYPE,C_partidos OUT TCURSOR) AS
  BEGIN
  OPEN C_partidos for
      SELECT  M.Id_partido,E.Id_equipo,E.Nombre,M.Visitante,E.Lugar 
      FROM Equipo E, MARCADOR M
      WHERE E.Id_equipo = M.Id_equipo
      AND M.Id_partido in (SELECT Id_partido FROM Partido WHERE Id_jornada = P_id_jor)
      ORDER BY M.Id_partido,M.Visitante;
  END;
END Pkg_Jornada;
/
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