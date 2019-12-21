
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/90798cd9b8.js" crossorigin="anonymous"></script>
        <link href="css/style1.css" rel="stylesheet">
        <%
//            HttpSession sessao = request.getSession();
//            if (sessao.getAttribute("usuario") == null) {
//                response.sendRedirect("login.jsp");
//            }
        %>
        <!--        <style>
                    body{
                    background-image: url("img/dormitorio.png  ");
                    }
                </style>-->
    </head>

    <title>Sidebar-nav</title>


    <body>

        <div class="sidebar">


            <ul class="sidebar-nav">

                <li>
                    <a id="navbar-toggle">Dormitório <i class="fa fa-bars menu-icon fa-2x" aria-hidden="true"></i></a>
                </li>
                <li>
                    <a href="index.jsp">Home <i class="fa fa-home menu-icon fa-2x" aria-hidden="true"></i></a>
                </li>
                <li>
                    <a href="cliente.jsp">Cliente<i class="fa fa-address-book menu-icon fa-2x" aria-hidden="true"></i></a>
                </li>
                <li>
                    <a href="quartos.jsp">Quartos<i class="fa fa-bed menu-icon fa-2x" aria-hidden="true"></i></a>
                </li>
                <li>
                    <a href="usuario.jsp">Usuário<i class="fa fa-user menu-icon fa-2x" aria-hidden="true"></i>
                    </a>
                </li>
                <li>
                    <a href="aluguel.jsp">Aluguel<i class="fas fa-door-open menu-icon fa-2x" aria-hidden="true"></i>
                    </a>
                </li>
                <li>
                    <a href="finalizarAluguel.jsp">Finalizar Aluguel<i class="fas fa-door-closed menu-icon fa-2x" aria-hidden="true"></i>
                    </a>
                </li>


            </ul>

        </div>
        <script>
            var state = "expanded";
            //Check if navbar is expanded or minimized and handle 


            $('#navbar-toggle').click(function () {
                if (state == "expanded") {
                    $('.sidebar').css('margin-left', '-180px');
                    state = "minimized";
                } else {
                    if (state == "minimized") {
                        $('.sidebar').css('margin-left', '0px');
                        state = "expanded";
                    }
                }
            })
        </script>
    </body>
</html>
