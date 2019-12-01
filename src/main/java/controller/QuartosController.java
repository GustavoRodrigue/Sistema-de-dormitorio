/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuartosDao;
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
import model.Quartos;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "QuartosController", urlPatterns = {"/QuartosController"})
public class QuartosController extends HttpServlet {

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
            Quartos quartos = new Quartos();
            QuartosDao dao = new QuartosDao();
            if (request.getParameter("acao").equals("alterar")) {
                quartos = dao.BuscaPorId(codigo);
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/cadastroQuartos.jsp");
                request.setAttribute("quartos", quartos);
                disp.forward(request, response);
            } else if (request.getParameter("acao").equals("excluir")) {
                dao.ApagaCliente(codigo);
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/cadastroQuartos.jsp");

                sessao.invalidate();
                out.println("<script>alert('Usuario excluido com sucesso!');</script>");
                out.println("<script>location.href='./quartos.jsp'</script>");
            }
        } catch (Exception e) {;
            System.out.println("Erro ao recuperar usuario!");

        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String menssagem = "";

        Quartos quartos = new Quartos();
        QuartosDao dao = new QuartosDao();
//        try {

            if (update.equals("alterar")) {

                quartos.setId(Integer.parseInt(request.getParameter("id")));
                quartos.setNumeroQuarto(Integer.parseInt(request.getParameter("numeroQuarto")));
                quartos.setTipoQuartos(request.getParameter("tipoQuartos"));
                quartos.setValorQuarto(Float.parseFloat(request.getParameter("valorQuarto")));

                dao.atualizar(quartos);
                menssagem = "alterado com Sucesso! ";
            } else {
                quartos.setNumeroQuarto(Integer.parseInt(request.getParameter("numeroQuarto")));
                quartos.setTipoQuartos(request.getParameter("tipoQuartos"));
                quartos.setValorQuarto(Float.parseFloat(request.getParameter("valorQuarto")));

                dao.salvar(quartos);

                menssagem = "Salvo com Sucesso! ";
                //menssagem = "Usuario cadstrado com sucesso";;
            }
//        } catch (Exception e) {
//            menssagem = "Erro ao gravar usuario!";
//        }
        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + menssagem + "');</script>");
        out.println("<script>location.href='./quartos.jsp'</script>");
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
