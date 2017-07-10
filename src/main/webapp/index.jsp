<%-- 
    Document   : index
    Created on : 05/07/2017, 12:08:32
    Author     : jean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> Inicio </title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Lato:400,300,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="icon" href="img/icon.png">
        <script type="text/javascript" src="js/funcoes.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>

    <body>

        <!-- CABEÇALHO -->
        <header class="container3 ">
            <!--            <a href="index.jsp"><h1 class="logo"> SISTEC-Especializada em Soluções Digitais </h1></a>-->
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
                            <li id="userPage">
                                <a href="cadastroClientes.jsp"><i class="icon-user"></i>Cadastro</a>
                            </li>
                            <li><a href="acesso.jsp" data-prevent="">Acesso</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="index.jsp" title="pesquisa">Apagar</a></li>
                        </ul>
                        <form class="navbar-form" method="post" action="Controlador">
                            <div class="form-group" style="display:inline;">
                                <div class="input-group" style="display:table;">
                                    <span class="input-group-addon" style="width:1%;"><span class="glyphicon glyphicon-search"></span></span>
                                    <input class="form-control" name="nome" placeholder="Pesquise Aqui" autocomplete="off" autofocus="autofocus" type="text">
                                    <input class="oculto" type="text" name="tipo" value="produto">
                                    <input class="oculto" type="text" name="operacao" value="listar">
                                    <button class="oculto" type="submit"></button>
                                </div>
                            </div>
                        </form>

                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </header>
        <form method="post" class="subir" action="Controlador">
            <div class="figure1 paracima_meio">
                <div class="figure">
                    ${figuras_produtos};
                </div>    
            </div>
            ${botao_pedido}
        </form>
            <h3>${mensagem_pesquisa_produtos}</h3> 


        <!-- RODAPÉ -->
        <footer class="rodape container3 bg-gradient abaixo">
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

