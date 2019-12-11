<%-- 
    Document   : login
    Created on : 11/12/2019, 21:50:39
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">

                <div class="col-sm-6 col-md-5 hidden-xs hidden-sm">   
                    <img src="https://raw.githubusercontent.com/rexxars/react-hexagon/master/logo/react-hexagon.png" alt="" class="center-block img-responsive" />
                </div>

                <div class="col-md-1 hidden-xs hidden-sm">   
                    <div class="border-login"></div>
                </div>


                <div class="col-sm-12 col-xs-12 col-md-4">            
                    <div class="space-top">


                        <h3 class="text-center">/pandora</h3>

                        <form class="form-signin" class="form-horizontal">

                            <label class=""> Usuário </label>

                            <input type="text" class="form-control" placeholder="" required autofocus>

                            <label class=""> Senha </label>
                            <input type="password" class="form-control" placeholder="" required>

                            <button class="btn btn-lg btn-primary btn-block" type="submit">
                                Entrar
                            </button>   




                        </form>
                    </div>

                    <p class="text-center"> Ainda não tenho conta!  <a href="#"  data-toggle="modal" data-target="#myModal"> Criar agora mesmo!</a></p>


                    <!-- Modal -->
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="myModalLabel">Pandora - Criar conta de acesso!</h4>
                                </div>
                                <div class="modal-body">
                                    <form>

                                        <div class="form-group">
                                            <label class="label-register">Nome</label>

                                            <input type="text" class="form-control" id="email" placeholder="Insira seu nome completo">
                                        </div>

                                        <div class="form-group">
                                            <label class="label-register">Usuário</label>

                                            <input type="text" class="form-control" id="email" placeholder="Insira nome de usuário">
                                        </div>


                                        <div class="form-group">
                                            <label class="label-register" >E-mail</label>
                                            <input type="email" class="form-control" id="email" placeholder="Insira seu e-mail!">
                                        </div>
                                        <div class="form-group">
                                            <label class="label-register">Informe a senha</label>
                                            <input type="password" class="form-control" id="senha1" placeholder="*****">
                                        </div>

                                        <div class="form-group">
                                            <label class="label-register">Repita a senha</label>
                                            <input type="password" class="form-control" id="senha2" placeholder="******">
                                        </div>


                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <div class="pull-left">
                                        <button type="button" class="btn btn-primary">Salvar</button>

                                        <button type="button" class="btn btn-default" data-dismiss="modal">Sair</button>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
