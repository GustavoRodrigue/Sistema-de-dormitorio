<%-- 
    Document   : quartos
    Created on : 30/11/2019, 21:39:09
    Author     : gustavo
--%>

<%@page import="model.Quartos"%>
<%@page import="dao.QuartosDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quartos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1 " >
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script src="js/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <script>
            function confirmarExclusao(codigo) {
                if (confirm('Deseja realmente excluir?')) {
                    location.href = "QuartosController?acao=excluir&codigo="+ codigo;
                }
            }
        </script>
    </head>
    <body>
        <div class="container" style="margin-top: 30px;">

            <div class="card border-primary">
                <div class="card-header bg-primary" >Quartos</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <a href="cadastroQuartos.jsp"><button  type="submit" class="btn btn-info btn-lg btn-block" style="margin-bottom: 30px;">Novo</button></a>

                            <table class="table table-striped">
                                <tr class="thead-dark">
                                    <th>Nº Quarto</th>
                                    <th>Tipo de Quarto</th>
                                    <th>Valor do Quarto</th>
                                    <th>Opções</th>
                                </tr>
                                <jsp:useBean id="q" class="dao.QuartosDao"></jsp:useBean>
                                <c:forEach var="quarto" items="${q.lista}">
                                    <tr>
                                        <td>${quarto.numeroQuarto}</td>
                                        <td>${quarto.tipoQuartos}</td>
                                        <td>${quarto.valorQuarto}</td>

                                        <td>
                                            <a href="QuartosController?acao=alterar&codigo=${quarto.id}" class="btn btn-success" role="button">Alterar</a>
                                            <a href="javascript:confirmarExclusao(${quarto.id});" class="btn btn-danger" role="button"><span class="glyphicon glyphicon-remove"></span>Excluir</a>
                                        </td>
                                    </tr>  
                                </c:forEach>
                            </table>
                        </div>
                        <div class="col-sm-12"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
