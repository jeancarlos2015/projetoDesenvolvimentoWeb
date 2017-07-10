/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cdp;

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
    private String codigo="1";
    
    private String cnpj;
    private String matricula;
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
        return getCodigo()+" "+getCnpj()+" "+matricula+" "+nome+" "+getDescricao()+" "+preco+" "+marca+" "+quantidade;
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

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public boolean equals(Object o){
        Produto produto = (Produto) o;
        return produto.getCnpj().equals(cnpj) &&
                produto.getCodigo().equals(codigo) &&
                produto.getMatricula().equals(matricula) &&
                produto.getNome().equals(nome) &&
                produto.getPreco()==preco &&
                produto.getMarca().equals(marca) &&
                produto.getQuantidade()==quantidade;
                
    }
    //string: nome, descrica, preco, tipo, marca, codigo
    public String toFigura(){
        return nome+","+getDescricao()+","+preco+","+getTipoImagem()+","+marca+","+codigo;
    }
}
