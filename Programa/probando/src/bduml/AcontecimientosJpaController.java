/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bduml;

import bduml.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import uml.Acontecimientos;

/**
 *
 * @author v6222
 */
public class AcontecimientosJpaController implements Serializable {

    public AcontecimientosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Acontecimientos acontecimientos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(acontecimientos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Acontecimientos acontecimientos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            acontecimientos = em.merge(acontecimientos);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = acontecimientos.getId();
                if (findAcontecimientos(id) == null) {
                    throw new NonexistentEntityException("The acontecimientos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Acontecimientos acontecimientos;
            try {
                acontecimientos = em.getReference(Acontecimientos.class, id);
                acontecimientos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The acontecimientos with id " + id + " no longer exists.", enfe);
            }
            em.remove(acontecimientos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Acontecimientos> findAcontecimientosEntities() {
        return findAcontecimientosEntities(true, -1, -1);
    }

    public List<Acontecimientos> findAcontecimientosEntities(int maxResults, int firstResult) {
        return findAcontecimientosEntities(false, maxResults, firstResult);
    }

    private List<Acontecimientos> findAcontecimientosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Acontecimientos.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Acontecimientos findAcontecimientos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Acontecimientos.class, id);
        } finally {
            em.close();
        }
    }

    public int getAcontecimientosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Acontecimientos> rt = cq.from(Acontecimientos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
