SET SERVEROUTPUT ON

--Creamos el paquete para almacenar una variable con los datos de una fila de Jugador
CREATE OR REPLACE PACKAGE Pkg_triggers AS
New_jug Jugador%rowtype:=NULL;
END;
/

--Este trigger se ejecuta después de que se realize un insert o update en la tabla jugador.
CREATE OR REPLACE TRIGGER T_cambio AFTER
INSERT OR UPDATE OF Id_equipo, Sueldo ON JUGADOR FOR EACH ROW
 BEGIN
--Almacenamos los datos que nos interesan de la variable en la sentencia
 Pkg_triggers.New_jug.Id_equipo := :new.Id_equipo;
 Pkg_triggers.New_jug.Sueldo := :new.Id_equipo; 
 END;

------------TRIGGER 1
--Declaramos el trigger para que se ejecute depués de una sentencia insert o update que afecte a la columna Id_equipo en la tabla Jugador
CREATE OR REPLACE TRIGGER Ins_jug AFTER
      INSERT OR UPDATE OF Id_equipo ON Jugador 
DECLARE
      V_cant_jug number(1);
BEGIN
--Insertamos en la variable V_cant_jug la cantidad de jugadores que hay en el equipo en el que se trata de hacer la operación
      SELECT COUNT(*) into V_cant_jug from Jugador
            WHERE Id_equipo = Pkg_triggers.New_jug.Id_equipo;
--Si el valor de la variable (que contiene la cantidad de jugadores del equipo) es mayor a 5 se lanza una excepcion
      IF V_cant_jug >6 THEN
          RAISE_APPLICATION_ERROR(-20001,'Límite de jugadores alcanzado');
      END IF;

END;

------------TRIGGER 2
--Declaramos el trigger para que se ejecute depués de una sentencia insert o update que afecte a las columnas Id_equipo o Sueldo en la tabla Jugador
CREATE OR REPLACE TRIGGER Salario_max AFTER
      INSERT OR UPDATE of Id_equipo, Sueldo
      ON Jugador
DECLARE
      V_sueldo_jug NUMBER (8);
 -- E_sueldo_superado EXCEPTION;
BEGIN
--Insertamos en la variable V_sueldo_jug el sueldo total de todos los jugadores que hay en el equipo en el que se trata de hacer el insert
      SELECT SUM (Sueldo) INTO V_sueldo_jug FROM Jugador 
            WHERE Id_equipo = Pkg_triggers.New_jug.Id_equipo;
-- le sumamos a la variable el sueldo del nuevo jugador que se trata de insertar            
      V_sueldo_jug := V_sueldo_jug + Pkg_triggers.New_jug.sueldo;
--Si el valor de la variable (que contiene el sueldo total que tendra el equipo) es mayor a 200000 se lanza una excepcion
      IF V_sueldo_jug >200000 THEN
            RAISE_APPLICATION_ERROR(-20001,'EL SALARIO DEL
            EQUIPO ES SUPERIOR A 200.000 €');
      END IF;    
END;    

--Comprobaciones
select * from Jugador;
INSERT INTO Jugador (Dni,Nombre,Apellido1,Apellido2,Nickname,Sueldo,Fecha_alta,Comentario,ID_EQUIPO) VALUES ('12348256A','dsfkel','sdfro','Gusdfdi','Joylife',60000,TO_DATE(SYSDATE,'DD/MM/YYYY'),'AAAAAaaaaaaaa',2);
update Jugador set Id_equipo = 1 where ID_JUGADOR =10;
update Jugador set Id_equipo = 2 where ID_JUGADOR =3;