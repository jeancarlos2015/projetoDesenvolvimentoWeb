    

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> Conta de ${usuario} </title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Lato:400,300,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/style.css">
        <link rel="icon" href="../img/icon.png">
        <script type="text/javascript" src="../js/funcoes.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

    </head>

    <body class="newsletter  bg-grey ">

        <!-- CABEÇALHO -->
        <header class="container3 paracima_acesso">
            <div class="navbar navbar-inverse navbar-fixed-top">
                <div class="container3">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="logo" href="../index.jsp">INICIO</a>
                    </div>
                    <div class="navbar-collapse collapse" id="searchbar">
                        <ul class="nav navbar-nav navbar-right ">
                            <li><a>${usuario}</a></li>
                            <li id="userPage"><a href="../cadastroClientes.jsp"><i class="icon-user"></i>Cadastro</a></li>
                            <li><a href="../acesso.jsp" data-prevent="">Acesso</a></li>
                            <li>
                                <a>
                                    <form class="pequeno" method="post" action="../Controlador">
                                        <input type="text" class="oculto" name="operacao" value="fechasessao">
                                        <input type="text" class="oculto" name="tipo" value="cliente">
                                        <button style="background-color: transparent" type="submit"><p>Logout<p></button>
                                    </form>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="nav-side-menu container2">
                <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>

                <div class="menu-list">

                    <ul id="menu-content" class="menu-content collapse out">

                        <li data-toggle="collapse" data-target="#service" class="collapsed">
                            <a href="#"><i class="fa fa-globe fa-lg"></i>Pedidos<span class="arrow"></span></a>
                        </li>  
                        <ul class="sub-menu collapse" id="service">
                            <a href="controlePedidos.jsp"> <li>Monitoramento de pedidos</li></a>
                        </ul>
                        <li data-toggle="collapse" data-target="#service2" class="collapsed">
                            <a href="#"><i class="glyphicon glyphicon-cog"></i>Configuração<span class="arrow"></span></a>
                        </li>  
                        <ul class="sub-menu collapse" id="service2">
                            <a href="alterarDadoCliente.jsp"> <li>Alterar dados pessoais</li></a>
                        </ul>
                        
                    </ul>
                </div>
            </div>
        </header>

        <section class="container">
            <h1 class="bg-titulo-white">BEM VINDO ${titulo}</h1>
     
        </section>
        
    </body>
</body>
</html>

