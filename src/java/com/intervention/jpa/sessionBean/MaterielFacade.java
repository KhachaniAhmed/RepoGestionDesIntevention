/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intervention.jpa.sessionBean;

import com.intervention.jpa.Entity.Materiel;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pc_ahmed
 */
@Stateless
public class MaterielFacade extends AbstractFacade<Materiel> {

    @PersistenceContext(unitName = "application_Gestion_Intervention_des_supportPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaterielFacade() {
        super(Materiel.class);
    }
    
}
