

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Cliente</title>
        <meta name="viewport" content="width=device-width, initial-scale=1 " >
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <script src="js/jquery.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
    </head>
    <body>
        <div class="container" style="margin-top: 30px;">

            <div class="card border-primary">
                <div class="card-header bg-primary" >Cliente</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <form action="ClienteController1" role="form" method="POST">
                                <input type="hidden" name="id"  value="${cliente.id}" >
                                
                                <div class="form-group">
                                    <label>Nome</label>
                                    <input type="text" class="form-control" name="nome" value="${cliente.nome}">
                                </div>
                                <div class="form-group">
                                    <label>Cpf</label>
                                    <input type="text" class="form-control" name="cpf" value="${cliente.cpf}">
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
