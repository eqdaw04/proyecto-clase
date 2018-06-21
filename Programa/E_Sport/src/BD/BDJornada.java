/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Controladora.Main;
import Excepciones.Excepcion;
import UML.Equipo;
import UML.Jornada;
import UML.Partido;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
/**
 * Clase en la que controlaremos e introduciremos datos de la jornada actual a la base de datos.
 * Fecha de creación de la clase: 24/04/2018
 * @author eqdaw04
 */
public class BDJornada {
    
    // insertar la jornada
    public Jornada insertarJornada(int nJornada, Calendar fecha, BDConexion con) throws Exception{
        // instanciar objetoo en null
        Jornada j = null;        
        // preparar sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("INSERT INTO jornada VALUES(?, TO_DATE(?,'DD/MM/RRRR'), null)");
        // cargar datos al ?
        sentencia.setInt(1, nJornada);
        sentencia.setDate(2, convertirFechaASql(fecha.getTime()));
        // ejecutar la sentencia y comprobar si se ha insertado
        if(sentencia.executeUpdate()==1){
            // instanciar objeto jornada
            j = new Jornada();
            // cargar los datos al objeto
            j.setIdJornada(nJornada);
            j.setFechaInicio(fecha.getTime());
        }
        // cerrar la sentencia
        sentencia.close();
        // devolver el objeto
        return j;
    }
    
    /**
     * Metodo para convertir la fecha.
     * @param fecha Java util date
     * @return devuelve la fecha en el tipo de dato date
     * @throws Exception salta excepcion
     */
    
    private Date convertirFechaASql(java.util.Date fecha) throws Exception{
        // formatear la fecha con el formato establecido
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String ff = f.format(fecha);
        // parsearlo a formato fecha
        java.util.Date parsed = f.parse(ff);
        Date fSQL = new Date(parsed.getTime());
        return fSQL;
    }
    
    /**
     * Metodo para modificar la jornada
     * @param jornada Jornada
     * @param con BDConexion
     * @throws Exception salta excepcion
     */
    
    // modificar la jornada
    public void modificarJornada(Jornada jornada, BDConexion con) throws Exception{
        // preparar sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("UPDATE jornada SET fecha_fin = TO_DATE(?,'DD/MM/RRRR') WHERE id_jornada = ?");
        // cargar los datos al ?
        sentencia.setDate(1, convertirFechaASql(jornada.getFechaFinal()));
        sentencia.setInt(2, jornada.getIdJornada());
        // comprobar si se ha modificado el dato, en caso contrario, mostrar error
        if(sentencia.executeUpdate()!=1){
            throw new Excepcion(43);
        }
        sentencia.close();
    }
    
    /**
     * Metodo para consultar una lista de todas las jornadas 
     * @return devuelve la lista de jornadas
     * @throws Exception salta excepcion
     */
    
    
    // obtener las jornadas existentes
    public ArrayList <Jornada> consultarTodasLasJornadas() throws Exception{
        // instanciar una lista
        ArrayList <Jornada> lJornada = new ArrayList();
        // abrir la conexion
        BDConexion con = new BDConexion();
        // preparar la sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT id_jornada, fecha_inicio, fecha_fin FROM Jornada ORDER BY Id_jornada");
        // instanciar rs, ejecutar la sentencia y cargar los datos al rs
        ResultSet rs;
        rs = sentencia.executeQuery();
        // comprobar si existe datos en el rs
        while(rs.next()){
            // instanciar objeto jornada y cargar los datos del rs al objeto
            Jornada j = new Jornada();
            j.setIdJornada(rs.getInt("id_jornada"));
            j.setFechaInicio(rs.getDate("fecha_inicio"));
            j.setFechaFinal(rs.getDate("fecha_fin"));
            // añadir el objeto a la lista
            lJornada.add(j);
        }
        // cerrar lo abierto
        rs.close();
        sentencia.close();
        con.desconectar();
        // devolver lista
        return lJornada;
    }
    
    // obtener la primera jornada
    public Jornada consultarInicio() throws Exception{
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM jornada WHERE id_jornada = (SELECT MIN(id_jornada) FROM jornada)");
        ResultSet rs;
        Jornada j = null;
        rs = sentencia.executeQuery();
        if(rs.next()){
            j = new Jornada();
            j.setIdJornada(rs.getInt("id_jornada"));
            j.setFechaInicio(rs.getDate("fecha_inicio"));
            j.setFechaFinal(rs.getDate("fecha_fin"));
        }
        return j;
    }
    
