
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
        <meta name="viewport" content="width=device-width, initial-scale=1 " >
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script src="https://kit.fontawesome.com/90798cd9b8.js" crossorigin="anonymous"></script>
        <script src="js/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <script>
            function confirmarExclusao(codigo) {
                if (confirm('Deseja realmente excluir?')) {
                    location.href = "UsuarioController?acao=excluir&codigo="+ codigo;
                }
            }
        </script>
    </head>
    <body>
        <c:import url="index.jsp" />
         <div class="container" >

            <div class="card border-dark">
                <div class="card-header" >Cliente</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <a href="cadastroUsuario.jsp" class=""><button  type="submit" class="btn btn-dark btn-lg btn-block" style="margin-bottom: 30px;"><i class="fas fa-plus"></i> Novo</button></a>

                            <table class="table table-striped">
                                <tr class="thead-dark">
                                    <th>id</th>
                                    <th>Nome</th>
                                    <th>Email</th>
                                    <th>Cpf</th>
                                    <th>Opções</th>
                                </tr>
                                <jsp:useBean id="u" class="dao.UsuarioDao"></jsp:useBean>
                                <c:forEach var="usuario" items="${u.lista}">
                                    <tr>
                                        <td>${usuario.id}</td>
                                        <td>${usuario.nome}</td>
                                        <td>${usuario.email}</td>
                                        <td>${usuario.cpf}</td>
                                        <td>
                                            <a href="UsuarioController?acao=alterar&codigo=${usuario.id}" class="btn btn-success" role="button"><i class="fas fa-edit"></i> Alterar</a>
                                            <a href="javascript:confirmarExclusao(${usuario.id});" class="btn btn-danger" role="button"><i class="fas fa-trash-alt"></i> Excluir</a>
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
