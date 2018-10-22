/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intervention.jpa.sessionBean;

import com.intervention.jpa.Entity.Departement;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pc_ahmed
 */
@Stateless
public class DepartementFacade extends AbstractFacade<Departement> {

    @PersistenceContext(unitName = "application_Gestion_Intervention_des_supportPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartementFacade() {
        super(Departement.class);
    }
    
}
