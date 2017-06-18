<%-- 
    Document   : cadastroClientes
    Created on : 12/06/2017, 16:51:56
    Author     : estagiario33601
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> CONTROLE DE FUNCIONÁRIOS</title>

        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Lato:400,300,700' rel='stylesheet' type='text/css'>
        <link rel="icon" href="img/icon.png">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="js/funcoes.js"></script>
    </head>
    <body>
        <!-- Cabeçalho da pagina -->
        <header class="cabecalho container">
            <a href="index.jsp"><h1 class="logo"> SISclientes</h1></a>
            <button class="btn-menu bg-gradient" type="BUTTON" onclick="funcao()"><i class="fa fa-bars fa-lg"></i></button>
            <nav class="menu" id="close1">
                <a class="btn-close"><i class="fa fa-times"></i></a>
                <ul>
                    <li class="home"><a href="index.jsp">Home</a></li>
                    <li class="home"><a href="cadastroClientes.jsp">Cadastro De Cliente</a></li>
                    <li class="home"><a href="controleFuncionarios.jsp">Controle De Funcionários</a></li>
                    <li class="home"><a href="acesso.jsp">Acesso</a></li>
                </ul>
            </nav>
        </header>
        <!-- Formulario de cadastro  -->
        <section class="newsletter container bg-grey">
            <h1 class="bg-titulo">MENU FUNCIONÁRIOS</h1>
            <form method="post" action="Controlador">
                <input class="oculto" type="text" value="cliente"  name="tipo">
                <input class="oculto" type="text" value="cadastro"  name="operacao">
                <button type="submit" class="bg-white radius campo"> Controle de Clientes </button>
            </form>
            <form method="post" action="Controlador">
                <input class="oculto" type="text" value="cliente"  name="tipo">
                <input class="oculto" type="text" value="cadastro"  name="operacao">
                <button type="submit" class="bg-white radius campo"> Controle De Funcionário </button>
            </form>
            
            <form method="post" action="Controlador">
                <input class="oculto" type="text" value="cliente"  name="tipo">
                <input class="oculto" type="text" value="cadastro"  name="operacao">
                <button type="submit" class="bg-white radius campo"> Controle De Produtos </button>
            </form>
            
        </section>

        <!-- Rodapé da página  -->
        <footer class="rodape container bg-gradient">
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
