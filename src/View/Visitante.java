/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author alunos
 */
@Entity
@Table(name = "visitante", catalog = "aprender", schema = "")
@NamedQueries({
    @NamedQuery(name = "Visitante.findAll", query = "SELECT v FROM Visitante v"),
    @NamedQuery(name = "Visitante.findByVisitanteId", query = "SELECT v FROM Visitante v WHERE v.visitanteId = :visitanteId"),
    @NamedQuery(name = "Visitante.findByNome", query = "SELECT v FROM Visitante v WHERE v.nome = :nome"),
    @NamedQuery(name = "Visitante.findByDocumento", query = "SELECT v FROM Visitante v WHERE v.documento = :documento"),
    @NamedQuery(name = "Visitante.findByEmpresa", query = "SELECT v FROM Visitante v WHERE v.empresa = :empresa"),
    @NamedQuery(name = "Visitante.findByMotivoEmpresa", query = "SELECT v FROM Visitante v WHERE v.motivoEmpresa = :motivoEmpresa"),
    @NamedQuery(name = "Visitante.findByColaborador", query = "SELECT v FROM Visitante v WHERE v.colaborador = :colaborador"),
    @NamedQuery(name = "Visitante.findByHorario", query = "SELECT v FROM Visitante v WHERE v.horario = :horario")})
public class Visitante implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "visitante_id")
    private Integer visitanteId;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "documento")
    private String documento;
    @Column(name = "empresa")
    private String empresa;
    @Column(name = "motivo_empresa")
    private String motivoEmpresa;
    @Column(name = "colaborador")
    private String colaborador;
    
    @Column(name = "foto")
    private String foto;
    @Basic(optional = false)
    @Column(name = "horario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horario;

    public Visitante() {
    }

    public Visitante(Integer visitanteId) {
        this.visitanteId = visitanteId;
    }

    public Visitante(Integer visitanteId, String nome, String documento, Date horario) {
        this.visitanteId = visitanteId;
        this.nome = nome;
        this.documento = documento;
        this.horario = horario;
    }

    public Integer getVisitanteId() {
        return visitanteId;
    }

    public void setVisitanteId(Integer visitanteId) {
        Integer oldVisitanteId = this.visitanteId;
        this.visitanteId = visitanteId;
        changeSupport.firePropertyChange("visitanteId", oldVisitanteId, visitanteId);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        String oldDocumento = this.documento;
        this.documento = documento;
        changeSupport.firePropertyChange("documento", oldDocumento, documento);
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        String oldEmpresa = this.empresa;
        this.empresa = empresa;
        changeSupport.firePropertyChange("empresa", oldEmpresa, empresa);
    }

    public String getMotivoEmpresa() {
        return motivoEmpresa;
    }

    public void setMotivoEmpresa(String motivoEmpresa) {
        String oldMotivoEmpresa = this.motivoEmpresa;
        this.motivoEmpresa = motivoEmpresa;
        changeSupport.firePropertyChange("motivoEmpresa", oldMotivoEmpresa, motivoEmpresa);
    }

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        String oldColaborador = this.colaborador;
        this.colaborador = colaborador;
        changeSupport.firePropertyChange("colaborador", oldColaborador, colaborador);
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        String oldFoto = this.foto;
        this.foto = foto;
        changeSupport.firePropertyChange("foto", oldFoto, foto);
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        Date oldHorario = this.horario;
        this.horario = horario;
        changeSupport.firePropertyChange("horario", oldHorario, horario);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visitanteId != null ? visitanteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitante)) {
            return false;
        }
        Visitante other = (Visitante) object;
        if ((this.visitanteId == null && other.visitanteId != null) || (this.visitanteId != null && !this.visitanteId.equals(other.visitanteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Visitante[ visitanteId=" + visitanteId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
