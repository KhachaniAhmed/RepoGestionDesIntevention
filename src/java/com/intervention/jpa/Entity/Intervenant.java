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
@Table(name = "intervenant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intervenant.findAll", query = "SELECT i FROM Intervenant i"),
    @NamedQuery(name = "Intervenant.findByMatriculeintervenant", query = "SELECT i FROM Intervenant i WHERE i.matriculeintervenant = :matriculeintervenant"),
    @NamedQuery(name = "Intervenant.findByNomintervenant", query = "SELECT i FROM Intervenant i WHERE i.nomintervenant = :nomintervenant"),
    @NamedQuery(name = "Intervenant.findByLogin", query = "SELECT i FROM Intervenant i WHERE i.login = :login"),
    @NamedQuery(name = "Intervenant.findByPassword", query = "SELECT i FROM Intervenant i WHERE i.password = :password"),
    @NamedQuery(name = "Intervenant.findByType", query = "SELECT i FROM Intervenant i WHERE i.type = :type"),
    @NamedQuery(name = "Intervenant.findByEmail", query = "SELECT i FROM Intervenant i WHERE i.email = :email"),
    @NamedQuery(name = "Intervenant.findByTel", query = "SELECT i FROM Intervenant i WHERE i.tel = :tel")})
public class Intervenant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Matricule_intervenant")
    private Integer matriculeintervenant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Nom_intervenant")
    private String nomintervenant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Type")
    private String type;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tel")
    private int tel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matriculeIntervenant")
    private Collection<Intervention> interventionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matriculeIntervenant")
    private Collection<Reclamation> reclamationCollection;

    public Intervenant() {
    }

    public Intervenant(Integer matriculeintervenant) {
        this.matriculeintervenant = matriculeintervenant;
    }

    public Intervenant(Integer matriculeintervenant, String nomintervenant, String login, String password, String type, String email, int tel) {
        this.matriculeintervenant = matriculeintervenant;
        this.nomintervenant = nomintervenant;
        this.login = login;
        this.password = password;
        this.type = type;
        this.email = email;
        this.tel = tel;
    }

    public Integer getMatriculeintervenant() {
        return matriculeintervenant;
    }

    public void setMatriculeintervenant(Integer matriculeintervenant) {
        this.matriculeintervenant = matriculeintervenant;
    }

    public String getNomintervenant() {
        return nomintervenant;
    }

    public void setNomintervenant(String nomintervenant) {
        this.nomintervenant = nomintervenant;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @XmlTransient
    public Collection<Intervention> getInterventionCollection() {
        return interventionCollection;
    }

    public void setInterventionCollection(Collection<Intervention> interventionCollection) {
        this.interventionCollection = interventionCollection;
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
        hash += (matriculeintervenant != null ? matriculeintervenant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Intervenant)) {
            return false;
        }
        Intervenant other = (Intervenant) object;
        if ((this.matriculeintervenant == null && other.matriculeintervenant != null) || (this.matriculeintervenant != null && !this.matriculeintervenant.equals(other.matriculeintervenant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.intervention.jpa.Entity.Intervenant[ matriculeintervenant=" + matriculeintervenant + " ]";
    }
    
}
