/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Controladora.Main;
import Excepciones.Excepcion;
import UML.Equipo;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *Clase en la que introduciremos y controlaremos los equipos a la base de datos.
 * Fecha de creación de la clase: 09/05/2018
 * @author eqdaw04
 */

public class BDEquipo {

    public BDEquipo() {
    }
    
    /**
     * Metodo para insertar un equipo.
     * @param e Equipo
     * @throws Exception 
     */
    
    public void insertarEquipo(Equipo e) throws Exception {
        // abrir conexión
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        // cargar la sentencia
        sentencia = con.getConnection().prepareStatement("INSERT INTO Equipo (NOMBRE, FECHA_CREACION, COMENTARIO, LUGAR, ID_PERSONA) VALUES (?, ?, ?, ?, ?)");
        // enviar los datos a los ? 
        sentencia.setString(1, e.getNombre());
        // formatear la fecha
        sentencia.setDate(2, formatearFecha(e.getFechaCreacion()));
        sentencia.setString(3, e.getComentario());
        sentencia.setString(4, e.getLugar());
        sentencia.setInt(5, e.getPersona().getIdPersona());
        // ejecutar la sentencia y comprobar si se ha insertado la fila, en caso contrario, mostrar error
        if(sentencia.executeUpdate()!=1)
        {
            // mostrar error
            throw new Excepcion(25);
        }
        // cerrar lo que se ha abierto
        sentencia.close();
        con.desconectar();
    }
    
    /**
     * Metodo para eliminar un equipo.
     * @param e Equipo
     * @throws Exception 
     */
    
    public void eliminarEquipo(Equipo e) throws Exception {
        // abrir conexión
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        // preparar la sentencia
        sentencia = con.getConnection().prepareStatement("DELETE FROM Equipo WHERE ID_EQUIPO = ?");
        // mandar el dato al ?
        sentencia.setInt(1, e.getIdEquipo());
        // ejecutar sentencia y comprobar si devuelve 1, en caso contrario, mostrar error
        if(sentencia.executeUpdate()!=1)
        {
            // mostrar error
            throw new Excepcion(25);
        }
        // cerrar lo que se ha abierto
        sentencia.close();
        con.desconectar();
    }
    
    /**
     * Metodo para modificar un equipo.
     * @param e Equipo
     * @throws Exception 
     */
    
    public void modificarEquipo(Equipo e) throws Exception {
        // abrir conexión
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        // preparar la sentencia
        // En las sentencias se usa RRRR en vez de YYYY por el efecto 2000, 
        sentencia = con.getConnection().prepareStatement("UPDATE Equipo SET NOMBRE=?, COMENTARIO=?, fecha_creacion = TO_DATE(?,'DD/MM/RRRR'), LUGAR=? WHERE ID_EQUIPO = ?");
        // cargar los datos al ?
        sentencia.setString(1, e.getNombre());
        sentencia.setString(2, e.getComentario());
        sentencia.setDate(3, formatearFecha(e.getFechaCreacion()));
        sentencia.setString(4, e.getLugar());
        sentencia.setInt(5, e.getIdEquipo());
        // ejecutar sentencia y comprobar si devuelve 1, en caso contrario, mostrar error
        if(sentencia.executeUpdate()!=1)
        {
            // mostrar error
            throw new Excepcion(25);
        }
        // cerrar lo que se ha abierto
        sentencia.close();
        con.desconectar();
    }
    
    /**
     * Metodo para buscar un equipo por nombre de un usuario integrante.
     * @param usu String
     * @return devuelve un objeto equipo
     * @throws Exception 
     */
    
