package UML;

import java.util.ArrayList;

public class Jornada {
    private int idJornada;
    
    private ArrayList<Partido> listaPartidos;

    public Jornada() {
        listaPartidos = new ArrayList();
    }

    public Jornada(int idJornada) {
        this.idJornada = idJornada;
        listaPartidos = new ArrayList();
    }

    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public ArrayList<Partido> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(ArrayList<Partido> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }
}
