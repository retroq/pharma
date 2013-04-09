/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.RealiseName;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author anton
 */
@Stateless
public class RealiseNameFacade extends AbstractFacade<RealiseName> {
    @PersistenceContext(unitName = "PharmaPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public RealiseNameFacade() {
        super(RealiseName.class);
    }
    
}
