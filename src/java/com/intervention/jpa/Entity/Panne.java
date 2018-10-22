/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intervention.jpa.Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc_ahmed
 */
@Entity
@Table(name = "panne")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Panne.findAll", query = "SELECT p FROM Panne p"),
    @NamedQuery(name = "Panne.findByIdPanne", query = "SELECT p FROM Panne p WHERE p.idPanne = :idPanne"),
    @NamedQuery(name = "Panne.findByPanne", query = "SELECT p FROM Panne p WHERE p.panne = :panne")})
public class Panne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_panne")
    private Integer idPanne;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "panne")
    private String panne;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPanne")
    private Collection<Reclamation> reclamationCollection;

    public Panne() {
    }

    public Panne(Integer idPanne) {
        this.idPanne = idPanne;
    }

    public Panne(Integer idPanne, String panne) {
        this.idPanne = idPanne;
        this.panne = panne;
    }

    public Integer getIdPanne() {
        return idPanne;
    }

    public void setIdPanne(Integer idPanne) {
        this.idPanne = idPanne;
    }

    public String getPanne() {
        return panne;
    }

    public void setPanne(String panne) {
        this.panne = panne;
    }

    @XmlTransient
    public Collection<Reclamation> getReclamationCollection() {
        return reclamationCollection;
    }

    public void setReclamationCollection(Collection<Reclamation> reclamationCollection) {
        this.reclamationCollection = reclamationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPanne != null ? idPanne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Panne)) {
            return false;
        }
        Panne other = (Panne) object;
        if ((this.idPanne == null && other.idPanne != null) || (this.idPanne != null && !this.idPanne.equals(other.idPanne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.intervention.jpa.Entity.Panne[ idPanne=" + idPanne + " ]";
    }
    
}
