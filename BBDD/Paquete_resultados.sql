SET SERVEROUTPUT ON

CREATE OR REPLACE PACKAGE Pkg_resultados IS
  PROCEDURE Resul (C_partjor OUT CURSOR);
END Pkg_resultados;

CREATE OR REPLACE PACKAGE BODY Pkg_Clasificacion IS
  PROCEDURE resul AS
    CURSOR C_partjor  IS
      SELECT P.Id_jornada, P.Id_partido,M.Id_equipo,M.Puntuacion FROM Partido P, MARCADOR M
    WHERE P.Id_partido = M.ID_PARTIDO;
    V_c_partjor C_partjor%ROWTYPE;
  BEGIN
  OPEN C_partjor;  
    LOOP
      FETCH C_partjor INTO V_c_partjor;
      EXIT WHEN C_partjor%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE(V_c_partjor.Id_jornada, V_c_partjor.Id_partido, V_c_partjor.Id_equipo, V_c_partjor.Puntuacion);
    END LOOP;
    CLOSE C_partjor;
  END;
END Pkg_resultados;

----PRUEBAS

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
