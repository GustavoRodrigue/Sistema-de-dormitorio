

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Usuario</title>
        <meta name="viewport" content="width=device-width, initial-scale=1 " >
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script src="js/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
    </head>
    <body>
         <c:import url="index.jsp" />
        <div class="container" >

            <div class="card border-dark">
                <div class="card-header" >Cliente</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <form action="UsuarioController" role="form" method="POST">
                                <input type="hidden" name="id"  value="${usuario.id}" >

                                <div class="form-group">
                                    <label>Nome</label>
                                    <input type="text" class="form-control" placeholder="Digite seu Nome" name="nome" value="${usuario.nome}">
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="text" class="form-control" placeholder="Digite seu Email" name="email" value="${usuario.email}">
                                </div>
                                <div class="form-group">
                                    <label>Cpf</label>
                                    <input type="text" class="form-control" placeholder="Digite seu CPF" name="cpf" value="${usuario.cpf}">
                                </div>
                                <div class=form-group">
                                    <label>Senha</label>
                                    <input type="password" class="form-control" name="senha" value="${usuario.senha}">
                                </div><br>

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
