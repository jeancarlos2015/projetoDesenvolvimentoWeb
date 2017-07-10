<%-- 
    Document   : telaConfirmacao
    Created on : 09/07/2017, 15:08:05
    Author     : jean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> Dados de ${usuario} </title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Lato:400,300,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    </head>
    <body>
        <h1 class="bg-titulo titulo_confirmacao">Tela de Confirmação</h1>
        <table class="table table-responsive table-hover">
            <thead>
                <tr>
                    <th>codigo do pedido</th>
                    <th>Produto</th>
                    <th>Preço</th>
                </tr>
            </thead>
            <tbody>
                ${resultado_pedidos}
            </tbody>

            <thead>
                <tr>
                    <th>Nome do Cliente</th>
                    <th>CPF</th>
                    <th>PREÇO TOTAL</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th>${confirmacao_nome_cliente}</th>
                    <th>${confirmacao_cpf_cliente}</th>
                    <th>${preco_total}</th>
                </tr>
            </tbody>
        </table>
        <form action="Controlador">
            <input type="text" class="oculto" name="tipo" value="cliente">
            <input type="text" class="oculto" name="operacao" value="autenticacao">
            <button class="bg-white radius campo_inicio">CONFIRMAR</button>
        </form>
    </body>
</html>
