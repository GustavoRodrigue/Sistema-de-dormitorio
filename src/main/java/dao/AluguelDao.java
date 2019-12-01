
package dao;

import static dao.GenericDao.getEM;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import model.Aluguel;
import model.Cliente;



public class AluguelDao extends GenericDao<Aluguel, Integer>{
    public List<Aluguel> getLista() {
        EntityManager em = getEM();
        try {
            List<Aluguel> alugueis;
            em.getTransaction().begin();
            alugueis = em.createQuery("select a from Aluguel a").getResultList();
            em.getTransaction().commit();
            return alugueis;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

   public Aluguel BuscaPorId(int id) {
        EntityManager em = getEM();
        Aluguel aluguel = null;
        try {
            aluguel = em.find(Aluguel.class, id);
            em.getTransaction().begin();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return aluguel;

    }
   
   public Aluguel salvar(Aluguel aluguel) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(aluguel);
            em.getTransaction().commit();
            
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return aluguel;
    }
    
   public Aluguel ApagaCliente(int id) {
        EntityManager em = getEM();
        Aluguel aluguel = null;
        try {
            aluguel = em.find(Aluguel.class, id);
            em.getTransaction().begin();
            em.remove(aluguel);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return aluguel;

    }
    
}
