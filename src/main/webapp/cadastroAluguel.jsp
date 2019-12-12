<%-- 
    Document   : cadastroAluguel
    Created on : 03/12/2019, 21:02:52
    Author     : gustavo
--%>

<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Aluguel</title>
        <meta name="viewport" content="width=device-width, initial-scale=1 " >
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script src="js/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <link href="css/style1.css" rel="stylesheet">
    </head>
    <body>
         <c:import url="index.jsp" />
        <div class="container">

            <div class="card border-dark">
                <div class="card-header" >Cliente</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <form action="AluguelController" role="form" method="POST">
                                <input type="hidden" name="id"  value="${aluguel.id}" >

                                <div class="form-group">
                                    <label>Data de Entrada</label>
                                    <input id="inputDate" type="date"  class="form-control" name="dataEntrada" value="${aluguel.dataEntrada}" >
                                </div>
                                <div class="form-group flutuar">
                                    <label>Data de Saida</label>                                   
                                    <input type="text" class="form-control flutuar" 
                                           name="dataEncerramento" value="${aluguel.dataEncerramento}" >
                                </div>
                              
                                <div class="form-group">
                                    <label>Valor A receber</label><br>
                                    <input type="text" class="form-control" name="valorReceber" value="${aluguel.valor()}">
                                </div>

                                <div class="form-group">
                                    <label>Cliente</label>
                                    <select name="idCliente" class="custom-select">
                                        <option selected>Selecione</option>
                                        <jsp:useBean id="c" class="dao.ClienteDao"></jsp:useBean>
                                        <c:forEach var="cliente" items="${c.lista}">

                                            <option value="${cliente.id}">${cliente.nome}</option>

                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Tipo de Quatro</label>
                                    <select name="idquarto" class="custom-select">

                                        <option selected>Selecione</option>
                                        <jsp:useBean id="q" class="dao.QuartosDao"></jsp:useBean>
                                        <c:forEach var="quarto" items="${q.lista}">

                                            <option  value="${quarto.id}">${quarto.tipoQuartos}</option>

                                        </c:forEach>


                                    </select>
                                </div>

                                <button type="submit"  class="btn btn-info btn-lg btn-block"><span class="glyphicon glyphicon-plus"></span>Salvar</button>
                            </form> 
                        </div>
                        <div class="col-sm-12"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
