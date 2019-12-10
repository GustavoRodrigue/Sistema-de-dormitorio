

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tela Inicial</title>
        <meta name="viewport" content="width=device-width, initial-scale=1 " >
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
         <script src="https://kit.fontawesome.com/90798cd9b8.js" crossorigin="anonymous"></script>
        <script src="js/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <script language="JavaScript" src="js/scripts.js" ></script>
        <script>
            function confirmarExclusao(codigo) {
                if (confirm('Deseja realmente excluir?')) {
                    location.href = "AluguelController?acao=excluir&codigo=" + codigo;
                }
            }
        </script>
    </head>
    <body>
        <c:import url="index.jsp" />
        <div class="container" style="margin-top: 3px;">

            <div class="card border-primary">
                <div class="card-header bg-primary" >Aluguel</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <a href="cadastroAluguel.jsp" class=""><button  type="submit" class="btn btn-info btn-lg btn-block" style="margin-bottom: 30px;"><i class="fas fa-plus"></i> Novo</button></a>

                            <table class="table table-striped">
                                <tr class="thead-dark">
                                    <th>id</th>
                                    <th>Data Entrada</th>
                                    <th>Data Saida</th>
                                    <th>valor Receber</th>
                                    <th>Cliente</th>
                                    <th>Tipo de Quarto</th>
                                    <th>Opçoes</th>
                                    
                                </tr>
                                <jsp:useBean id="a" class="dao.AluguelDao"></jsp:useBean>
                                <c:forEach var="aluguel" items="${a.lista}">
                                    <tr>
                                        <td>${aluguel.id}</td>
                                        <td>${aluguel.dataEntrada}</td>
                                        <td>${aluguel.dataEncerramento}</td>
                                        <td>${aluguel.valorReceber}</td>
                                        <td>${aluguel.idCliente}</td>
                                        <td>${aluguel.idQuartos}</td>
                                        <td>
                                            
                                            <a href="AluguelController?acao=alterar&codigo=${aluguel.id}" class="btn btn-success" role="button"><i class="fas fa-edit"></i> Alterar</a>
                                            <a href="javascript:confirmarExclusao(${aluguel.id});" class="btn btn-danger" role="button"><i class="fas fa-trash-alt"></i> Excluir</a>
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
