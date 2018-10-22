/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intervention.jpa.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc_ahmed
 */
@Entity
@Table(name = "reclamation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reclamation.findAll", query = "SELECT r FROM Reclamation r"),
    @NamedQuery(name = "Reclamation.findByNumeroReclamation", query = "SELECT r FROM Reclamation r WHERE r.numeroReclamation = :numeroReclamation"),
    @NamedQuery(name = "Reclamation.findByDescription", query = "SELECT r FROM Reclamation r WHERE r.description = :description"),
    @NamedQuery(name = "Reclamation.findByDate", query = "SELECT r FROM Reclamation r WHERE r.date = :date")})
public class Reclamation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_Reclamation")
    private Integer numeroReclamation;
    @Size(max = 100)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroReclamation")
    private Collection<Intervention> interventionCollection;
    @JoinColumn(name = "id_departement", referencedColumnName = "id_departement")
    @ManyToOne
    private Departement idDepartement;
    @JoinColumn(name = "matricule_intervenant", referencedColumnName = "Matricule_intervenant")
    @ManyToOne(optional = false)
    private Intervenant matriculeIntervenant;
    @JoinColumn(name = "numero_materiel", referencedColumnName = "numero_Materiel")
    @ManyToOne(optional = false)
    private Materiel numeroMateriel;
    @JoinColumn(name = "matricule_operateur", referencedColumnName = "Matricule_operateur")
    @ManyToOne(optional = false)
    private Operateur matriculeOperateur;
    @JoinColumn(name = "id_panne", referencedColumnName = "id_panne")
    @ManyToOne(optional = false)
    private Panne idPanne;
    @JoinColumn(name = "id_projet", referencedColumnName = "id_Projet")
    @ManyToOne
    private Projet idProjet;
    @JoinColumn(name = "id_zone", referencedColumnName = "id_Zone")
    @ManyToOne
    private Zone idZone;

    public Reclamation() {
    }

    public Reclamation(Integer numeroReclamation) {
        this.numeroReclamation = numeroReclamation;
    }

    public Reclamation(Integer numeroReclamation, Date date) {
        this.numeroReclamation = numeroReclamation;
        this.date = date;
    }

    public Integer getNumeroReclamation() {
        return numeroReclamation;
    }

    public void setNumeroReclamation(Integer numeroReclamation) {
        this.numeroReclamation = numeroReclamation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlTransient
    public Collection<Intervention> getInterventionCollection() {
        return interventionCollection;
    }

    public void setInterventionCollection(Collection<Intervention> interventionCollection) {
        this.interventionCollection = interventionCollection;
    }

    public Departement getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(Departement idDepartement) {
        this.idDepartement = idDepartement;
    }

    public Intervenant getMatriculeIntervenant() {
        return matriculeIntervenant;
    }

    public void setMatriculeIntervenant(Intervenant matriculeIntervenant) {
        this.matriculeIntervenant = matriculeIntervenant;
    }

    public Materiel getNumeroMateriel() {
        return numeroMateriel;
    }

    public void setNumeroMateriel(Materiel numeroMateriel) {
        this.numeroMateriel = numeroMateriel;
    }

    public Operateur getMatriculeOperateur() {
        return matriculeOperateur;
    }

    public void setMatriculeOperateur(Operateur matriculeOperateur) {
        this.matriculeOperateur = matriculeOperateur;
    }

    public Panne getIdPanne() {
        return idPanne;
    }

    public void setIdPanne(Panne idPanne) {
        this.idPanne = idPanne;
    }

    public Projet getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(Projet idProjet) {
        this.idProjet = idProjet;
    }

    public Zone getIdZone() {
        return idZone;
    }

    public void setIdZone(Zone idZone) {
        this.idZone = idZone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroReclamation != null ? numeroReclamation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reclamation)) {
            return false;
        }
        Reclamation other = (Reclamation) object;
        if ((this.numeroReclamation == null && other.numeroReclamation != null) || (this.numeroReclamation != null && !this.numeroReclamation.equals(other.numeroReclamation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.intervention.jpa.Entity.Reclamation[ numeroReclamation=" + numeroReclamation + " ]";
    }
    
}
