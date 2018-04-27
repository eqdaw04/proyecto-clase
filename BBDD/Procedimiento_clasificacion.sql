SET SERVEROUTPUT ON

CREATE OR REPLACE PACKAGE Pkg_Clasificacion IS
  TYPE Nes_punt IS TABLE OF INTEGER;
  FUNCTION Calcular_puntuacion(P_idequipo INTEGER)
    RETURN NUMBER;
  PROCEDURE Clasif (V_nes_punt OUT Nes_punt);
END Pkg_Clasificacion;
/

CREATE OR REPLACE PACKAGE BODY Pkg_Clasificacion IS
  FUNCTION Calcular_puntuacion (P_idequipo INTEGER)
  RETURN NUMBER
  AS
  CURSOR C_puntuacion IS
    SELECT NVL(Puntuacion,0) FROM Marcador 
    WHERE Id_equipo = P_idequipo;
  V_puntot Marcador.Puntuacion%TYPE:= 0;
  V_puntuacion Marcador.Puntuacion%TYPE;
  BEGIN
    OPEN C_puntuacion;  
    LOOP
      FETCH C_puntuacion INTO V_puntuacion;
      EXIT WHEN C_puntuacion%NOTFOUND;
      V_puntot := V_puntot+V_puntuacion;
    END LOOP;
    CLOSE C_puntuacion;
  RETURN V_puntot;
  END;
  ---
  PROCEDURE Clasif (V_nes_punt OUT Nes_punt)
  AS
    CURSOR C_idequipos IS
      SELECT DISTINCT Id_equipo FROM MARCADOR;
    V_idequipo MARCADOR.ID_EQUIPO%TYPE;
    V_x INTEGER:=1;
  BEGIN
    V_nes_punt := Nes_punt();
    OPEN C_idequipos;
    LOOP
      FETCH C_idequipos INTO V_idequipo;
      EXIT WHEN C_idequipos%NOTFOUND;
      V_nes_punt.EXTEND;
      SELECT Calcular_puntuacion(V_idequipo) INTO V_nes_punt(V_x) FROM DUAL;
      V_x := V_x + 1;
    END LOOP;
    IF V_nes_punt.COUNT > 0 THEN
      FOR i IN V_nes_punt.FIRST..V_nes_punt.LAST LOOP
      DBMS_OUTPUT.PUT_LINE(V_nes_punt(i));
      END LOOP;
    END IF;
  END;
END Pkg_Clasificacion;
  

execute Pkg_Clasificacion.Clasif();






