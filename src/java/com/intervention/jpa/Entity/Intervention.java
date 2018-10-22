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
@Table(name = "intervention")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intervention.findAll", query = "SELECT i FROM Intervention i"),
    @NamedQuery(name = "Intervention.findByNumeroIntervention", query = "SELECT i FROM Intervention i WHERE i.numeroIntervention = :numeroIntervention"),
    @NamedQuery(name = "Intervention.findByEtat", query = "SELECT i FROM Intervention i WHERE i.etat = :etat")})
public class Intervention implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_intervention")
    private Integer numeroIntervention;
    @Size(max = 100)
    @Column(name = "etat")
    private String etat;
    @JoinColumn(name = "matricule_intervenant", referencedColumnName = "Matricule_intervenant")
    @ManyToOne(optional = false)
    private Intervenant matriculeIntervenant;
    @JoinColumn(name = "numero_reclamation", referencedColumnName = "numero_Reclamation")
    @ManyToOne(optional = false)
    private Reclamation numeroReclamation;

    public Intervention() {
    }

    public Intervention(Integer numeroIntervention) {
        this.numeroIntervention = numeroIntervention;
    }

    public Integer getNumeroIntervention() {
        return numeroIntervention;
    }

    public void setNumeroIntervention(Integer numeroIntervention) {
        this.numeroIntervention = numeroIntervention;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Intervenant getMatriculeIntervenant() {
        return matriculeIntervenant;
    }

    public void setMatriculeIntervenant(Intervenant matriculeIntervenant) {
        this.matriculeIntervenant = matriculeIntervenant;
    }

    public Reclamation getNumeroReclamation() {
        return numeroReclamation;
    }

    public void setNumeroReclamation(Reclamation numeroReclamation) {
        this.numeroReclamation = numeroReclamation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroIntervention != null ? numeroIntervention.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Intervention)) {
            return false;
        }
        Intervention other = (Intervention) object;
        if ((this.numeroIntervention == null && other.numeroIntervention != null) || (this.numeroIntervention != null && !this.numeroIntervention.equals(other.numeroIntervention))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.intervention.jpa.Entity.Intervention[ numeroIntervention=" + numeroIntervention + " ]";
    }
    
}
