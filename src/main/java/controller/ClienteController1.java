/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "ClienteController1", urlPatterns = {"/ClienteController1"})
public class ClienteController1 extends HttpServlet {

    String update = "update";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession sessao = request.getSession();
//        String[] dados = (String[])sessao.getAttribute("dados");;
        update = "alterar";

        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Cliente cliente = new Cliente();
            ClienteDao dao = new ClienteDao();
            if (request.getParameter("acao").equals("alterar")) {
                cliente = dao.BuscaPorId(codigo);
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/CadastroCliente.jsp");
                request.setAttribute("cliente", cliente);
                disp.forward(request, response);
            } else if (request.getParameter("acao").equals("excluir")) {
                dao.ApagaCliente(codigo);
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/CadastroCliente.jsp");

                sessao.invalidate();
                out.println("<script>alert('Cliente excluido com sucesso!');</script>");
                out.println("<script>location.href='./cliente.jsp'</script>");
            }
        } catch (Exception e) {;
            System.out.println("Erro ao recuperar usuario!");

        }

//        if(request.getParameter("alterar")!=null && Integer.parseInt(request.getParameter("alterar")) == Integer.parseInt(dados[0]) ){
//            RequestDispatcher disp = getServletContext().getRequestDispatcher("/CadastroCliente.jsp");
//            request.setAttribute("cliente", cliente);
//            disp.forward(request, response);
//        }else if(request.getParameter("apagar")!=null && Integer.parseInt(request.getParameter("apagar")) == Integer.parseInt(dados[0])){
//            dao.ApagaCliente(cliente.getId());
//            RequestDispatcher disp = getServletContext().getRequestDispatcher("/CadastroCliente.jsp");
//            
//            sessao.invalidate();
//            out.println("<script>alert('Cliente excluido com sucesso!');</script>");
//            out.println("<script>location.href='./index.jsp'</script>");
//        }else{
//            out.println("<script>alert('Codigo do usuario nao incontrado ou invalido!');</script>");
//        };
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String menssagem = "";

        ClienteDao dao = new ClienteDao();
        Cliente cliente = new Cliente();
        try {

            if (update.equals("alterar")) {

                cliente.setId(Integer.parseInt(request.getParameter("id")));
                cliente.setNome(request.getParameter("nome"));
                cliente.setCpf(request.getParameter("cpf"));
                dao.atualizar(cliente);
                menssagem = "alterado com Sucesso! ";
            } else {
                cliente.setNome(request.getParameter("nome"));
                cliente.setCpf(request.getParameter("cpf"));

                dao.salvar(cliente);

                menssagem = "Salvo com Sucesso! ";
                //menssagem = "Usuario cadstrado com sucesso";;
            }
        } catch (Exception e) {
            menssagem = "Erro ao gravar usuario!";
        }
        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + menssagem + "');</script>");
        out.println("<script>location.href='./cliente.jsp'</script>");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
