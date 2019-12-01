package dao;

import static dao.GenericDao.getEM;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import model.Usuario;

public class UsuarioDao extends GenericDao<Usuario, Integer> {

    public List<Usuario> getLista() {
        EntityManager em = getEM();
        try {
            List<Usuario> usuarios;
            em.getTransaction().begin();
            usuarios = em.createQuery("select u from Usuario u").getResultList();
            em.getTransaction().commit();
            return usuarios;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public Usuario BuscaPorId(int id) {
        EntityManager em = getEM();
        Usuario usuario = null;
        try {
            usuario = em.find(Usuario.class, id);
            em.getTransaction().begin();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
        return usuario;

    }

    public Usuario salvar(Usuario usuario) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();

        } catch (Exception e) {
        } finally {
            em.close();
        }
        return usuario;
    }

    public Usuario ApagaCliente(int id) {
        EntityManager em = getEM();
        Usuario usuario = null;
        try {
            usuario = em.find(Usuario.class, id);
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return usuario;

    }
}
