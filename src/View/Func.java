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
@Table(name = "func", catalog = "aprender", schema = "")
@NamedQueries({
    @NamedQuery(name = "Func.findAll", query = "SELECT f FROM Func f"),
    @NamedQuery(name = "Func.findByFuncId", query = "SELECT f FROM Func f WHERE f.funcId = :funcId"),
    @NamedQuery(name = "Func.findByCliNome", query = "SELECT f FROM Func f WHERE f.cliNome = :cliNome"),
    @NamedQuery(name = "Func.findByCliEmail", query = "SELECT f FROM Func f WHERE f.cliEmail = :cliEmail"),
    @NamedQuery(name = "Func.findByCliSenha", query = "SELECT f FROM Func f WHERE f.cliSenha = :cliSenha"),
    @NamedQuery(name = "Func.findByCliTipo", query = "SELECT f FROM Func f WHERE f.cliTipo = :cliTipo"),
    @NamedQuery(name = "Func.findByFotoPath", query = "SELECT f FROM Func f WHERE f.fotoPath = :fotoPath")})
public class Func implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "func_id")
    private Integer funcId;
    @Basic(optional = false)
    @Column(name = "cli_nome")
    private String cliNome;
    @Basic(optional = false)
    @Column(name = "cli_email")
    private String cliEmail;
    @Basic(optional = false)
    @Column(name = "cli_senha")
    private String cliSenha;
    @Basic(optional = false)
    @Column(name = "cli_tipo")
    private String cliTipo;
    @Column(name = "foto_path")
    private String fotoPath;

    public Func() {
    }

    public Func(Integer funcId) {
        this.funcId = funcId;
    }

    public Func(Integer funcId, String cliNome, String cliEmail, String cliSenha, String cliTipo) {
        this.funcId = funcId;
        this.cliNome = cliNome;
        this.cliEmail = cliEmail;
        this.cliSenha = cliSenha;
        this.cliTipo = cliTipo;
    }

    public Integer getFuncId() {
        return funcId;
    }

    public void setFuncId(Integer funcId) {
        Integer oldFuncId = this.funcId;
        this.funcId = funcId;
        changeSupport.firePropertyChange("funcId", oldFuncId, funcId);
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        String oldCliNome = this.cliNome;
        this.cliNome = cliNome;
        changeSupport.firePropertyChange("cliNome", oldCliNome, cliNome);
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        String oldCliEmail = this.cliEmail;
        this.cliEmail = cliEmail;
        changeSupport.firePropertyChange("cliEmail", oldCliEmail, cliEmail);
    }

    public String getCliSenha() {
        return cliSenha;
    }

    public void setCliSenha(String cliSenha) {
        String oldCliSenha = this.cliSenha;
        this.cliSenha = cliSenha;
        changeSupport.firePropertyChange("cliSenha", oldCliSenha, cliSenha);
    }

    public String getCliTipo() {
        return cliTipo;
    }

    public void setCliTipo(String cliTipo) {
        String oldCliTipo = this.cliTipo;
        this.cliTipo = cliTipo;
        changeSupport.firePropertyChange("cliTipo", oldCliTipo, cliTipo);
    }

    public String getFotoPath() {
        return fotoPath;
    }

    public void setFotoPath(String fotoPath) {
        String oldFotoPath = this.fotoPath;
        this.fotoPath = fotoPath;
        changeSupport.firePropertyChange("fotoPath", oldFotoPath, fotoPath);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcId != null ? funcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Func)) {
            return false;
        }
        Func other = (Func) object;
        if ((this.funcId == null && other.funcId != null) || (this.funcId != null && !this.funcId.equals(other.funcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Func[ funcId=" + funcId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
