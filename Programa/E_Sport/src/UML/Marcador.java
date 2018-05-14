/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

/**
 * Clase en la que definiremos los equipos que se enfrentan en un partido, la puntuación final de cada uno, y el equipo local/visitante.
 * Fecha de creación de la clase: 23/04/2018
 * @author eqdaw04
 */

public class Marcador {
    private int idMarcador;
    private Partido partido;
    private Equipo equipo;
    private int puntos;
    private boolean visitante;

    public Marcador() {
    }

    public int getIdMarcador() {
        return idMarcador;
    }

    public void setIdMarcador(int idMarcador) {
        this.idMarcador = idMarcador;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public boolean isVisitante() {
        return visitante;
    }

    public void setVisitante(boolean visitante) {
        this.visitante = visitante;
    }
}
