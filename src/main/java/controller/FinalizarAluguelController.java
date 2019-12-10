/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AluguelDao;
import dao.FinalizarAluguelDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluguel;
import model.Cliente;
import model.Finalizaraluguel;
import model.Quartos;

/**
 *
 * @author gustavo
 */
@WebServlet(name = "FinalizarAluguelController", urlPatterns = {"/FinalizarAluguelController"})
public class FinalizarAluguelController extends HttpServlet {

    String update = "update";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menssagem = "";
        Aluguel aluguel = new Aluguel();
        Cliente cliente = new Cliente();
        Quartos quarto = new Quartos();
        Finalizaraluguel finalizarAliguel = new Finalizaraluguel();
        FinalizarAluguelDao  daoF = new FinalizarAluguelDao();
        AluguelDao aluguelDao = new AluguelDao();
//        try {
            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

            if (update.equals("alterar")) {

               
            } else {

                //finalizarAliguel.setId(Integer.parseInt(request.getParameter("id")));
                finalizarAliguel.setValorReceber(Float.parseFloat(request.getParameter("valorReceber")));
                finalizarAliguel.setQuantidadeDia(Integer.parseInt(request.getParameter("quantidadeDias")));
                aluguel.setStatus(false);
                String IAluguel = request.getParameter("idAluguel");
                aluguel.setId(Integer.parseInt(IAluguel));
                finalizarAliguel.setIdAluguel(aluguel);
                
                String Icliente = request.getParameter("idCliente");
                cliente.setNome(Icliente);
                finalizarAliguel.setIdCliente(cliente);
//                cliente.setId(Integer.parseInt(Icliente));
//                aluguel.setIdCliente(cliente);
                
                daoF.salvar(finalizarAliguel);
                aluguelDao.salvar(aluguel);

                menssagem = "Salvo com Sucesso! ";
                //menssagem = "Usuario cadstrado com sucesso";;
            }
//        } catch (Exception e) {;
//            menssagem = "Erro ao gravar usuario!";
//        };
        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + menssagem + "');</script>");
        out.println("<script>location.href='./finalizarAluguel.jsp'</script>");
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
