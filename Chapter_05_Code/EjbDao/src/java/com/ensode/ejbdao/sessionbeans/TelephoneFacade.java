/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ensode.ejbdao.sessionbeans;

import com.ensode.ejbdao.entities.Telephone;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author heffel
 */
@Stateless
public class TelephoneFacade extends AbstractFacade<Telephone> {
    @PersistenceContext(unitName = "EjbDaoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TelephoneFacade() {
        super(Telephone.class);
    }
    
}
