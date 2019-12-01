


<%@page import="model.Cliente"%>
<%@page import="dao.ClienteDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
        <meta name="viewport" content="width=device-width, initial-scale=1 " >
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script src="js/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <script>
            function confirmarExclusao(codigo) {
                if (confirm('Deseja realmente excluir?')) {
                    location.href = "ClienteController1?acao=excluir&codigo="+ codigo;
                }
            }
        </script>
    </head>
    <body>
        <div class="container" style="margin-top: 30px;">

            <div class="card border-primary">
                <div class="card-header bg-primary" >Cliente</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <a href="CadastroCliente.jsp"><button  type="submit" class="btn btn-info btn-block" style="margin-bottom: 30px;">Novo</button></a>

                            <table class="table table-striped">
                                <tr class="thead-dark">
                                    <th>id</th>
                                    <th>Nome</th>
                                    <th>Cpf</th>
                                    <th>Opções</th>
                                </tr>
                                <jsp:useBean id="c" class="dao.ClienteDao"></jsp:useBean>
                                <c:forEach var="cliente" items="${c.lista}">
                                    <tr>
                                        <td>${cliente.id}</td>
                                        <td>${cliente.nome}</td>
                                        <td>${cliente.cpf}</td>
                                        <td>
                                            <a href="ClienteController1?acao=alterar&codigo=${cliente.id}" class="btn btn-success" role="button">Alterar</a>
                                            <a href="javascript:confirmarExclusao(${cliente.id});" class="btn btn-danger" role="button"><span class="glyphicon glyphicon-remove"></span>Excluir</a>
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
