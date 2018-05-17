/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Controladora.Main;
import UML.Jornada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Timer;
import UML.Equipo;
import UML.Partido;
import java.sql.CallableStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 * Clase en la que controlaremos e introduciremos los partidos a la base de datos.
 * Fecha de creación de la clase: 10/05/2018
 * @author eqdaw04
 */

public class BDPartido {
  
    /**
     * Metodo para insertar un partido a la base de datos.
     * @param p Partido
     * @param jornada Jornada
     * @param con BDConexion
     * @return devuelve el estado "correcto" de la inserción.
     * @throws Exception 
     */
    
    public boolean insertarPartido(Partido p, Jornada jornada, BDConexion con) throws Exception{
        boolean estado = false;
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("INSERT INTO partido (id_partido, fecha, ID_JORNADA) values(?, to_timestamp(?,'RRRR-MM-DD HH24:MI:SS.FF'), ?)");
        sentencia.setInt(1, p.getIdPartido());
        // IMPORTANTE se ha decidido convertir el date long a String porque no habia manera de que java reconozca el long con la máscara
        // java.sql.SQLDataException: ORA-01830: la máscara de formato de fecha termina antes de convertir toda la cadena de entrada
        // sentencia.setTimestamp(2, new java.sql.Timestamp(p.getFecha().getTimeInMillis()));
        sentencia.setString(2, String.valueOf(new java.sql.Timestamp(p.getFecha().getTimeInMillis())));
        sentencia.setInt(3, jornada.getIdJornada());
        int n = sentencia.executeUpdate();
        if(n==1){
            if(insertarEquipoAPartido(p, con)){
                estado = true;
            }
        }
        sentencia.close();
        return estado;
    }
    
    /**
     * Metodo para indicar el equipo que va a jugar en un partido.
     * @param p Partido
     * @param con BDConexion
     * @return devuelve el estado "correcto" si se ha realizado bien la inserción.
     * @throws Exception 
     */
    
    public boolean insertarEquipoAPartido(Partido p, BDConexion con) throws Exception{
        boolean estado = false;
        PreparedStatement sentencia;
        sentencia = null;
        int n = 0;
        // insertar en el marcador el primer equipo
        // 1 es visitante y 0 es local; 1 false 0 true
        if(p.geteLocal().getIdEquipo()!=0){
            sentencia = con.getConnection().prepareStatement("INSERT INTO marcador VALUES (DEFAULT, '0', '1', ?, ?)");
            sentencia.setInt(1, p.getIdPartido());
            sentencia.setInt(2, p.geteLocal().getIdEquipo());
            n = sentencia.executeUpdate();
        }
        // insertar en el marcador el segundo equipo
        if(p.geteVisitante().getIdEquipo()!=0){
            sentencia = con.getConnection().prepareStatement("INSERT INTO marcador VALUES (DEFAULT, '0', '0', ?, ?)");
            sentencia.setInt(1, p.getIdPartido());
            sentencia.setInt(2, p.geteVisitante().getIdEquipo());
            n += sentencia.executeUpdate();
            
        }
        
        if(n==2 || n ==1){
            estado = true;
        }
            
        sentencia.close();
        return estado;
        
    }
    
    /**
     * Metodo para consultar los partido de una jornada.
     * @param jornada int
     * @return devuelve una lista de partidos.
     * @throws Exception 
     */
    
    public ArrayList<Partido> consultarPartidosPorJornada (int jornada) throws Exception{
        ArrayList<Partido> lPartido = new ArrayList();
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM partido WHERE id_jornada = ?");
        sentencia.setInt(1, jornada);
        ResultSet rs;
        rs = sentencia.executeQuery();
        while(rs.next()){
            Partido p = new Partido();
            p.setIdPartido(rs.getInt("id_partido"));
            p.setFecha(DateACalendar(rs.getTimestamp("fecha")));
            lPartido.add(p);
        }
        rs.close();
        sentencia.close();
        con.desconectar();
        return lPartido;
    } 
    public Calendar DateACalendar(Date fecha){
        long as = fecha.getTime();
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(as);
        return c;
    }
    public ArrayList <Partido> consultarPartidoPorFecha(Calendar fecha) throws Exception{
         ArrayList <Partido> listaPartido = new ArrayList();
         BDConexion con = new BDConexion();
         PreparedStatement sentencia;
         sentencia = con.getConnection().prepareStatement("SELECT * FROM partido "
                 + "WHERE fecha >= to_timestamp(?,'RRRR-MM-DD HH24:MI:SS.FF') "
                 + "AND fecha <= to_timestamp(?,'RRRR-MM-DD HH24:MI:SS.FF')");
         sentencia.setString(1, String.valueOf(new java.sql.Timestamp(fecha.getTimeInMillis())));
         sentencia.setString(2, convertirFecha(fecha.getTime()));
         ResultSet rs;
         rs = sentencia.executeQuery();
         while(rs.next()){
            Partido p = new Partido();
            p.setIdPartido(rs.getInt("id_partido"));
            long as = rs.getTimestamp("fecha").getTime();
            consultarMarcadores(p);
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(as);
            p.setFecha(c);
            listaPartido.add(p);
         }
         rs.close();
         sentencia.close();
         con.desconectar();
         return listaPartido;
     }
    
