/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cih;

/**
 *
 * @author jean
 * 
 */
//codigo_pedido, nome_produto, preco, status
public class FiguraPedido {
    private String codigo_pedido="00", nome_produto="teste", preco="0", status="";
    
    public FiguraPedido(String info){
        String[] dado = info.split(",");
        codigo_pedido = dado[0];
        nome_produto = dado[1];
        preco = dado[2];
        status = dado[3];
    }
    
    public String criaFiguraPedido(){
        String figura = "<figure class='figure' >" +
"                    <figcaption class='figure-caption'>Pedido "+getCodigo_pedido()+" </figcaption>" +
"                    <figcaption class='figure-caption'>"+getNome_produto()+"</figcaption>" +
"                    <figcaption class='figure-caption'>"+getPreco()+"</figcaption>" +
"                    <a><img class='prato' src='../img/pedido.png' alt='...' class='img-thumbnail'></a> " +
"                    <label><input name='tipo1' type='checkbox' value='2'></label>" +
"                    <div class='operacoes'>" +
"                        <form method='post' action='../Controlador'>" +
"                            <input type='text' class='oculto' name='tipo' value='pedido'>" +
"                            <input type='text' class='oculto' name='operacao' value='exclusao'>" +
"                            <input type='text' class='oculto' name='codigo_pedido' value='"+getCodigo_pedido()+"'>" +
"                            <button class='glyphicon glyphicon-remove-sign'>Excluir</button>" +
"                        </form>" +
"                        <label>"+status+"</label>" +
"                    </div>" +
"                </figure>";
        return figura;
    }

    /**
     * @return the codigo_pedido
     */
    public String getCodigo_pedido() {
        return codigo_pedido;
    }

    /**
     * @param codigo_pedido the codigo_pedido to set
     */
    public void setCodigo_pedido(String codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    /**
     * @return the nome_produto
     */
    public String getNome_produto() {
        return nome_produto;
    }

    /**
     * @param nome_produto the nome_produto to set
     */
    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    /**
     * @return the preco
     */
    public String getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(String preco) {
        this.preco = preco;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
