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
 * @author lucas
 */
@Entity
@Table(name = "carros", catalog = "aprender", schema = "")
@NamedQueries({
    @NamedQuery(name = "Carros.findAll", query = "SELECT c FROM Carros c"),
    @NamedQuery(name = "Carros.findByCarroId", query = "SELECT c FROM Carros c WHERE c.carroId = :carroId"),
    @NamedQuery(name = "Carros.findByCliPlaca", query = "SELECT c FROM Carros c WHERE c.cliPlaca = :cliPlaca"),
    @NamedQuery(name = "Carros.findByCliModelo", query = "SELECT c FROM Carros c WHERE c.cliModelo = :cliModelo"),
    @NamedQuery(name = "Carros.findByCliCor", query = "SELECT c FROM Carros c WHERE c.cliCor = :cliCor"),
    @NamedQuery(name = "Carros.findByCliTipo", query = "SELECT c FROM Carros c WHERE c.cliTipo = :cliTipo"),
    @NamedQuery(name = "Carros.findByCliStatus", query = "SELECT c FROM Carros c WHERE c.cliStatus = :cliStatus"),
    @NamedQuery(name = "Carros.findByCliNumero", query = "SELECT c FROM Carros c WHERE c.cliNumero = :cliNumero"),
    @NamedQuery(name = "Carros.findByVisitanteId", query = "SELECT c FROM Carros c WHERE c.visitanteId = :visitanteId")})
public class Carros implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "carro_id")
    private Integer carroId;
    @Basic(optional = false)
    @Column(name = "cli_placa")
    private String cliPlaca;
    @Basic(optional = false)
    @Column(name = "cli_modelo")
    private String cliModelo;
    @Column(name = "cli_cor")
    private String cliCor;
    @Column(name = "cli_tipo")
    private String cliTipo;
    @Column(name = "cli_status")
    private String cliStatus;
    @Column(name = "cli_numero")
    private String cliNumero;
    @Column(name = "visitante_id")
    private Integer visitanteId;

    public Carros() {
    }

    public Carros(Integer carroId) {
        this.carroId = carroId;
    }

    public Carros(Integer carroId, String cliPlaca, String cliModelo) {
        this.carroId = carroId;
        this.cliPlaca = cliPlaca;
        this.cliModelo = cliModelo;
    }

    public Integer getCarroId() {
        return carroId;
    }

    public void setCarroId(Integer carroId) {
        Integer oldCarroId = this.carroId;
        this.carroId = carroId;
        changeSupport.firePropertyChange("carroId", oldCarroId, carroId);
    }

    public String getCliPlaca() {
        return cliPlaca;
    }

    public void setCliPlaca(String cliPlaca) {
        String oldCliPlaca = this.cliPlaca;
        this.cliPlaca = cliPlaca;
        changeSupport.firePropertyChange("cliPlaca", oldCliPlaca, cliPlaca);
    }

    public String getCliModelo() {
        return cliModelo;
    }

    public void setCliModelo(String cliModelo) {
        String oldCliModelo = this.cliModelo;
        this.cliModelo = cliModelo;
        changeSupport.firePropertyChange("cliModelo", oldCliModelo, cliModelo);
    }

    public String getCliCor() {
        return cliCor;
    }

    public void setCliCor(String cliCor) {
        String oldCliCor = this.cliCor;
        this.cliCor = cliCor;
        changeSupport.firePropertyChange("cliCor", oldCliCor, cliCor);
    }

    public String getCliTipo() {
        return cliTipo;
    }

    public void setCliTipo(String cliTipo) {
        String oldCliTipo = this.cliTipo;
        this.cliTipo = cliTipo;
        changeSupport.firePropertyChange("cliTipo", oldCliTipo, cliTipo);
    }

    public String getCliStatus() {
        return cliStatus;
    }

    public void setCliStatus(String cliStatus) {
        String oldCliStatus = this.cliStatus;
        this.cliStatus = cliStatus;
        changeSupport.firePropertyChange("cliStatus", oldCliStatus, cliStatus);
    }

    public String getCliNumero() {
        return cliNumero;
    }

    public void setCliNumero(String cliNumero) {
        String oldCliNumero = this.cliNumero;
        this.cliNumero = cliNumero;
        changeSupport.firePropertyChange("cliNumero", oldCliNumero, cliNumero);
    }

    public Integer getVisitanteId() {
        return visitanteId;
    }

    public void setVisitanteId(Integer visitanteId) {
        Integer oldVisitanteId = this.visitanteId;
        this.visitanteId = visitanteId;
        changeSupport.firePropertyChange("visitanteId", oldVisitanteId, visitanteId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carroId != null ? carroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carros)) {
            return false;
        }
        Carros other = (Carros) object;
        if ((this.carroId == null && other.carroId != null) || (this.carroId != null && !this.carroId.equals(other.carroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Carros[ carroId=" + carroId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