    public Equipo BuscarEquipoPorUsuario(String usu) throws Exception  {
        // abrir conexión
        BDConexion con = new BDConexion();
        // instanciar objeto equipo en null
        Equipo e = null;
        PreparedStatement sentencia;
        // preparar sentencia
        sentencia = con.getConnection().prepareStatement("SELECT * FROM Equipo WHERE Id_persona = (SELECT Id_persona FROM Persona WHERE Usuario = ?)");
        // cargar los datos al ?
        sentencia.setString(1,usu);
        // ejecutar sentencia y cargar los datos al rs
        ResultSet rs;
        rs = sentencia.executeQuery();
        // comprobar si hay registro
        if (rs.next()){
            // llenar el objeto equipo con los datos existentes en el rs con una función
            e = recorrer(rs);
        }
        // cerrar lo que se ha abierto
        rs.close();
        sentencia.close();
        con.desconectar();
        return e;
    }
    
    /**
     * Método que recorre los datos
     * @param rs
     * @return
     * @throws Exception 
     */
    
    private Equipo recorrer(ResultSet rs) throws Exception{
        // instanciar el objeto equipo y llenarlo con los datos del rs
        Equipo e = new Equipo();
        e.setIdEquipo(rs.getInt("id_equipo"));
        e.setNombre(rs.getString("nombre"));        
        long as = rs.getTimestamp("fecha_creacion").getTime();
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(as);
        e.setFechaCreacion(c.getTime());            
        e.setComentario(rs.getString("comentario"));
        e.setLugar(rs.getString("lugar"));
        int x = rs.getInt("id_persona");
        e.setPersona(Main.obtenerPersona(x));
        // devolver el objeto cargado
        return e;
    }
    /**
     * Metodo para buscar una lista de equipos por nombre.
     * @param nombre String
     * @return devuelve el nombre del equipo encontrado
     * @throws Exception 
     */
    
    public Equipo BuscarEquipo(String nombre) throws Exception {
        // abrir conexion
        BDConexion con = new BDConexion();
        // instanciar objeto equipo en null
        Equipo e = null;
        PreparedStatement sentencia;
        // preparar  sentencia
        sentencia = con.getConnection().prepareStatement("SELECT * FROM Equipo WHERE Nombre = ?");
        // cargar datos al ?
        sentencia.setString(1, nombre);
        // instanciar rs, ejecutar sentencia y cargar los datos al rs
        ResultSet rs;
        rs = sentencia.executeQuery();
        // comprobar sie xiste datos en el rs
        if (rs.next()){
            // mandar a la función recorrer el rs y devolver el objeto cargado
            e = recorrer(rs);
        }
        // cerrar lo abierto
        rs.close();
        sentencia.close();
        con.desconectar();
        // devolver objeto cargado
        return e;
    }
    
    /**
     * Metodo para consultar un equipo por su número de id
     * @param n int
     * @return devuelve un objeto equipo
     * @throws Exception 
     */
    
    public Equipo consultarEquipoPorNumero(int n) throws Exception{
        // abrir conexión
        BDConexion con = new BDConexion();
        // instanciar objeto en null
        Equipo e = null;
        PreparedStatement sentencia;
        // preparar sentencia
        sentencia = con.getConnection().prepareStatement("SELECT id_equipo, nombre, comentario, lugar FROM equipo WHERE id_equipo = ?");
        // cargar datos al ?
        sentencia.setInt(1, n);
        // instanciar rs, ejecutar sentencia y cargarlo al rs
        ResultSet rs;
        rs = sentencia.executeQuery();
        // comprobar si existe datos en rs
        if(rs.next()){
            // instanciar el objeto y cargarlo con datos del rs
            e = new Equipo();
            e.setIdEquipo(n);
            e.setNombre(rs.getString("nombre"));
            e.setLugar(rs.getString("lugar"));    
            e.setComentario(rs.getString("comentario"));
        }
        // cerrar lo abierto
        rs.close();
        sentencia.close();
        con.desconectar();
        // devolver objeto
        return e;
    }
    /**
     * Metodo para buscar una lista de todos los equipos.
     * @return devuelve una lista de equipos
     * @throws Exception 
     */
    
