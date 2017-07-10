/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cdp;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author jean
 */
public class Pedido extends ItemAbstract{
    private Produto produto;
    private String cpf_cliente="1";
    private String codigo_produto="1";
    private String codigo_pedido="1";
    private  float preco=0;
    private String data_pedido="00/00/0000";
    private String status="";

    public Pedido() {
        super("pedido");
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
    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public void setPreco(String preco){
        this.setPreco(Float.parseFloat(preco));
    }
    
   
   
    
    @Override
    public String toString(){
        return getCodigo_pedido()+" "+getCodigo_produto()+" "+getCpf_cliente()+" "+ getPreco();
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
   
  

   
    public float getPreco() {
        return preco;
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
    
    public boolean equals(Object o){
        Pedido pedido = (Pedido) o;
        return pedido.getCodigo_pedido().equals(codigo_pedido) &&
                pedido.getCodigo_produto().equals(codigo_produto) &&
                pedido.getCpf_cliente().equals(cpf_cliente);
    }

    public void setData_pedido(String data) {
        this.data_pedido = data;
    }
    public String getData_pedido_old() {
        return data_pedido;
    }
    public String getData_pedido(){
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(data);
    }
}
