/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cih;

/**
 *
 * @author jean
 */
//string: nome, descricao, preco, tipo, marca, codigo
public class FiguraProduto {
    private String nome="", descricao="", preco="", tipo="", marca="", codigo="";
    public FiguraProduto(String str){
        String[] dado = str.split(",");
        nome = dado[0];
        descricao = dado[1];
        preco =  dado[2];
        tipo = dado[3];
        marca = dado[4];
        codigo = dado[5];
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String toFigura(){
        String pagina ="<figure class='figure' >" +
"                <a href='acesso.jsp'><img class='prato' src='img/"+tipo+".png' alt='...' class='img-thumbnail'></a> " +
"                <figcaption class='figure-caption'>"+nome+"</figcaption>" +
"                <figcaption class='figure-caption'>"+descricao+"</figcaption>" +
"                <figcaption class='figure-caption'>"+preco+"</figcaption>" +
"                <label><input name='tipo1' type='checkbox' value='"+codigo+"'></label>" +
"            </figure>";
        return pagina;
    }
}
