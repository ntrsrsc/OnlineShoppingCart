/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Reo
 */
public class ShoppingCartTable1 {

    public static List<ShoppingCart1> findCartByIdCatalog(DvdCatalog dvd_id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        List<ShoppingCart1> cart = null;
        try {
            Query query = em.createNamedQuery("ShoppingCart1.findByDvdId");
            query.setParameter("dvdId", dvd_id);
            cart = (List<ShoppingCart1>) query.getResultList();
            if (cart.isEmpty()) {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return cart;
    }
        
    public static int insertShoppingCart1(ShoppingCart1 cart) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cart);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return 1;
    }
    
    public static int updateShoppingCart1(ShoppingCart1 cart) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ShoppingCart1 target = em.find(ShoppingCart1.class, cart.getId());
            if (target == null) {
                return 0;
            }
            target.setQuantity(cart.getQuantity());
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);

        } finally {
            em.close();
            emf.close();
        }
        return 1;

    }
    
    public static List<ShoppingCart1> findAllShoppingCart1() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        List<ShoppingCart1> cartList = null;
        try {
            cartList = (List<ShoppingCart1>) em.createNamedQuery("ShoppingCart1.findAll").getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return cartList;
    }
        
    public static int removeShoppingCart1(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ShoppingCart1 target = em.find(ShoppingCart1.class, id);
            if (target == null) {
                return 0;
            }
            em.remove(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return 1;
    }
    
}
