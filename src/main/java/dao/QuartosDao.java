
package dao;

import static dao.GenericDao.getEM;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import model.Quartos;


public class QuartosDao extends GenericDao<Quartos, Integer>{
    public List<Quartos> getLista() {
        EntityManager em = getEM();
        try {
            List<Quartos> quartos;
            em.getTransaction().begin();
            quartos = em.createQuery("select q from Quartos q").getResultList();
            em.getTransaction().commit();
            return quartos;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

   public Quartos BuscaPorId(int id) {
        EntityManager em = getEM();
        Quartos quartos = null;
        try {
            quartos = em.find(Quartos.class, id);
            em.getTransaction().begin();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return quartos;

    }
   
   public Quartos salvar(Quartos quartos) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(quartos);
            em.getTransaction().commit();
            
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return quartos;
    }
    
   public Quartos ApagaCliente(int id) {
        EntityManager em = getEM();
        Quartos quarto = null;
        try {
            quarto = em.find(Quartos.class, id);
            em.getTransaction().begin();
            em.remove(quarto);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return quarto;

    }
}
