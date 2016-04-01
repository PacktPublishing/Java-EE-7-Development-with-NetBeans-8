/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ensode.jpacontroller;

import com.ensode.jpa.UsCity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author heffel
 */
@Stateless
public class UsCityFacade extends AbstractFacade<UsCity> {
    @PersistenceContext(unitName = "jsfjpacrudPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsCityFacade() {
        super(UsCity.class);
    }
    
}
