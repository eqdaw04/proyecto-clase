SET SERVEROUTPUT ON

--Privilegios???
--GRANT EXECUTE ON Pkg_resultados to public;

DROP PACKAGE Pkg_resultados;
CREATE OR REPLACE PACKAGE Pkg_resultados IS
      TYPE TCURSOR IS REF CURSOR;
      PROCEDURE Resul (C_partjor OUT TCURSOR);
END Pkg_resultados;
/
CREATE OR REPLACE PACKAGE BODY Pkg_resultados IS
  PROCEDURE Resul (C_partjor OUT TCURSOR) AS
  BEGIN
  OPEN C_partjor for
      SELECT P.Id_jornada, P.Id_partido,M.Id_equipo,M.Puntuacion
      FROM Partido P, MARCADOR M
      WHERE P.Id_partido = M.Id_partido
      ORDER BY P.Id_jornada, P.Id_partido,M.Id_equipo;
  END;
END Pkg_resultados;
/
--Procedimiento anónimo de llamada
DECLARE
      V_Cur  Pkg_resultados.TCURSOR;
      V_Id_jornada Partido.Id_jornada%TYPE;
      V_Id_partido Partido.Id_partido%TYPE;
      V_Id_equipo Marcador.Id_equipo%TYPE;
      V_Puntuacion Marcador.Puntuacion%TYPE;
BEGIN
    Pkg_resultados.Resul(V_Cur);
    LOOP
        FETCH V_Cur INTO V_Id_jornada,V_Id_partido,V_Id_equipo,V_Puntuacion;
        EXIT WHEN V_CUR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(V_Id_jornada || ' ' || V_Id_partido || ' ' || V_Id_equipo || ' ' || V_Puntuacion);
    END LOOP;
END;





----PRUEBAS
drop procedure resul;
CREATE OR REPLACE PROCEDURE resul AS
  CURSOR C_partjor  IS
    SELECT P.Id_jornada, P.Id_partido,M.Id_equipo,M.Puntuacion FROM Partido P, MARCADOR M
    WHERE P.Id_partido = M.ID_PARTIDO
    ORDER BY P.Id_jornada, P.Id_partido,M.Id_equipo;
   V_c_partjor C_partjor%ROWTYPE;
  BEGIN
  OPEN C_partjor;  
    LOOP
      FETCH C_partjor INTO V_c_partjor;
      EXIT WHEN C_partjor%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE(V_c_partjor.Id_jornada||' '|| V_c_partjor.Id_partido||' '|| V_c_partjor.Id_equipo||' '|| V_c_partjor.Puntuacion);
    END LOOP;
    CLOSE C_partjor;
END;

EXECUTE RESUL;
SELECT P.Id_jornada, P.Id_partido,M.Id_equipo,M.Puntuacion 
      FROM Partido P, MARCADOR M
    WHERE P.Id_partido = M.Id_partido
    ORDER BY P.Id_jornada, P.Id_partido,M.Id_equipo;