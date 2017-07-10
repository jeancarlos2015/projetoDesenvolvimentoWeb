    

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> Cadastro De Funcionários</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Lato:400,300,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/style.css">
        <link rel="icon" href="../img/icon.png">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

    </head>

    <body class="newsletter bg-grey">

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
                            <li id="userPage"><a href="cadastroClientes.jsp"><i></i>Cadastro</a></li>
                            <li><a href="../acesso.jsp" data-prevent="">Acesso</a></li>
                            <li>
                                <a>
                                    <form class="pequeno" method="post" action="../Controlador">
                                        <input type="text" class="oculto" name="operacao" value="fechasessao">
                                        <input type="text" class="oculto" name="tipo" value="funcionario">
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
                            <a href="#"><i class="fa fa-globe fa-lg"></i>Produtos<span class="arrow"></span></a>
                        </li>  
                        <ul class="sub-menu collapse" id="service">
                            <a href="cadastroProdutos.jsp"> <li>Cadastro de Produtos</li></a>
                        </ul>
                        <li data-toggle="collapse" data-target="#service2" class="collapsed">
                            <a href="#"><i class="fa fa-globe fa-lg"></i>Funcionários<span class="arrow"></span></a>
                        </li>  
                        <ul class="sub-menu collapse" id="service2">
                            <a href="cadastroFuncionarios.jsp"> <li>Cadastro de Funcionários</li></a>
                        </ul>
                        <li data-toggle="collapse" data-target="#service1" class="collapsed">
                            <a href="#"><i class="fa fa-globe fa-lg"></i>Fornecedor<span class="arrow"></span></a>
                        </li>  
                        <ul class="sub-menu collapse" id="service1">
                            <a href="cadastroFornecedores.jsp"> <li>Cadastro de Fornecedores</li></a>
                        </ul>
                        <li data-toggle="collapse" data-target="#new" class="collapsed">
                            <a href="#"><i class="fa fa-car fa-lg"></i> Entregas <span class="arrow"></span></a>
                        </li>
                        
                        <ul class="sub-menu collapse" id="new">
                            <a href="controlePedidos.jsp"> <li>Controle de pedidos</li></a>
                        </ul>


                    </ul>
                </div>
            </div>
        </header>

        <section class=" container ">
            <h1 class="bg-titulo-white">CADASTRO DE FUNCIONÁRIOS</h1>
            <form method="post" action="../Controlador">
                <input class="bg-white radius campo" type="text"  name="nome" placeholder="Nome do funcionário" required>
                <input class="bg-white radius campo" type="text"  name="matricula" placeholder="Digite uma matricula" required>
                <input class="bg-white radius campo" type="text"  name="rg" placeholder="rg do funcionários" required>
                <input class="bg-white radius campo" type="password"  name="senha" placeholder="Senha do funcionário" required>

                <input class="oculto" type="text" value="funcionario"  name="tipo">
                <input class="oculto" type="text" value="cadastro"  name="operacao">

                <button type="submit" class="bg-white radius campo"> Cadastrar Fornecedor</button>
            </form>

            <div class="alert centralizar">
                <h3 class="mensagem">${mensagem_funcionario}</h3>
            </div>
        </section>
        <!-- RODAPÉ -->
        <footer class="rodape container3 bg-gradient paracima_meio">
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

