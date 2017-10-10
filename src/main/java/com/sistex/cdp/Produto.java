/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cdp;

import java.util.Objects;

/**
 *
 * @author jean
 */

public class Produto extends ItemAbstract{
    private String marca="nenhum";
    private String nome="produto";
    private float preco=0;
    private int quantidade=0;
    private String imagem="";
    private String idproduto="1";
    private String descricao="";
    private Funcionario funcionario;
    private Fornecedor fornecedor;
    
    public Produto() {
        super("produto");
    }
    
    
    public void setMarca(String marca) {
        this.marca = marca;
    }

    
    public String getMarca() {
        return marca;
    }
   
    
    @Override
    public String toString(){
        return getIdproduto()+" "+fornecedor.getCnpj()+" "+funcionario.getMatricula()+" "+fornecedor.getCnpj()+" "+nome+" "+getDescricao()+" "+preco+" "+marca+" "+quantidade;
    }
    
    
    public String getTipoImagem(){
        String nome1 = this.nome.toLowerCase();
        if(nome1.contains("salada") || getDescricao().contains("salada")){
            return "salada";
        }
        else if(nome1.contains("tropeiro") || getDescricao().contains("tropeiro")){
            return "tropeiro";
        }
        else if(nome1.contains("macarrao") || nome1.contains("espaguete") || getDescricao().contains("espaguete")){
            return "espaguete";
        }
        else if(nome1.contains("frango") || getDescricao().contains("frango")){
            return "prato1";
        }
        else if(getNome().contains("bife") || getDescricao().contains("bife")){
            return "prato2";
        }
        else if(getNome().contains("coca cola") || getDescricao().contains("coca cola")){
            return "cocazero";
        }
        else if(getNome().contains("refrigerante") || getDescricao().contains("regrigerante")){
            return "refrigerante";
        }
        else{
            return "cs";
        }
    }

    /**
     * @return the nome1
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome1 to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public void setPreco(String preco){
        this.preco = Float.parseFloat(preco.trim());
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
   
    public void setQuantidade(String quantidade){
        this.quantidade = Integer.parseInt(quantidade);
    }

    public String getIdproduto() {
        return idproduto;
    }

    /**
     * @param idproduto the idproduto to set
     */
    public void setIdproduto(String idproduto) {
        this.idproduto = idproduto;
    }
    @Override
    public boolean equals(Object o){
        Produto produto = (Produto) o;
        Fornecedor fornecedor1 = produto.getFornecedor();
        Funcionario funcionario1 = produto.getFuncionario();
        return fornecedor1.getCnpj().equals(this.fornecedor.getCnpj()) &&
                produto.getIdproduto().equals(idproduto) &&
                funcionario1.getMatricula().equals(this.funcionario.getMatricula()) &&
                produto.getNome().equals(nome) &&
                produto.getPreco()==preco &&
                produto.getMarca().equals(marca) &&
                produto.getQuantidade()==quantidade;
                
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.marca);
        hash = 11 * hash + Objects.hashCode(this.nome);
        hash = 11 * hash + Float.floatToIntBits(this.preco);
        hash = 11 * hash + this.quantidade;
        hash = 11 * hash + Objects.hashCode(this.imagem);
        hash = 11 * hash + Objects.hashCode(this.idproduto);
        hash = 11 * hash + Objects.hashCode(this.descricao);
        hash = 11 * hash + Objects.hashCode(this.funcionario);
        hash = 11 * hash + Objects.hashCode(this.fornecedor);
        return hash;
    }
    //string: nome, descrica, preco, tipo, marca, idproduto
    public String toFigura(){
        return nome+","+getDescricao()+","+preco+","+getTipoImagem()+","+marca+","+idproduto;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }


    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
