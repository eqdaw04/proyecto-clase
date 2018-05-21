--Todos los procedimientos anónimos de este fichero sirven para comprobar el correcto funcionamiento de los paquetes almacenados
--Procedimiento anónimo de llamada Pkg_Resultados.resul
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
/
--Procedimiento anónimo de llamada Pkg_Resultados.ResultadosPorJornada
DECLARE
      V_Cur  Pkg_Resultados.TCURSOR; 
      V_Id_partido Partido.Id_partido%TYPE;
      V_fecha Partido.Fecha%TYPE;
      V_Lugar Equipo.Lugar%TYPE;
      V_Id_equipo Equipo.Id_equipo%TYPE;
      V_Nombre Equipo.Nombre%TYPE;
      V_Comentario Equipo.Comentario%TYPE;
      V_Puntuacion Marcador.Puntuacion%TYPE;
      V_Visitante Marcador.Visitante%TYPE;
BEGIN
    Pkg_Resultados.ResultadosPorJornada(1,V_Cur);
    LOOP
        FETCH V_Cur INTO V_Id_partido,V_fecha,V_Lugar,V_Id_equipo,V_Nombre,V_Comentario,V_Puntuacion,V_Visitante;
        EXIT WHEN V_CUR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(V_Id_partido || ' ' || V_fecha || ' ' ||  V_Lugar || ' ' ||V_Id_equipo || ' ' ||V_Nombre || ' ' ||V_Comentario || ' ' ||V_Puntuacion || ' ' ||V_Visitante);
    END LOOP;
END;
/
--Procedimiento anónimo de llamada Pkg_Jornada.Jornadas
DECLARE
      V_Cur  Pkg_Jornada.TCURSOR;
      V_id_jornada Jornada.Id_jornada%TYPE;
      V_Fecha_inicio Jornada.Fecha_inicio%TYPE;
      V_Fecha_fin Jornada.Fecha_fin%TYPE;
      V_Id_partido partido.Id_partido%TYPE;
      V_Fecha Partido.Fecha%TYPE;
      V_Lugar Equipo.Lugar%TYPE;
      V_Id_equipo Equipo.Id_equipo%TYPE;
      V_Nombre Equipo.Nombre%TYPE;
      V_Comentario Equipo.Comentario%TYPE;
      V_Puntuacion Marcador.Puntuacion%TYPE;
      V_Visitante Marcador.Visitante%TYPE;     
BEGIN
    Pkg_Jornada.Jornadas(V_Cur);
    LOOP
        FETCH V_Cur INTO V_id_jornada,V_Fecha_inicio,V_Fecha_fin,V_Id_partido,V_Fecha,V_Lugar,V_Id_equipo,V_Nombre,V_Comentario,V_Puntuacion,V_Visitante ;
        EXIT WHEN V_CUR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(V_id_jornada|| ' ' ||V_Fecha_inicio|| ' ' ||V_Fecha_fin|| ' ' ||V_Id_partido|| ' ' ||V_Fecha|| ' ' ||V_Lugar|| ' ' ||V_Id_equipo|| ' ' ||V_Nombre|| ' ' ||V_Comentario|| ' ' ||V_Puntuacion|| ' ' ||V_Visitante);
    END LOOP;
END;
/

--Procedimiento anónimo de llamada Pkg_Clasificacion.Clasif
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
/