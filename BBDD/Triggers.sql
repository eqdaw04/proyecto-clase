SET SERVEROUTPUT ON

------------TRIGGER 1
--Las partes del codigo comentadas es como se comportaría el trigger en la bbdd, y esta comentado para tratar de que el error llegue a java.
--por si se quiere borrar el trigger
DROP TRIGGER Ins_jug;
--Declaramos el trigger para que se ejecute antes de una sentencia insert en la tabla Jugador
CREATE OR REPLACE TRIGGER Ins_jug BEFORE
-- FALTA HACER ON UPDATE!!!
      INSERT ON Jugador FOR EACH ROW
DECLARE
      V_cant_jug number(1);
--    E_Jug_max EXCEPTION;
BEGIN
--Insertamos en la variable V_cant_jug la cantidad de jugadores que hay en el equipo en el que se trata de hacer el insert
      SELECT COUNT(Id_jugador) into V_cant_jug from Jugador
            WHERE Id_equipo = :new.Id_equipo;
--Si el valor de la variable (que contiene la cantidad de jugadores del equipo) es mayor a 5 se lanza una excepcion
      IF V_cant_jug >5 THEN
--    RAISE E_jug_max;
            RAISE_APPLICATION_ERROR(-20001,'Límite de jugadores alcanzado');
      END IF;
--EXCEPTION 
--  WHEN E_jug_max THEN
--    DBMS_OUTPUT.PUT_LINE('LIMITE DE JUGADORES SUPERADO. NO PUEDE INSERTAR MÁS JUGADORES');
END;

------------TRIGGER 2
--Declaramos el trigger para que se ejecute antes de una sentencia insert en la tabla Jugador
CREATE OR REPLACE TRIGGER Salario_max BEFORE 
      INSERT ON Jugador FOR EACH ROW
DECLARE
      V_sueldo_jug NUMBER (8);
 -- E_sueldo_superado EXCEPTION;
BEGIN
--Insertamos en la variable V_sueldo_jug el sueldo total de todos los jugadores que hay en el equipo en el que se trata de hacer el insert
      SELECT SUM (Sueldo) INTO V_sueldo_jug FROM Jugador 
            WHERE Id_equipo = :new.Id_equipo;
-- le sumamos a la variable el sueldo del nuevo jugador que se trata de insertar            
      V_sueldo_jug := V_sueldo_jug + :new.sueldo;
--Si el valor de la variable (que contiene el sueldo total que tendra el equipo) es mayor a 200000 se lanza una excepcion
      IF V_sueldo_jug >200000 THEN
--          RAISE E_sueldo_superado;
            RAISE_APPLICATION_ERROR(-20001,'EL SALARIO DEL EQUIPO ES SUPERIOR A 200.000 €');
      END IF;    
--EXCEPTION
--    WHEN E_sueldo_superado THEN
--            DBMS_OUTPUT.PUT_LINE ('EL SALARIO DEL EQUIPO ES SUPERIOR A 200.000 €'); 
END;    