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
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="css/style1.css" rel="stylesheet">
    </head>
    <body>
        <section id="login">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="form-wrap">
                            <h1>Dormitório</h1>
                            <form role="form" action="SegurancaController" method="post" id="login-form" autocomplete="off">
                                <div class="form-group">
                                    <label id="label" for="email" >Email</label>
                                    <input type="email" name="email" id="email" class="form-control" placeholder="Digite seu Email">
                                </div>
                                <div class="form-group">
                                    <label id="label" for="key" >Senha</label>
                                    <input type="password" name="senha" id="key" class="form-control" placeholder="Digite sua senha">
                                </div>
                                <div class="checkbox">
                                    <span class="character-checkbox" onclick="showPassword()"></span>
                                    <span class="label">Salvar senha</span>
                                </div>
                                <input type="submit" id="btn-login" class="btn  btn-lg btn-block btn-primary" value="Entrar">
                            </form>
                            
                        </div>
                    </div> <!-- /.col-xs-12 -->
                </div> <!-- /.row -->
            </div> <!-- /.container -->
        </section>

        <div class="modal fade forget-modal" tabindex="-1" role="dialog" aria-labelledby="myForgetModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">×</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title">Recovery password</h4>
                    </div>
                    <div class="modal-body">
                        <p>Type your email account</p>
                        <input type="email" name="recovery-email" id="recovery-email" class="form-control" autocomplete="off">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                        <button type="button" class="btn btn-custom">Recovery</button>
                    </div>
                </div> <!-- /.modal-content -->
            </div> <!-- /.modal-dialog -->
        </div> <!-- /.modal -->

        <footer id="footer">
            <div class="container">
                <div class="row">
                    
                </div>
            </div>
        </footer>
        <script>
            function showPassword() {

                var key_attr = $('#key').attr('type');

                if (key_attr != 'text') {

                    $('.checkbox').addClass('show');
                    $('#key').attr('type', 'text');

                } else {

                    $('.checkbox').removeClass('show');
                    $('#key').attr('type', 'password');

                }

            }
        </script>
    </body>
</html>
