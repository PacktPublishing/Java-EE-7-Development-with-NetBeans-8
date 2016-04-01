/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ensode.jpacontroller;

import com.ensode.jpa.UsState;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author heffel
 */
@Stateless
public class UsStateFacade extends AbstractFacade<UsState> {
    @PersistenceContext(unitName = "jsfjpacrudPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsStateFacade() {
        super(UsState.class);
    }
    
}
