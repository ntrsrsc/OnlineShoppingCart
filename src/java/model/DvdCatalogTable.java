/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Reo
 */
public class DvdCatalogTable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");

    public static List<DvdCatalog> findAllDvdCatalog() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        List<DvdCatalog> catalogList = null;
        try {
            catalogList = (Vector<DvdCatalog>) em.createNamedQuery("DvdCatalog.findAll").getResultList();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return catalogList;
    }
    
    public static DvdCatalog findDvdCatalogById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        DvdCatalog catalog = null;
        try {
            catalog = em.find(DvdCatalog.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return catalog;
    }
    
}