    private String convertirFecha(Date fecha){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String dato = f.format(fecha) + " 23:59:59.00";
        return dato;
    }
    /**
     * Metodo para consultar el marcador de un partido.
     * @param p Partido
     * @return devuelve un objeto Partido
     * @throws Exception 
     */

    public Partido consultarMarcadores(Partido p) throws Exception{
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM marcador WHERE id_partido = ?");
        sentencia.setInt(1, p.getIdPartido());
        ResultSet rs;
        rs = sentencia.executeQuery();
        while(rs.next()){
            // 1 visitante 0 local; 1 = false y 0 = true
            if(rs.getInt("visitante")==1){
                p.setmLocal(rs.getInt("puntuacion"));
                p.seteLocal(Main.consultarEquipoPorNumero(rs.getInt("id_equipo")));
            }
            else{
                p.setmVisitante(rs.getInt("puntuacion"));
                p.seteVisitante(Main.consultarEquipoPorNumero(rs.getInt("id_equipo")));
            }
        }
        rs.close();
        sentencia.close();
        con.desconectar();
        return p;
    }
    
    /**
     * Metodo para modificar un partido. 
     * @param p Partido
     * @return devuelve el estado "correcto" si se ha realizado bien la inserción.
     * @throws Exception 
     */
    
    public boolean modificarPartido(Partido p) throws Exception{
        boolean estado = false;
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("UPDATE partido SET fecha = to_timestamp(?,'RRRR-MM-DD HH24:MI:SS.FF') WHERE id_partido = ?" );
        sentencia.setString(1, String.valueOf(new java.sql.Timestamp(p.getFecha().getTimeInMillis())));
        sentencia.setInt(2, p.getIdPartido());
        if(sentencia.executeUpdate()==1){
            estado = true;
        }
        sentencia.close();
        con.desconectar();
        return estado;
    }
    
    public boolean modificarMarcador(Partido p) throws Exception{
        boolean estado = false;
        BDConexion con = new BDConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("UPDATE marcador SET puntuacion = ? WHERE id_partido = ? and id_equipo = ?" );
        sentencia.setInt(1, p.getmLocal());
        sentencia.setInt(2, p.getIdPartido());
        sentencia.setInt(3, p.geteLocal().getIdEquipo());
                
        if(sentencia.executeUpdate()==1){
            sentencia = con.getConnection().prepareStatement("UPDATE marcador SET puntuacion = ? WHERE id_partido = ? and id_equipo = ?" );
            sentencia.setInt(1, p.getmVisitante());
            sentencia.setInt(2, p.getIdPartido());
            sentencia.setInt(3, p.geteVisitante().getIdEquipo());
            if(sentencia.executeUpdate()==1){
                estado = true;
            }
        }
        sentencia.close();
        con.desconectar();
        return estado;
    }
    public ArrayList<Partido> BuscarPartidosPorJornada (int j) throws Exception{
        ArrayList<Partido> partidos = new ArrayList();
        // abrir conexión
        BDConexion con = new BDConexion();
        // instanciar un array de tipo objeto equipo
        ArrayList a = new ArrayList();
        CallableStatement sentencia;
        // preparar sentencia
        sentencia = con.getConnection().prepareCall("{call Pkg_Jornada.PartidosPorJornada(?,?)}");
        sentencia.setInt(1,j);        
        sentencia.registerOutParameter(2, OracleTypes.CURSOR);
        sentencia.execute();
        // instanciar rs, ejecutar sentencia y cargar los datos al rs
        ResultSet rs = ((OracleCallableStatement)sentencia).getCursor(2);
        Partido p= new Partido();
        while(rs.next()){
            Equipo e=new Equipo();
            e.setIdEquipo(rs.getInt("Id_equipo"));
            e.setNombre(rs.getString("Nombre"));
            e.setLugar(rs.getString("Lugar"));
            if(partidos.isEmpty()){
                p=new Partido();
                p.setIdPartido(rs.getInt("Id_partido"));
                p.setFecha(DateACalendar(rs.getDate("Fecha")));
                if(rs.getInt("visitante")==1){
                    p.seteLocal(e);
                }
                else{
                    p.seteVisitante(e);
                } 
                partidos.add(p);
            }else{
            if(rs.getInt("Id_partido")==partidos.get(partidos.size()-1).getIdPartido()){
                if(rs.getInt("visitante")==1){
                    partidos.get(partidos.size()-1).seteLocal(e);
                }
                else{
                    partidos.get(partidos.size()-1).seteVisitante(e);
                }
            }else{
                p=new Partido();
                p.setIdPartido(rs.getInt("Id_partido"));
                p.setFecha(DateACalendar(rs.getDate("Fecha")));
                if(rs.getInt("visitante")==1){
                    p.seteLocal(e);
                }
                else{
                    p.seteVisitante(e);
                }
                partidos.add(p);
            }
            }                    
        }
        rs.close();
        sentencia.close();
        con.desconectar();
        return partidos;
    }
}
