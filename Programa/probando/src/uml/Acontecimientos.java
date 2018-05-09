/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author v6222
 */
@Entity
@Table(name = "acontecimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acontecimientos.findAll", query = "SELECT a FROM Acontecimientos a")
    , @NamedQuery(name = "Acontecimientos.findById", query = "SELECT a FROM Acontecimientos a WHERE a.id = :id")
    , @NamedQuery(name = "Acontecimientos.findByNombre", query = "SELECT a FROM Acontecimientos a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Acontecimientos.findByLugar", query = "SELECT a FROM Acontecimientos a WHERE a.lugar = :lugar")
    , @NamedQuery(name = "Acontecimientos.findByFecha", query = "SELECT a FROM Acontecimientos a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "Acontecimientos.findByHoraI", query = "SELECT a FROM Acontecimientos a WHERE a.horaI = :horaI")
    , @NamedQuery(name = "Acontecimientos.findByHoraF", query = "SELECT a FROM Acontecimientos a WHERE a.horaF = :horaF")
    , @NamedQuery(name = "Acontecimientos.findByAforo", query = "SELECT a FROM Acontecimientos a WHERE a.aforo = :aforo")})
public class Acontecimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "lugar")
    private String lugar;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "hora_i")
    @Temporal(TemporalType.TIME)
    private Date horaI;
    @Basic(optional = false)
    @Column(name = "hora_f")
    @Temporal(TemporalType.TIME)
    private Date horaF;
    @Basic(optional = false)
    @Column(name = "aforo")
    private int aforo;

    public Acontecimientos() {
    }

    public Acontecimientos(Integer id) {
        this.id = id;
    }

    public Acontecimientos(Integer id, String nombre, String lugar, Date fecha, Date horaI, Date horaF, int aforo) {
        this.id = id;
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.horaI = horaI;
        this.horaF = horaF;
        this.aforo = aforo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraI() {
        return horaI;
    }

    public void setHoraI(Date horaI) {
        this.horaI = horaI;
    }

    public Date getHoraF() {
        return horaF;
    }

    public void setHoraF(Date horaF) {
        this.horaF = horaF;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acontecimientos)) {
            return false;
        }
        Acontecimientos other = (Acontecimientos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uml.Acontecimientos[ id=" + id + " ]";
    }
    
}