    /**
     * Metodo para consultar una jornada por su número.
     * @param n int
     * @return devuelve un objeto jornada
     * @throws Exception salta excepcion
     */
    
    // extraer los datos de una jornada mediante el número de jornada
    public Jornada consultarJornadaPorNumeroDeJornada(int n) throws Exception{
        // abre la conexion
        BDConexion con = new BDConexion();
        // Crear objeto persona nulo
        Jornada j = null;
        // preparar la conexion y sentencia
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT id_jornada FROM jornada WHERE id_jornada = ?");
        // formatear fecha a fecha para sql como condicion
        sentencia.setInt(1, n);
        // crear objeto para el resultado de la consulta
        ResultSet rs;
        // cargar objeto sentencia al objeto rs
        rs = sentencia.executeQuery();
       // buscar si existe datos en la rs
        if(rs.next()){
            // crear la persona con base Persona y llenar los datos
            j = new Jornada();
            j.setIdJornada(rs.getInt("id_jornada"));
            j.setListaPartidos(Main.consultarPartidosPorJornada(j.getIdJornada()));
        }
        // cerrar conexiones y retornar objeto obtenido mediante consulta
        rs.close();
        sentencia.close();
        con.desconectar();
        return j;
        
    }
    
    
    // Borra la liga entera sin afectar las personas, jugadores ni equipoa
    public boolean borrarTodo() throws Exception{
        BDConexion con = new BDConexion();
            PreparedStatement sentencia;
            sentencia = con.getConnection().prepareStatement("DELETE FROM Marcador");
            sentencia.executeUpdate();
            sentencia = con.getConnection().prepareStatement("DELETE FROM Partido");
            sentencia.executeUpdate();
            sentencia = con.getConnection().prepareStatement("DELETE FROM Jornada");
            sentencia.executeUpdate();
            sentencia = con.getConnection().prepareStatement("ALTER TABLE Marcador MODIFY (Id_marcador NUMBER (3,0) GENERATED ALWAYS AS IDENTITY MINVALUE 0 Start with 0)");
            sentencia.executeUpdate();
            sentencia.close();
        con.desconectar();
        return true;
    }
    
    
    // transformar la fecha a un string
    private String convertirFecha(Date fecha){
        SimpleDateFormat ff = new SimpleDateFormat("dd-MM-yyyy");
        return ff.format(fecha);
    }
   
    
    // estrar los datos de la última jornada
    public Jornada consultaUltimaJornada(Date fecha) throws Exception{
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM jornada WHERE id_jornada = (SELECT max(id_jornada) FROM jornada)");
        sentencia.setString(1, convertirFecha(fecha));
        ResultSet rs;
        rs = sentencia.executeQuery();
        Jornada j = null;
        if(rs.next()){
            j = new Jornada();
            j.setIdJornada(rs.getInt("id_jornada"));
            j.setFechaInicio(rs.getDate("fecha_inicio"));
            j.setFechaFinal(rs.getDate("fecha_fin"));
        }
        return j;
    }
    
    
    // extrar la última jornada actual, viene siendo la jornada en curso
    public int consultaUltimaJornadaActual() throws Exception{
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT MAX(id_jornada) as id_jornada FROM jornada where TO_DATE(SYSDATE,'DD/MM/RRRR') >= fecha_inicio");
        ResultSet rs;
        rs = sentencia.executeQuery();
        int j = 0;
        if(rs.next()){
            j = rs.getInt("id_jornada");
        }
        return j;
    }
    
    
    public ArrayList<Jornada> BuscarJornadas() throws Exception{
        // abrir conexión
        BDConexion con = new BDConexion();
        // instanciar un array de tipo objeto Partido
        ArrayList<Jornada> jornadas = new ArrayList();
        CallableStatement sentencia;
        // preparar sentencia
        sentencia = con.getConnection().prepareCall("{call Pkg_Jornada.Jornadas(?)}");  
        sentencia.registerOutParameter(1, OracleTypes.CURSOR);
        sentencia.execute();
        // instanciar rs, ejecutar sentencia y cargar los datos al rs
        ResultSet rs = ((OracleCallableStatement)sentencia).getCursor(1);
        
        while(rs.next()){
            //Se instancia un objeto de tipo Equipo
            Equipo e=new Equipo();
                        e.setIdEquipo(rs.getInt("Id_equipo"));
                        e.setNombre(rs.getString("Nombre"));
                        e.setLugar(rs.getString("Lugar"));
                        e.setComentario(rs.getString("comentario"));
            if (jornadas.isEmpty()){
                Jornada j= new Jornada();
                j.setIdJornada(rs.getInt("Id_jornada"));
                j.setFechaInicio(rs.getDate("Fecha_inicio"));
                j.setFechaFinal(rs.getDate("Fecha_fin"));
                ArrayList<Partido> partidos= new ArrayList();
                    Partido p=new Partido();
                    p.setIdPartido(rs.getInt("Id_partido"));
                    p.setFecha(DateACalendar(rs.getDate("Fecha")));
                        
                        if(rs.getInt("visitante")==1){
                            p.seteLocal(e);
                            p.setmLocal(rs.getInt("Puntuacion"));
                        }
                         else{
                            p.seteVisitante(e);
                            p.setmVisitante(rs.getInt("Puntuacion"));
                        }
                partidos.add(p);
                j.setListaPartidos(partidos);
                jornadas.add(j);
            }else{
                if(rs.getInt("Id_jornada")==jornadas.get(jornadas.size()-1).getIdJornada()){
                    //Este if, es para conseguir que un mismo partido tenga dos equipos como parametros, y no se añada un objeto partido por cada equipo
                    if(rs.getInt("Id_partido")==jornadas.get(jornadas.size()-1).getListaPartidos().get(jornadas.get(jornadas.size()-1).getListaPartidos().size()-1).getIdPartido()){
                        if(rs.getInt("visitante")==1){
                            jornadas.get(jornadas.size()-1).getListaPartidos().get(jornadas.get(jornadas.size()-1).getListaPartidos().size()-1).seteLocal(e);
                            jornadas.get(jornadas.size()-1).getListaPartidos().get(jornadas.get(jornadas.size()-1).getListaPartidos().size()-1).setmLocal(rs.getInt("Puntuacion"));
                        }
                        else{
                            jornadas.get(jornadas.size()-1).getListaPartidos().get(jornadas.get(jornadas.size()-1).getListaPartidos().size()-1).seteVisitante(e);
                            jornadas.get(jornadas.size()-1).getListaPartidos().get(jornadas.get(jornadas.size()-1).getListaPartidos().size()-1).setmVisitante(rs.getInt("Puntuacion"));
                        }
                    }else{
                        Partido p=new Partido();
                        p.setIdPartido(rs.getInt("Id_partido"));
                        p.setFecha(DateACalendar(rs.getDate("Fecha")));
                        if(rs.getInt("visitante")==1){
                            p.seteLocal(e);
                            p.setmLocal(rs.getInt("Puntuacion"));
                        }
                        else{
                            p.seteVisitante(e);
                            p.setmVisitante(rs.getInt("Puntuacion"));
                        }
                    jornadas.get(jornadas.size()-1).getListaPartidos().add(p);
                    }
                }else{
                    Jornada j= new Jornada();
                        j.setIdJornada(rs.getInt("Id_jornada"));
                        j.setFechaInicio(rs.getDate("Fecha_inicio"));
                        j.setFechaFinal(rs.getDate("Fecha_fin"));
                    ArrayList<Partido> partidos= new ArrayList();
                        Partido p=new Partido();
                            p.setIdPartido(rs.getInt("Id_partido"));
                            p.setFecha(DateACalendar(rs.getDate("Fecha")));
                        if(rs.getInt("visitante")==1){
                            p.seteLocal(e);
                            p.setmLocal(rs.getInt("Puntuacion"));
                        }
                         else{
                            p.seteVisitante(e);
                            p.setmVisitante(rs.getInt("Puntuacion"));
                        }
                partidos.add(p);
                j.setListaPartidos(partidos);
                jornadas.add(j);
                }
            }                                  
        }
        rs.close();
        sentencia.close();
        con.desconectar();
        return jornadas;
    }
    public Calendar DateACalendar(java.util.Date fecha){
        long as = fecha.getTime();
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(as);
        return c;
    }
}
