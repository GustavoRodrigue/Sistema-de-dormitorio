
package bean;

import dao.*;
import model.*;
import java.util.List;
import javax.inject.Inject;


public class ClienteBean {
    @Inject
    private ClienteDao dao;

    public Cliente salvar(Cliente entity) {
        return dao.salvar(entity);
    }

    public List<Cliente> listarTodos() {
        return dao.listarTodos(Cliente.class);
    }

    public Cliente atualizar(Cliente entity) {
        return dao.atualizar(entity);
    }

    public void excluir(Cliente entity) {
        dao.remover(Cliente.class, entity.getId());
    }
 
}
