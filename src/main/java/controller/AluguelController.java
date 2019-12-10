package controller;

import dao.AluguelDao;
import dao.ClienteDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Aluguel;
import model.Cliente;
import model.Quartos;

@WebServlet(name = "AluguelController", urlPatterns = {"/AluguelController"})
public class AluguelController extends HttpServlet {

    String update = "update";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession sessao = request.getSession();
        update = "alterar";

        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Aluguel aluguel = new Aluguel();
            AluguelDao dao = new AluguelDao();
            if (request.getParameter("acao").equals("alterar")) {
                aluguel = dao.BuscaPorId(codigo);
                    
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/cadastroAluguel.jsp");
                request.setAttribute("aluguel", aluguel);
                disp.forward(request, response);
            } else if (request.getParameter("acao").equals("excluir")) {
                dao.ApagaCliente(codigo);
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/cadastroAluguel.jsp");

                sessao.invalidate();
                out.println("<script>alert('Cliente excluido com sucesso!');</script>");
                out.println("<script>location.href='./index.jsp'</script>");
            }
        } catch (Exception e) {;
            System.out.println("Erro ao recuperar usuario!");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menssagem = "";

        Aluguel aluguel = new Aluguel();
        Cliente cliente = new Cliente();
        Quartos quarto = new Quartos();
        AluguelDao dao = new AluguelDao();
        try {
            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

            if (update.equals("alterar")) {

                aluguel.setId(Integer.parseInt(request.getParameter("id")));
                aluguel.setDataEntrada(sd.parse(request.getParameter("dataEntrada")));
                aluguel.setDataEncerramento(sd.parse(request.getParameter("dataEncerramento")));
                aluguel.setValorReceber(Float.parseFloat(request.getParameter("valorReceber")));

                dao.atualizar(aluguel);
                menssagem = "alterado com Sucesso! ";

            } else {

                aluguel.setDataEntrada(sd.parse(request.getParameter("dataEntrada")));
                aluguel.setDataEncerramento(sd.parse(request.getParameter("dataEncerramento")));
                aluguel.setValorReceber(Float.parseFloat(request.getParameter("valorReceber")));
                aluguel.setStatus(true);
                String Icliente = request.getParameter("idCliente");
                cliente.setId(Integer.parseInt(Icliente));
                aluguel.setIdCliente(cliente);
//                cliente.setId(Integer.parseInt(Icliente));
//                aluguel.setIdCliente(cliente);
                String Iquarto = request.getParameter("idquarto");
                quarto.setId(Integer.parseInt(Iquarto));
                aluguel.setIdQuartos(quarto);

                dao.salvar(aluguel);

                menssagem = "Salvo com Sucesso! ";
                //menssagem = "Usuario cadstrado com sucesso";;
            }
        } catch (Exception e) {
            menssagem = "Erro ao gravar usuario!";
        }
        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + menssagem + "');</script>");
        out.println("<script>location.href='./aluguel.jsp'</script>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
