
package dao;

import static dao.GenericDao.getEM;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import model.Cliente;
import model.Finalizaraluguel;


public class FinalizarAluguelDao extends GenericDao<Finalizaraluguel, Integer> {
    public List<Finalizaraluguel> getLista() {
        EntityManager em = getEM();
        try {
            List<Finalizaraluguel> finalizarAluguel;
            em.getTransaction().begin();
            finalizarAluguel = em.createQuery("select f from Finalizaraluguel f").getResultList();
            em.getTransaction().commit();
            return finalizarAluguel;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

   public Finalizaraluguel BuscaPorId(int id) {
        EntityManager em = getEM();
        Finalizaraluguel finalizarAluguel = null;
        try {
            finalizarAluguel = em.find(Finalizaraluguel.class, id);
            em.getTransaction().begin();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return finalizarAluguel;

    }
   
   public Finalizaraluguel salvar(Finalizaraluguel finalizarAluguel) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(finalizarAluguel);
            em.getTransaction().commit();
            
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return finalizarAluguel;
    }
    
   public Finalizaraluguel ApagaCliente(int id) {
        EntityManager em = getEM();
        Finalizaraluguel finalizarAluguel = null;
        try {
            finalizarAluguel = em.find(Finalizaraluguel.class, id);
            em.getTransaction().begin();
            em.remove(finalizarAluguel);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return finalizarAluguel;

    }
    
}
