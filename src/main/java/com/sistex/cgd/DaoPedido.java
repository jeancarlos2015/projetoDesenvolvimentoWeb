/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Item;
import com.sistex.cdp.Pedido;
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;
import static padroes.Tipo.pedido;

/**
 *
 * @author jean
 */
public class DaoPedido implements Dao{
    Fabrica f = Fabrica.make(pedido);
    private final Persistencia conexao = f.criaPersistencia();
    
    @Override
    public boolean cadastrar(Item item) {
        Pedido p =(Pedido) item;
        String comando = "INSERT INTO PEDIDO(codigo_pedido, codigo_produto, cpf, descricao, preco_total) VALUES('"+p.getCodigo_pedido()+"','"+p.getCodigo_produto()+"','"+p.getCpf_cliente()+"','"+p.getDescricao()+"',"+p.getPreco_total()+")";
        return conexao.executar(comando);
    }

    @Override
    public boolean excluir(Item item) {
        Pedido p = (Pedido) item;
        String comando = "DELETE FROM PEDIDO where codigo_pedido='"+p.getCodigo_pedido()+"' or codigo_produto = '"+p.getCodigo_produto()+"'";
        return conexao.executar(comando);
    }

    @Override
    public List<Item> listar() {
        Persistencia p = f.criaPersistencia();
        String vetor[] = p.getValores("SELECT *FROM PEDIDO").split(";");
        Pedido ped;
        List<Item> list = new ArrayList<>();
        for(String pedido:vetor){
            String str[] = pedido.split(",");
            ped= new Pedido();
            ped.setCodigo_pedido(str[0]);
            ped.setCodigo_produto(str[1]);
            ped.setCpf_cliente(str[2]);
            ped.setDescricao(str[3]);
            ped.setPreco(str[4]);
            list.add(ped);
        }
        return list;
    }

    @Override
    public boolean existe(Item item) {
        Persistencia p = f.criaPersistencia();
        Pedido ped = (Pedido) item;
        String info[] = p.getValores("SELECT codigo_pedido FROM pedido WHERE codigo_pedido='"+ped.getCodigo_pedido()+"'").split(";");
        Pedido pedido = (Pedido) item;
        for(String str:info){
            if(str.equals(pedido.getCodigo_pedido())){
                return true;
            }
        }
            
        return false;
    }

    
   
    @Override
    public List<Item> listarVinculo(Item item) {
        Persistencia p = f.criaPersistencia();
        Pedido pedido1 = (Pedido) item;
        String vetor[] = p.getValores("SELECT *FROM PEDIDO where codigo_pedido = '"+pedido1.getCodigo_pedido()+"'").split(";");
        Pedido ped;
        List<Item> list = new ArrayList<>();
        for(String pedido:vetor){
            String str[] = pedido.split(",");
            ped= new Pedido();
            ped.setCodigo_pedido(str[0]);
            ped.setCodigo_produto(str[1]);
            ped.setCpf_cliente(str[2]);
            ped.setDescricao(str[3]);
            ped.setPreco(str[4]);
            list.add(ped);
        }
        return list;
    }

    @Override
    public Item getItem(String codigo) {
        Persistencia p = f.criaPersistencia();
        String info[] = p.getValores("SELECT *FROM pedido WHERE codigo="+codigo).split(";");
        Pedido ped = new Pedido();
        for(String pedido:info){
            String str[] = pedido.split(",");
            ped= new Pedido();
            ped.setCodigo_pedido(str[0]);
            ped.setCodigo_produto(str[1]);
            ped.setCpf_cliente(str[2]);
            ped.setDescricao(str[3]);
            ped.setPreco(str[4]);
        }
        return ped;
    }

    

    @Override
    public boolean existe(String codigo1) {
        Persistencia p = f.criaPersistencia();
        String info[] = p.getValores("SELECT codigo_pedido FROM pedido WHERE codigo_pedido='"+codigo1+"'").split(";");
        return info.length>0;
    }

    @Override
    public boolean excluirAll() {
        return conexao.executar("Delete FROM PEDIDO") && conexao.executar("ALTER SEQUENCE pedido_codigo_seq RESTART WITH 1;");
    }
    
}
