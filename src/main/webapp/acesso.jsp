<%-- 
    Document   : cadstroFornecedores
    Created on : 03/07/2017, 21:03:16
    Author     : jean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> Acesso </title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Lato:400,300,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="icon" href="img/icon.png">
        <script type="text/javascript" src="js/funcoes.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
    </head>
    <body class="newsletter bg-grey ">
        <!-- Cabeçalho da pagina -->
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
                            <li id="userPage">
                                <a href="cadastroClientes.jsp"><i class="icon-user"></i>Cadastro</a>
                            </li>
                            <li><a href="acesso.jsp" data-prevent="">Acesso</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </header>
        <!-- Formulario de cadastro  -->
        <section class="container3 paracima_meio1">
            <h1 class="bg-titulo-white">Acesso</h1>
            <form method="post" action="Controlador" class="">
                <input class="bg-white radius campo " type="text"  name="cpf" placeholder="CPF do cliente ou Matricula do funcionario" required>
                <input class="bg-white radius campo " type="password"  name="senha" placeholder="Senha do cliente" required>
                <input class="oculto" type="text" value="autenticacao"  name="operacao">
                <select class="bg-white radius campo_largo1 " name="tipo">
                    <option value="1" selected >Tipo de acesso</option>
                    <option value="funcionario">Funcionario</option>
                    <option value="cliente">Cliente</option>
                </select>
                <button type="submit" class="bg-white radius campo "> Entrar </button>
            </form>
            <div class="alert centralizar">
                <h3 class="mensagem">${mensagem}</h3>
            </div>
        </section>

        <!-- Rodapé da página  -->
        <footer class="rodape container3 bg-gradient ">
            <div class="social-icons">
                <a href="https://pt-br.facebook.com/"><i class="fa fa-facebook"></i></a>
                <a href="https://twitter.com/login?lang=pt"><i class="fa fa-twitter"></i></a>
                <a href="https://accounts.google.com"><i class="fa fa-google"></i></a>
                <a href="https://www.instagram.com/?hl=pt-br"><i class="fa fa-instagram"></i></a>
            </div>
            <p class="copyright">
                Copyright © SisPedidos 2016. Todos os direitos reservados - Desenvolvido Por Jean Carlos Penas.
        </footer>
    </body>
</html>
