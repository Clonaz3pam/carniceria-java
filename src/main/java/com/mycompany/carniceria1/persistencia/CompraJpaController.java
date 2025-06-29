
package com.mycompany.carniceria1.persistencia;

import com.mycompany.carniceria1.logica.Compra;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.carniceria1.logica.DetalleCompra;
import com.mycompany.carniceria1.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CompraJpaController implements Serializable {

    public CompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public CompraJpaController (){
        emf = Persistence.createEntityManagerFactory("carniceriaPU");
    }
    
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Compra compra) {
    if (compra.getListaDetalles() == null) {
        compra.setListaDetalles(new ArrayList<>());
    }

    EntityManager em = null;
    try {
        em = getEntityManager();
        em.getTransaction().begin();

        // Asociar la compra a cada detalle ANTES de persistir
        for (DetalleCompra detalle : compra.getListaDetalles()) {
            detalle.setCompra(compra);
        }

        em.persist(compra); // Esto guarda también los detalles si la relación tiene CascadeType.ALL

        em.getTransaction().commit();
    } finally {
        if (em != null) {
            em.close();
        }
    }
}


    public void edit(Compra compra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra persistentCompra = em.find(Compra.class, compra.getId());
            List<DetalleCompra> listaDetallesOld = persistentCompra.getListaDetalles();
            List<DetalleCompra> listaDetallesNew = compra.getListaDetalles();
            List<DetalleCompra> attachedListaDetallesNew = new ArrayList<DetalleCompra>();
            for (DetalleCompra listaDetallesNewDetalleCompraToAttach : listaDetallesNew) {
                listaDetallesNewDetalleCompraToAttach = em.getReference(listaDetallesNewDetalleCompraToAttach.getClass(), listaDetallesNewDetalleCompraToAttach.getId());
                attachedListaDetallesNew.add(listaDetallesNewDetalleCompraToAttach);
            }
            listaDetallesNew = attachedListaDetallesNew;
            compra.setListaDetalles(listaDetallesNew);
            compra = em.merge(compra);
            for (DetalleCompra listaDetallesOldDetalleCompra : listaDetallesOld) {
                if (!listaDetallesNew.contains(listaDetallesOldDetalleCompra)) {
                    listaDetallesOldDetalleCompra.setCompra(null);
                    listaDetallesOldDetalleCompra = em.merge(listaDetallesOldDetalleCompra);
                }
            }
            for (DetalleCompra listaDetallesNewDetalleCompra : listaDetallesNew) {
                if (!listaDetallesOld.contains(listaDetallesNewDetalleCompra)) {
                    Compra oldCompraOfListaDetallesNewDetalleCompra = listaDetallesNewDetalleCompra.getCompra();
                    listaDetallesNewDetalleCompra.setCompra(compra);
                    listaDetallesNewDetalleCompra = em.merge(listaDetallesNewDetalleCompra);
                    if (oldCompraOfListaDetallesNewDetalleCompra != null && !oldCompraOfListaDetallesNewDetalleCompra.equals(compra)) {
                        oldCompraOfListaDetallesNewDetalleCompra.getListaDetalles().remove(listaDetallesNewDetalleCompra);
                        oldCompraOfListaDetallesNewDetalleCompra = em.merge(oldCompraOfListaDetallesNewDetalleCompra);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = compra.getId();
                if (findCompra(id) == null) {
                    throw new NonexistentEntityException("The compra with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra compra;
            try {
                compra = em.getReference(Compra.class, id);
                compra.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The compra with id " + id + " no longer exists.", enfe);
            }
            List<DetalleCompra> listaDetalles = compra.getListaDetalles();
            for (DetalleCompra listaDetallesDetalleCompra : listaDetalles) {
                listaDetallesDetalleCompra.setCompra(null);
                listaDetallesDetalleCompra = em.merge(listaDetallesDetalleCompra);
            }
            em.remove(compra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Compra> findCompraEntities() {
        return findCompraEntities(true, -1, -1);
    }

    public List<Compra> findCompraEntities(int maxResults, int firstResult) {
        return findCompraEntities(false, maxResults, firstResult);
    }

    private List<Compra> findCompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Compra.class));
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

    public Compra findCompra(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Compra.class, id);
        } finally {
            em.close();
        }
    }

    public int getCompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Compra> rt = cq.from(Compra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
