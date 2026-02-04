/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author alunos
 */
@Entity
@Table(name = "visitantes", catalog = "aprender", schema = "")
@NamedQueries({
    @NamedQuery(name = "Visitantes.findAll", query = "SELECT v FROM Visitantes v"),
    @NamedQuery(name = "Visitantes.findByVisCod", query = "SELECT v FROM Visitantes v WHERE v.visCod = :visCod"),
    @NamedQuery(name = "Visitantes.findByVisNome", query = "SELECT v FROM Visitantes v WHERE v.visNome = :visNome"),
    @NamedQuery(name = "Visitantes.findByVisDocumento", query = "SELECT v FROM Visitantes v WHERE v.visDocumento = :visDocumento"),
    @NamedQuery(name = "Visitantes.findByVisEmpresa", query = "SELECT v FROM Visitantes v WHERE v.visEmpresa = :visEmpresa"),
    @NamedQuery(name = "Visitantes.findByVisMotivoEmpresa", query = "SELECT v FROM Visitantes v WHERE v.visMotivoEmpresa = :visMotivoEmpresa"),
    @NamedQuery(name = "Visitantes.findByVisColaborador", query = "SELECT v FROM Visitantes v WHERE v.visColaborador = :visColaborador"),
    @NamedQuery(name = "Visitantes.findByVisCaminhoFoto", query = "SELECT v FROM Visitantes v WHERE v.visCaminhoFoto = :visCaminhoFoto")})
public class Visitantes implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vis_cod")
    private Integer visCod;
    @Basic(optional = false)
    @Column(name = "vis_nome")
    private String visNome;
    @Basic(optional = false)
    @Column(name = "vis_documento")
    private String visDocumento;
    @Column(name = "vis_empresa")
    private String visEmpresa;
    @Column(name = "vis_motivo_empresa")
    private String visMotivoEmpresa;
    @Column(name = "vis_colaborador")
    private String visColaborador;
    @Column(name = "vis_caminho_foto")
    private String visCaminhoFoto;

    public Visitantes() {
    }

    public Visitantes(Integer visCod) {
        this.visCod = visCod;
    }

    public Visitantes(Integer visCod, String visNome, String visDocumento) {
        this.visCod = visCod;
        this.visNome = visNome;
        this.visDocumento = visDocumento;
    }

    public Integer getVisCod() {
        return visCod;
    }

    public void setVisCod(Integer visCod) {
        Integer oldVisCod = this.visCod;
        this.visCod = visCod;
        changeSupport.firePropertyChange("visCod", oldVisCod, visCod);
    }

    public String getVisNome() {
        return visNome;
    }

    public void setVisNome(String visNome) {
        String oldVisNome = this.visNome;
        this.visNome = visNome;
        changeSupport.firePropertyChange("visNome", oldVisNome, visNome);
    }

    public String getVisDocumento() {
        return visDocumento;
    }

    public void setVisDocumento(String visDocumento) {
        String oldVisDocumento = this.visDocumento;
        this.visDocumento = visDocumento;
        changeSupport.firePropertyChange("visDocumento", oldVisDocumento, visDocumento);
    }

    public String getVisEmpresa() {
        return visEmpresa;
    }

    public void setVisEmpresa(String visEmpresa) {
        String oldVisEmpresa = this.visEmpresa;
        this.visEmpresa = visEmpresa;
        changeSupport.firePropertyChange("visEmpresa", oldVisEmpresa, visEmpresa);
    }

    public String getVisMotivoEmpresa() {
        return visMotivoEmpresa;
    }

    public void setVisMotivoEmpresa(String visMotivoEmpresa) {
        String oldVisMotivoEmpresa = this.visMotivoEmpresa;
        this.visMotivoEmpresa = visMotivoEmpresa;
        changeSupport.firePropertyChange("visMotivoEmpresa", oldVisMotivoEmpresa, visMotivoEmpresa);
    }

    public String getVisColaborador() {
        return visColaborador;
    }

    public void setVisColaborador(String visColaborador) {
        String oldVisColaborador = this.visColaborador;
        this.visColaborador = visColaborador;
        changeSupport.firePropertyChange("visColaborador", oldVisColaborador, visColaborador);
    }

    public String getVisCaminhoFoto() {
        return visCaminhoFoto;
    }

    public void setVisCaminhoFoto(String visCaminhoFoto) {
        String oldVisCaminhoFoto = this.visCaminhoFoto;
        this.visCaminhoFoto = visCaminhoFoto;
        changeSupport.firePropertyChange("visCaminhoFoto", oldVisCaminhoFoto, visCaminhoFoto);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visCod != null ? visCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitantes)) {
            return false;
        }
        Visitantes other = (Visitantes) object;
        if ((this.visCod == null && other.visCod != null) || (this.visCod != null && !this.visCod.equals(other.visCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Visitantes[ visCod=" + visCod + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
