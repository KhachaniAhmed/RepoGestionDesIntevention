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
@Table(name = "operateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operateur.findAll", query = "SELECT o FROM Operateur o"),
    @NamedQuery(name = "Operateur.findByMatriculeoperateur", query = "SELECT o FROM Operateur o WHERE o.matriculeoperateur = :matriculeoperateur"),
    @NamedQuery(name = "Operateur.findByNomOperateur", query = "SELECT o FROM Operateur o WHERE o.nomOperateur = :nomOperateur"),
    @NamedQuery(name = "Operateur.findByPrenommatricule", query = "SELECT o FROM Operateur o WHERE o.prenommatricule = :prenommatricule"),
    @NamedQuery(name = "Operateur.findByTel", query = "SELECT o FROM Operateur o WHERE o.tel = :tel")})
public class Operateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Matricule_operateur")
    private Integer matriculeoperateur;
    @Size(max = 30)
    @Column(name = "Nom_Operateur")
    private String nomOperateur;
    @Size(max = 60)
    @Column(name = "Prenom_matricule")
    private String prenommatricule;
    @Column(name = "Tel")
    private Integer tel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matriculeOperateur")
    private Collection<Reclamation> reclamationCollection;

    public Operateur() {
    }

    public Operateur(Integer matriculeoperateur) {
        this.matriculeoperateur = matriculeoperateur;
    }

    public Integer getMatriculeoperateur() {
        return matriculeoperateur;
    }

    public void setMatriculeoperateur(Integer matriculeoperateur) {
        this.matriculeoperateur = matriculeoperateur;
    }

    public String getNomOperateur() {
        return nomOperateur;
    }

    public void setNomOperateur(String nomOperateur) {
        this.nomOperateur = nomOperateur;
    }

    public String getPrenommatricule() {
        return prenommatricule;
    }

    public void setPrenommatricule(String prenommatricule) {
        this.prenommatricule = prenommatricule;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
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
        hash += (matriculeoperateur != null ? matriculeoperateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operateur)) {
            return false;
        }
        Operateur other = (Operateur) object;
        if ((this.matriculeoperateur == null && other.matriculeoperateur != null) || (this.matriculeoperateur != null && !this.matriculeoperateur.equals(other.matriculeoperateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.intervention.jpa.Entity.Operateur[ matriculeoperateur=" + matriculeoperateur + " ]";
    }
    
}