    public ArrayList<Equipo> BuscarEquipo() throws Exception {
        // abrir conexión
        BDConexion con = new BDConexion();
        // instanciar un array de tipo objeto equipo
        ArrayList<Equipo> a = new ArrayList();
        PreparedStatement sentencia;
        // preparar sentencia
        sentencia = con.getConnection().prepareStatement("SELECT * FROM equipo ORDER BY id_equipo");
        // instanciar rs, ejecutar sentencia y cargar los datos al rs
        ResultSet rs;
        rs = sentencia.executeQuery();
        // comprobar si hay datos
        while (rs.next()){
            // mandar a una función el rs
            Equipo e = recorrer(rs);
            // añadir objeto a la lista
            a.add(e);
        }
        // cerrar lo abierto
        rs.close();
        sentencia.close();
        con.desconectar();
        // devolver lista
        return a;
    }
    
    public ArrayList<Equipo> BuscarEquipo6() throws Exception {
        // abrir conexión
        BDConexion con = new BDConexion();
        // instanciar un array de tipo objeto equipo
        ArrayList<Equipo> a = new ArrayList();
        ArrayList<Integer> cantidad = new ArrayList();
        PreparedStatement sentencia;
        // preparar sentencia
        sentencia = con.getConnection().prepareStatement("SELECT equipo.id_equipo AS equipo, COUNT(jugador.id_equipo) AS suma FROM equipo INNER JOIN jugador ON jugador.id_equipo = equipo.id_equipo GROUP BY jugador.id_equipo");
        // instanciar rs, ejecutar sentencia y cargar los datos al rs
        ResultSet rs;
        rs = sentencia.executeQuery();
        // comprobar si hay datos
        while (rs.next()){
            // mandar a una función el rs
            if(rs.getInt("suma")==6){
                cantidad.add(rs.getInt("equipo"));
            }
        }
        if(cantidad.size()>0){
            a = BuscarEquipoLosEquiposPorIDEquipo(con, sentencia, rs, cantidad);
        }
        
        // cerrar lo abierto
        rs.close();
        sentencia.close();
        con.desconectar();
        // devolver lista
        return a;
    }
    
    public ArrayList<Equipo> BuscarEquipoLosEquiposPorIDEquipo(BDConexion con, PreparedStatement sentencia, ResultSet rs, ArrayList <Integer> cantidad) throws Exception {
        ArrayList<Equipo> a = new ArrayList();
        for(int x = 0; x<cantidad.size(); x++){
            sentencia = con.connection.prepareStatement("SELECT * FROM equipo WHERE id_equipo = ?");
            sentencia.setInt(1, cantidad.get(x));
            rs = sentencia.executeQuery();
            if(rs.next()){
                Equipo e = recorrer(rs);
                // añadir objeto a la lista
                a.add(e);
            }
        }
        return a;
        
    } 
    
           /**
     * Metodo para formatear la fecha de alta.
     * @param fechaE Date
     * @return fecha
     */ 
    
    
    private Date formatearFecha(java.util.Date fechaE){
        // instanciar y formatear la fecha para ser reconocido con el formato establecido
        SimpleDateFormat formar = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formar.format(fechaE);
        // devolver fecha formateado
        return Date.valueOf(fecha);
    }
    
