
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1 " >
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script src="js/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <script language="JavaScript" src="js/scripts.js" ></script>
    </head>
    <body>
        <c:import url="index.jsp" />
        <div class="container" style="margin-top: 3px;">

            <div class="card border-primary">
                <div class="card-header bg-primary" >Aluguel</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-12">


                            <table class="table table-striped">
                                <tr class="thead-dark">
                                    <th>id</th>
                                    <th>Cliente</th>
                                    <th>Valor Receber</th>
                                    <th>Quantidade de Dias</th>

                                    <th>Opçoes</th>

                                </tr>
                                <jsp:useBean id="a" class="dao.AluguelDao"></jsp:useBean>
                                <c:forEach var="aluguel" items="${a.lista}">
                                    <c:if test="${aluguel.status == true}">
                                        <tr>
                                            <td>${aluguel.id}</td>
                                            <td>${aluguel.idCliente}</td>
                                            <td>${aluguel.valorReceber}</td>
                                            <td>${aluguel.verificaQtdDias()}</td>

                                        <form action="AluguelController" role="form" method="POST">
                                            <input type="hidden" name="id"  value="${aluguel.id}" >

                                            <td>
                                                <button type="submit"  class="btn btn-info btn-block">
                                                    Finalizar Aluguel</button>
                                            </td>
                                        </form> 

                                        </tr>  
                                    </c:if>
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
