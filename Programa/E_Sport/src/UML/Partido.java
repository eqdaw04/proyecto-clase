package UML;

import java.util.Calendar;

/**
 * Clase en la que definiremos el día, lugar y hora de un partido.
 * Fecha de creación de la clase: 23/04/2018
 * @author eqdaw04
 */

public class Partido {
    private int idPartido;
    private Calendar fecha;
    
    private Equipo eLocal, eVisitante;
    int mLocal, mVisitante;

    public Partido() {
    }

    public Partido(int idPartido, Calendar fecha, Equipo eLocal, Equipo eVisitante, int mLocal, int mVisitante) {
        this.idPartido = idPartido;
        this.fecha = fecha;
        this.eLocal = eLocal;
        this.eVisitante = eVisitante;
        this.mLocal = mLocal;
        this.mVisitante = mVisitante;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Equipo geteLocal() {
        return eLocal;
    }

    public void seteLocal(Equipo eLocal) {
        this.eLocal = eLocal;
    }

    public Equipo geteVisitante() {
        return eVisitante;
    }

    public void seteVisitante(Equipo eVisitante) {
        this.eVisitante = eVisitante;
    }

    public int getmLocal() {
        return mLocal;
    }

    public void setmLocal(int mLocal) {
        this.mLocal = mLocal;
    }

    public int getmVisitante() {
        return mVisitante;
    }

    public void setmVisitante(int mVisitante) {
        this.mVisitante = mVisitante;
    }
    
}