    // obtienes desde un paquete de la bbdd los resultados finales de los equipos ordenados por marcador
    public ArrayList<Object> resultadoFinal() throws Exception{
        BDConexion con = new BDConexion();
        CallableStatement sentencia;
        // preparar sentencia
        sentencia = con.getConnection().prepareCall("{call Pkg_Clasificacion.clasif(?)}");
        sentencia.registerOutParameter(1, OracleTypes.CURSOR);
        sentencia.execute();
        ResultSet rs;
        rs = ((OracleCallableStatement)sentencia).getCursor(1);
        ArrayList <Object> lista = new ArrayList();
        int x = 0;
        while(rs.next()){
            x++;
            Object[] fila = new Object[3];
            fila[0] = x;
            fila[1] = rs.getString("equipo");
            fila[2] = rs.getString("punto");
            lista.add(fila);
        }
        rs.close();
        sentencia.close();
        con.desconectar();
        return lista;
    }
 
    
    // obtiene los datos de la última jornada, es decir, la que está en curso no, el anterior
    public ArrayList<Object> resultadoUltimaJornada() throws Exception{
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement(
            "SELECT equipo.nombre AS equipo, marcador.puntuacion AS puntos, marcador.visitante AS visitante, partido.id_partido AS partido "
                    + "FROM marcador INNER JOIN partido ON partido.id_partido = marcador.id_partido "
                    + "INNER JOIN equipo ON equipo.id_equipo = marcador.id_equipo "
                    + "WHERE partido.id_jornada = "
                    + "(SELECT id_jornada-1 FROM jornada "
                    + "WHERE TO_DATE (SYSDATE, 'DD-MM-RRRR') BETWEEN fecha_inicio and fecha_fin)"
                    + "ORDER BY partido.id_partido");
        ResultSet rs;
        rs = sentencia.executeQuery();
        ArrayList <Object> lista = new ArrayList();
        while(rs.next()){
            String [] fila = new String[4];
            fila[0] = rs.getString("partido");
            fila[1] = rs.getString("equipo");
            fila[2] = rs.getString("puntos");
            fila[3] = rs.getString("visitante");
            lista.add(fila);   
        }
        rs.close();
        sentencia.close();
        con.desconectar();
        return lista;
    }
    
    // obtiene los datos de la última jornada, según fecha a dia de hoy
    public ArrayList<Object> resultadoUltimaJornadaDeLaLiga() throws Exception{
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement(
            "SELECT equipo.nombre AS equipo, marcador.puntuacion AS puntos, marcador.visitante AS visitante, partido.id_partido AS partido "
                    + "FROM marcador "
                    + "INNER JOIN partido ON partido.id_partido = marcador.id_partido "
                    + "INNER JOIN equipo ON equipo.id_equipo = marcador.id_equipo "
                    + "INNER JOIN jornada ON jornada.id_jornada = partido.id_jornada "
                    + "WHERE partido.id_jornada = "
                    + "(SELECT max(id_jornada) FROM jornada) AND TO_DATE(SYSDATE,'DD/MM/RRRR') >= jornada.fecha_inicio "
                    + "ORDER BY partido.id_partido");
        ResultSet rs;
        rs = sentencia.executeQuery();
        ArrayList <Object> lista = new ArrayList();
        while(rs.next()){
            String [] fila = new String[4];
            fila[0] = rs.getString("partido");
            fila[1] = rs.getString("equipo");
            fila[2] = rs.getString("puntos");
            fila[3] = rs.getString("visitante");
            lista.add(fila);   
        }
        rs.close();
        sentencia.close();
        con.desconectar();
        return lista;
    }
    
    // obtiene resultados para tabla y gráfico de la evolución del equipo
    public ArrayList<Object> resultadoTodasLasJornadas() throws Exception{
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement(
            "SELECT equipo.nombre AS equipos, marcador.puntuacion AS puntos, jornada.id_jornada AS jornada "
                    + "FROM marcador INNER JOIN partido ON partido.id_partido = marcador.id_partido "
                    + "INNER JOIN jornada ON jornada.ID_JORNADA = partido.id_jornada "
                    + "INNER JOIN equipo ON equipo.id_equipo = marcador.id_equipo "
                    + "WHERE TO_DATE(SYSDATE,'DD/MM/RRRR') >= jornada.fecha_inicio "
                    + "ORDER BY jornada.id_jornada");
        ResultSet rs;
        rs = sentencia.executeQuery();
        ArrayList <Object> lista = new ArrayList();
        while(rs.next()){
            String [] fila = new String[4];
            fila[0] = rs.getString("jornada");
            fila[1] = rs.getString("equipos");
            fila[2] = rs.getString("puntos");
            lista.add(fila);   
        }
        rs.close();
        sentencia.close();
        con.desconectar();
        return lista;
    }
}
