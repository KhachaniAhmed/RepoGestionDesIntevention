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
@Table(name = "materiel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiel.findAll", query = "SELECT m FROM Materiel m"),
    @NamedQuery(name = "Materiel.findByNumeroMateriel", query = "SELECT m FROM Materiel m WHERE m.numeroMateriel = :numeroMateriel"),
    @NamedQuery(name = "Materiel.findByTypeMateriel", query = "SELECT m FROM Materiel m WHERE m.typeMateriel = :typeMateriel")})
public class Materiel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_Materiel")
    private Integer numeroMateriel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "type_Materiel")
    private String typeMateriel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroMateriel")
    private Collection<Fournisseur> fournisseurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroMateriel")
    private Collection<Reclamation> reclamationCollection;

    public Materiel() {
    }

    public Materiel(Integer numeroMateriel) {
        this.numeroMateriel = numeroMateriel;
    }

    public Materiel(Integer numeroMateriel, String typeMateriel) {
        this.numeroMateriel = numeroMateriel;
        this.typeMateriel = typeMateriel;
    }

    public Integer getNumeroMateriel() {
        return numeroMateriel;
    }

    public void setNumeroMateriel(Integer numeroMateriel) {
        this.numeroMateriel = numeroMateriel;
    }

    public String getTypeMateriel() {
        return typeMateriel;
    }

    public void setTypeMateriel(String typeMateriel) {
        this.typeMateriel = typeMateriel;
    }

    @XmlTransient
    public Collection<Fournisseur> getFournisseurCollection() {
        return fournisseurCollection;
    }

    public void setFournisseurCollection(Collection<Fournisseur> fournisseurCollection) {
        this.fournisseurCollection = fournisseurCollection;
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
        hash += (numeroMateriel != null ? numeroMateriel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiel)) {
            return false;
        }
        Materiel other = (Materiel) object;
        if ((this.numeroMateriel == null && other.numeroMateriel != null) || (this.numeroMateriel != null && !this.numeroMateriel.equals(other.numeroMateriel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.intervention.jpa.Entity.Materiel[ numeroMateriel=" + numeroMateriel + " ]";
    }
    
}
