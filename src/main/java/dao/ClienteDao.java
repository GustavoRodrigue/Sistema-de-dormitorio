
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import model.Cliente;


public class ClienteDao extends GenericDao<Cliente, Integer>{

    public List<Cliente> getLista() {
        EntityManager em = getEM();
        try {
            List<Cliente> clientes;
            em.getTransaction().begin();
            clientes = em.createQuery("select c from Cliente c").getResultList();
            em.getTransaction().commit();
            return clientes;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

   public Cliente BuscaPorId(int id) {
        EntityManager em = getEM();
        Cliente cliente = null;
        try {
            cliente = em.find(Cliente.class, id);
            em.getTransaction().begin();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return cliente;

    }
   
   public Cliente salvar(Cliente cliente) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return cliente;
    }
    
   public Cliente ApagaCliente(int id) {
        EntityManager em = getEM();
        Cliente cliente = null;
        try {
            cliente = em.find(Cliente.class, id);
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return cliente;

    }
    
}
