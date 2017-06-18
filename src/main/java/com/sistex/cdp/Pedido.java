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
public class Pedido extends ItemAbstract{
    private Produto produto;
    private String cpf_cliente="1";
    private String codigo_produto="1";
    private String codigo_pedido="1";
    private  float preco_total=0;
    
    public Pedido() {
        super("pedido");
    }
    /**
     * @param preco_total the preco_total to set
     */
    public void setPreco_total(float preco_total) {
        this.preco_total = preco_total;
    }
    
    public void setPreco(String preco){
        this.setPreco_total(Float.parseFloat(preco));
    }
    
   
   @Override
    public  String[] getAtributos(){
        String vetor[] = {"codigo_pedido","codigo_produto","cpf","descricao","preco_total"};
        return vetor;
    }
    
    @Override
    public String toString(){
        return getCodigo_pedido()+" "+getCodigo_produto()+" "+getCpf_cliente()+" "+ getDescricao()+" "+ getPreco_total();
    }

    /**
     * @return the codigo_cliente
     */
    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }
    
    
   
    public String getCodigo_produto() {
        return codigo_produto;
    }

   
    public void setCodigo_produto(String codigo_produto) {
        this.codigo_produto = codigo_produto;
    }
   
  

   
    public float getPreco_total() {
        return preco_total;
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
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}
