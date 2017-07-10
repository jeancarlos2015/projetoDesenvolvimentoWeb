    

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> Cadastro De Produtos </title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Lato:400,300,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/style.css">
        <link rel="icon" href="../img/icon.png">
        <script type="text/javascript" src="js/funcoes.js"></script>
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
                            <li id="userPage"><a href="cadastroClientes.jsp"><i></i>Cadastro</a></li>
                            <li><a href="../acesso.jsp" data-prevent="">Acesso</a></li>
                            <li>
                                <a>
                                    <form class="pequeno" method="post" action="../Controlador">
                                        <input type="text" class="oculto" name="operacao" value="fechasessao">
                                        <input type="text" class="oculto" name="tipo" value="produto">
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
                            <li>Monitoramento de entregas</li>
                        </ul>
                    </ul>
                </div>
            </div>
        </header>

        <section class="container">
            <h1 class="bg-titulo-white">CADASTRO DE PRODUTOS</h1>
            <form method="post" action="../Controlador">
                <input class="bg-white radius campo" type="text"  name="nome" placeholder="Nome do produto" required>
                <input class="bg-white radius campo" type="text"  name="descricao" placeholder="Descrição do produto" required>
                <input class="bg-white radius campo" type="text"  name="preco" placeholder="preço" required>
                <input class="bg-white radius campo" type="text"  name="marca" placeholder="Marca do produto" required>
                <input class="bg-white radius campo" type="text"  name="quantidade" placeholder="Quantidade" required>
                <select class="bg-white radius campo_largo1" name="cnpj">
                    <option value="1" selected >Fornecedor</option>
                    <option value="1231231">Sadia</option>
                    <option value="1231232">Rio doce</option>
                    <option value="1231233">FriBoi</option>
                    <option value="1231234">Sepé</option>
                    <option value="1231235">Torresmo Krocs</option>
                </select>

<!--                <select class="bg-white radius campo_largo1" name="tipo_produto">
                    <option value="TIPO DO PRODUTO" selected >Tipo De Prato</option>
                    <option value="prato">Prato</option>
                    <option value="tropeiro">Tropeiro</option>
                    <option value="regrigerante">Refrigerante</option>
                    <option value="salada">Salada</option>
                    <option value="espaguete">Espaguete</option>
                </select>-->
                <select class="bg-white radius campo_largo1" name="matricula">
                    <option value="1234" selected >Funcionário</option>
                    <option value="123123" >Sistema</option>
                    <option value="123124">Maria Das Graças</option>
                    <option value="123125">Marcio De La Vega</option>
                    <option value="123126">Mário Silva</option>
                    <option value="123127">Rose Oliveira</option>
                </select>
                <input class="oculto" value="produto" name="tipo">
                <input class="oculto" value="cadastro" name="operacao">
                <button type="submit" class="bg-white radius campo"> Cadastrar Produto</button>
            </form>
            <div class="alert centralizar">
                <h3 class="mensagem">${mensagem_produto}</h3>
            </div>
        </section>
        <!-- RODAPÉ -->
        <footer class="rodape container3 bg-gradient">
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

