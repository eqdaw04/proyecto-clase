SET SERVEROUTPUT ON

CREATE OR REPLACE TRIGGER Salario_max
  BEFORE INSERT ON Jugador
    FOR EACH ROW
DECLARE
  V_sueldo_jug NUMBER (8);
  E_sueldo_superado EXCEPTION;
  
BEGIN
  SELECT SUM (Sueldo) INTO V_sueldo_jug
    FROM Jugador 
      WHERE Id_equipo = :new.Id_equipo;
    V_sueldo_jug := V_sueldo_jug + :new.sueldo;
IF V_sueldo_jug >200000 THEN
  RAISE E_sueldo_superado;
END IF;    
EXCEPTION
  WHEN E_sueldo_superado THEN
    DBMS_OUTPUT.PUT_LINE ('EL SALARIO DEL EQUIPO ES SUPERIOR A 200.000 €'); 
END;    