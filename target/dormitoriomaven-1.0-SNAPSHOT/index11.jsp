<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tela Inicial</title>
        <meta name="viewport" content="width=device-width, initial-scale=1 " >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/90798cd9b8.js" crossorigin="anonymous"></script>
        <link href="css/style.css" rel="stylesheet">
        <script language="JavaScript" src="js/scripts.js" ></script>
        <script>
            $(document).ready(function () {
                $('.datepicker').datepicker({
                    format: 'dd/mm/yyyy',
                    language: 'pt-BR'
                });
            });
        </script>
    </head>
    <body>
        <div class="container-fluid">

            <header class="row navbar navbar-expand-lg navbar-light ">

                <a href="#" class="btn" id="menu-toggle"></a>
            </header>
            <div id="wrapper">

                <div class="row content">
                    <!-- Sidebar -->
                    <div id="sidebar-wrapper">


                        <div class="col-sm-3 sidenav">
                            <nav>
                                <ul class="nav nav-pills nav-stacked ">
                                    <li><a href="#section1"> <i class="fas fa-home"></i> Home</a></li>
                                    <li><a href="#section2"><i class="fas fa-user"></i> Usuario</a></li>
                                    <li><a href="#section3"><i class="fas fa-address-book"></i> Cliente</a></li>
                                    <li><a href="#section3"><i class="fas fa-bed"></i> Quartos</a></li>
                                    <li><a href="#section3">Aluguel</a></li>
                                </ul><br>
                            </nav>

                        </div>
                    </div>
                    <div class="col-sm-9">
                        <div> 
                            <input type="text" name="data" class="datepicker" />

                            <div class="form-group">
                                <label >Begin voorverkoop periode</label>
                                <input type="date" name="bday" max="3000-12-31" 
                                       min="1000-01-01" class="form-control">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
