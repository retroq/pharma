/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.searchengine;

import entity.Drug;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author anton
 */
@Stateless
@LocalBean
public class SearchEngine {
    
    @PersistenceUnit
    private EntityManagerFactory emf;
    
    public   SearchResult findDrugs(String searchString) {
        EntityManager em = emf.createEntityManager();
        //Query q = em.createQuery("SELECT d FROM Drug d JOIN d.realiseName r WHERE r.name LIKE :ss").setParameter("ss", searchString+"%");
         List<Drug> byName = em.createQuery("SELECT d FROM Drug d WHERE d.realiseName.name LIKE :ss").setParameter("ss", searchString+"%").getResultList(),
                 byCompany = em.createQuery("SELECT d FROM Drug d WHERE d.company.name LIKE :ss").setParameter("ss", searchString+"%").getResultList(),
                 byActiveComponent = em.createQuery("SELECT d FROM Drug d WHERE d.activeComponent.name LIKE :ss").setParameter("ss", searchString+"%").getResultList();
         
        
       
        return  new SearchResult(byName, byCompany, byActiveComponent);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
