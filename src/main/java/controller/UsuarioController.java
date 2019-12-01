/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDao;
import dao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

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
            Usuario usuario = new Usuario();
            UsuarioDao dao = new UsuarioDao();
            if (request.getParameter("acao").equals("alterar")) {
                usuario = dao.BuscaPorId(codigo);
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/cadastroUsuario.jsp");
                request.setAttribute("usuario", usuario);
                disp.forward(request, response);
            } else if (request.getParameter("acao").equals("excluir")) {
                dao.ApagaCliente(codigo);
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/cadastroUsuario.jsp");

                sessao.invalidate();
                out.println("<script>alert('Usuario excluido com sucesso!');</script>");
                out.println("<script>location.href='./usuario.jsp'</script>");
            }
        } catch (Exception e) {
            System.out.println("Erro ao recuperar usuario!");

        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");
        String menssagem = "";

        UsuarioDao dao = new UsuarioDao();
        Usuario usuario = new Usuario();
        try {

            if (update.equals("alterar")) {

                usuario.setId(Integer.parseInt(request.getParameter("id")));
                usuario.setNome(request.getParameter("nome"));
                usuario.setEmail(request.getParameter("email"));
                usuario.setCpf(request.getParameter("cpf"));
               
                dao.atualizar(usuario);
                menssagem = "alterado com Sucesso! ";
            } else {
                usuario.setNome(request.getParameter("nome"));
                usuario.setEmail(request.getParameter("email"));
                usuario.setCpf(request.getParameter("cpf"));

                dao.salvar(usuario);

                menssagem = "Salvo com Sucesso! ";
                //menssagem = "Usuario cadstrado com sucesso";;
            }
        } catch (Exception e) {
            menssagem = "Erro ao gravar usuario!";
        }
        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + menssagem + "');</script>");
        out.println("<script>location.href='./usuario.jsp'</script>");
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
