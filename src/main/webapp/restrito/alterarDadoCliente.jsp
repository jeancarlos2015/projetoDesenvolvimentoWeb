    

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> Alteração de cadastro </title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Lato:400,300,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/style.css">
        <link rel="icon" href="../img/icon.png">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>

    <body class="newsletter bg-grey ">

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
                        <a class="logo" href="index.jsp">INICIO</a>
                    </div>
                    <div class="navbar-collapse collapse" id="searchbar">

                        <ul class="nav navbar-nav navbar-right">
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
                    </div><!--/.nav-collapse -->
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

        <section class="container paracima_meio1">
            <h1 class="bg-titulo-white">Atualizar Dados Pessoais De ${titulo}</h1>
            <form method="post" action="../Controlador">
                <input class="bg-white radius campo" type="text"  name="nome" placeholder="Nome do Cliente" value="${valor_nome}" required>
                <input class="bg-white radius campo" type="text"  name="idade" placeholder="Idade do Cliente" value="${valor_idade}" required>
                <input class="bg-white radius campo" type="text"  name="cpf" placeholder="CPF do cliente" value="${valor_cpf}" required>
                <input class="bg-white radius campo" type="text"  name="email" placeholder="Email do cliente" value="${valor_email}" required>
                <input class="oculto" type="text"  name="matricula" value="${valor_matricula}">
                <input class="bg-white radius campo" type="password"  name="senha" placeholder="Senha do cliente" required>
                <input class="oculto" type="text" value="cliente"  name="tipo">
                <input class="oculto" type="text" value="atualizar"  name="operacao">
                <button type="submit" class="bg-white radius campo"> Alterar Dados </button>
            </form>
            <div class="alert centralizar">
                <h3 class="mensagem">${mensagem_alteracao}</h3>
            </div>
        </section>
        <!-- RODAPÉ -->
        <footer class="rodape container3 bg-gradient ">
            <div class="social-icons">
                <a href="https://pt-br.facebook.com/"><i class="fa fa-facebook"></i></a>
                <a href="https://twitter.com/login?lang=pt"><i class="fa fa-twitter"></i></a>
                <a href="https://accounts.google.com"><i class="fa fa-google"></i></a>
                <a href="https://www.instagram.com/?hl=pt-br"><i class="fa fa-instagram"></i></a>
            </div>
            <p class="copyright">
                Copyright © SISTEX 2016. Todos os direitos reservados - Desenvolvido Por Jean Carlos Penas.
        </footer>
    </body>
</body>
</html>

