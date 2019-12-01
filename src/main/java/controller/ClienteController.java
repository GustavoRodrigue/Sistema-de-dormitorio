
package controller;

import javax.inject.Inject;
import model.*;
import bean.*;
import java.util.List;
import javax.annotation.PostConstruct;
import util.*;


public class ClienteController {
    @Inject
    private ClienteBean clienteBean;

    private Cliente Cliente;
    
    @Inject
    Msg msg;

    @PostConstruct
    public void init() {
        Cliente = new Cliente();
    }
    
    public String novo() {
        init();
        return "cadastrar";
    }

    public String editar(Cliente Cliente) {
        this.Cliente = Cliente;
        return "editar";
    }

    public void deletar(Cliente entity) {
        clienteBean.excluir(entity);
        init();
    }

     public String salvar() {
        clienteBean.salvar(Cliente);
        init();
        return "listar";
    }
    public String atualizar() {
        clienteBean.atualizar(Cliente);
        init();
        return "listar";
    }
    
    public List<Cliente> listarClientes() {
        return clienteBean.listarTodos();
    }
    
    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }
}
