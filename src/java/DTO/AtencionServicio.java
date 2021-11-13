/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristian
 */
@Entity
@Table(name = "Atencion_Servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtencionServicio.findAll", query = "SELECT a FROM AtencionServicio a"),
    @NamedQuery(name = "AtencionServicio.findById", query = "SELECT a FROM AtencionServicio a WHERE a.id = :id"),
    @NamedQuery(name = "AtencionServicio.findByKilometraje", query = "SELECT a FROM AtencionServicio a WHERE a.kilometraje = :kilometraje"),
    @NamedQuery(name = "AtencionServicio.findByFecha", query = "SELECT a FROM AtencionServicio a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "AtencionServicio.findByHora", query = "SELECT a FROM AtencionServicio a WHERE a.hora = :hora")})
public class AtencionServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "kilometraje")
    private int kilometraje;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idFichaTecnica", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FichaTecnica idFichaTecnica;
    @JoinColumn(name = "idCalificacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Calificacion idCalificacion;
    @JoinColumn(name = "idCita", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cita idCita;
    @JoinColumn(name = "idFactura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Factura idFactura;
    @JoinColumn(name = "idPersona", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAtencionServicio")
    private List<DetallesProducto> detallesProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAntencionServicio")
    private List<DetallesServicio> detallesServicioList;

    public AtencionServicio() {
    }

    public AtencionServicio(Integer id) {
        this.id = id;
    }

    public AtencionServicio(Integer id, int kilometraje, Date fecha, Date hora, String descripcion) {
        this.id = id;
        this.kilometraje = kilometraje;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FichaTecnica getIdFichaTecnica() {
        return idFichaTecnica;
    }

    public void setIdFichaTecnica(FichaTecnica idFichaTecnica) {
        this.idFichaTecnica = idFichaTecnica;
    }

    public Calificacion getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Calificacion idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Cita getIdCita() {
        return idCita;
    }

    public void setIdCita(Cita idCita) {
        this.idCita = idCita;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @XmlTransient
    public List<DetallesProducto> getDetallesProductoList() {
        return detallesProductoList;
    }

    public void setDetallesProductoList(List<DetallesProducto> detallesProductoList) {
        this.detallesProductoList = detallesProductoList;
    }

    @XmlTransient
    public List<DetallesServicio> getDetallesServicioList() {
        return detallesServicioList;
    }

    public void setDetallesServicioList(List<DetallesServicio> detallesServicioList) {
        this.detallesServicioList = detallesServicioList;
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
        if (!(object instanceof AtencionServicio)) {
            return false;
        }
        AtencionServicio other = (AtencionServicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.AtencionServicio[ id=" + id + " ]";
    }
    
}
