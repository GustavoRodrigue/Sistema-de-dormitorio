

<%@page import="dao.ClienteDao"%>
<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            HttpSession sessao = request.getSession();
            if(sessao.getAttribute("dados") != null){
                String[] dados = (String[])sessao.getAttribute("dados");
                if(!(dados[3]=="true"?true:false)){
                    Cliente cliente = new Cliente();
                    ClienteDao clienteDao = new ClienteDao();
                    cliente = clienteDao.BuscaPorId(Integer.parseInt(dados[0]));
                
        
        %>
        
        <a href="ClienteController1?alterar=<%=dados[0]%>" class="btn btn-success" role="button">Update</a>
        <a href="" class="btn btn-danger" role="button"><span class="glyphicon glyphicon-remove"></span>Delete</a>
        <%
            }
            }
        %>
    </body>
</html>
