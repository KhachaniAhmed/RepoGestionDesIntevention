/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intervention.jpa.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc_ahmed
 */
@Entity
@Table(name = "fournisseur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f"),
    @NamedQuery(name = "Fournisseur.findByNumeroFournisseur", query = "SELECT f FROM Fournisseur f WHERE f.numeroFournisseur = :numeroFournisseur"),
    @NamedQuery(name = "Fournisseur.findByNomFournisseur", query = "SELECT f FROM Fournisseur f WHERE f.nomFournisseur = :nomFournisseur"),
    @NamedQuery(name = "Fournisseur.findByAdresse", query = "SELECT f FROM Fournisseur f WHERE f.adresse = :adresse"),
    @NamedQuery(name = "Fournisseur.findByTel", query = "SELECT f FROM Fournisseur f WHERE f.tel = :tel"),
    @NamedQuery(name = "Fournisseur.findByEmail", query = "SELECT f FROM Fournisseur f WHERE f.email = :email")})
public class Fournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Numero_Fournisseur")
    private Integer numeroFournisseur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_Fournisseur")
    private String nomFournisseur;
    @Size(max = 70)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "tel")
    private String tel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "numero_materiel", referencedColumnName = "numero_Materiel")
    @ManyToOne(optional = false)
    private Materiel numeroMateriel;

    public Fournisseur() {
    }

    public Fournisseur(Integer numeroFournisseur) {
        this.numeroFournisseur = numeroFournisseur;
    }

    public Fournisseur(Integer numeroFournisseur, String nomFournisseur, String tel) {
        this.numeroFournisseur = numeroFournisseur;
        this.nomFournisseur = nomFournisseur;
        this.tel = tel;
    }

    public Integer getNumeroFournisseur() {
        return numeroFournisseur;
    }

    public void setNumeroFournisseur(Integer numeroFournisseur) {
        this.numeroFournisseur = numeroFournisseur;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Materiel getNumeroMateriel() {
        return numeroMateriel;
    }

    public void setNumeroMateriel(Materiel numeroMateriel) {
        this.numeroMateriel = numeroMateriel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroFournisseur != null ? numeroFournisseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.numeroFournisseur == null && other.numeroFournisseur != null) || (this.numeroFournisseur != null && !this.numeroFournisseur.equals(other.numeroFournisseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.intervention.jpa.Entity.Fournisseur[ numeroFournisseur=" + numeroFournisseur + " ]";
    }
    
}
