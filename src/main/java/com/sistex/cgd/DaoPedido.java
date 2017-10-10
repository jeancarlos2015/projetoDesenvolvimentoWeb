/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Pedido;
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;
import static padroes.Tipo.pedido;

/**
 *
 * @author jean
 */
public class DaoPedido extends DaoAbstract {

    Fabrica fabrica = Fabrica.make(pedido);
    private final Persistencia persistencia = fabrica.criaPersistencia();

    @Override
    public boolean cadastrar(Pedido item) {
        Pedido p = (Pedido) item;
        String comando = "INSERT INTO PEDIDO(idproduto, cpf, data_pedido, preco_total, status) VALUES('" + p.getCodigo_produto() + "','" + p.getCpf_cliente() + "','"+p.getData_pedido()+ "'," + p.getPreco() +",'"+p.getStatus()+ "')";
        return persistencia.executar(comando);
    }
    
    @Override
    public Pedido buscar(String codigo_pedido){
        String vetor[] = persistencia.select("SELECT *FROM PEDIDO where codigo_pedido="+codigo_pedido,"codigo_pedido, idproduto, cpf, preco_total, data_pedido, status").split(";");
        Pedido ped = fabrica.criaPedido();
        for (String pedido : vetor) {
            String str[] = pedido.split(",");
            if (str.length == 6) {
                ped.setCodigo_pedido(str[0]);
                ped.setCodigo_produto(str[1]);
                ped.setCpf_cliente(str[2]);
                ped.setPreco(str[3]);
                ped.setData_pedido(str[4]);
                ped.setStatus(str[5]);
                return ped;
            }

        }
        return ped;
    }
    @Override
    public boolean excluir(Pedido pedido) {
        String comando = "DELETE FROM PEDIDO where codigo_pedido='" + pedido.getCodigo_pedido() + "' or idproduto = '" + pedido.getCodigo_produto() + "'";
        return persistencia.executar(comando);
    }

    @Override
    public List<Pedido> listarPedidos(String cpf) {
        String vetor[] = persistencia.select("SELECT *FROM PEDIDO where cpf='"+cpf+"'", "codigo_pedido, idproduto, cpf, preco_total, data_pedido, status").split(";");
        Pedido ped;
        List<Pedido> list = new ArrayList<>();
        for (String pedido : vetor) {
            String str[] = pedido.split(",");
            if (str.length == 6) {
                ped = new Pedido();
                ped.setCodigo_pedido(str[0]);
                ped.setCodigo_produto(str[1]);
                ped.setCpf_cliente(str[2]);
                ped.setPreco(str[3]);
                ped.setData_pedido(str[4]);
                ped.setStatus(str[5]);
                list.add(ped);
            }

        }
        return list;
    }
    @Override
    public List<Pedido> listarPedidosNome(String nome_produto){
        String comando="select ped.codigo_pedido, prod.preco, ped.data_pedido, ped.status, prod.idproduto from pedido as ped, produto as prod where ped.idproduto = prod.idproduto and (UPPER(prod.nome) like UPPER('%"+nome_produto+"%') or UPPER(prod.descricao) like UPPER('%"+nome_produto+"%'))";
        String[] result = persistencia.select(comando, "codigo_pedido, idproduto, preco, data_pedido, status").split(";");
        List<Pedido> lista = new ArrayList();
        for(String str:result){
            String[] dado=str.split(",");
            if(dado.length==5){
                Pedido pedido = fabrica.criaPedido();
                pedido.setCodigo_pedido(dado[0]);
                pedido.setCodigo_produto(dado[1]);
                pedido.setPreco(dado[2]);
                pedido.setData_pedido(dado[3]);
                pedido.setStatus(dado[4]);
                lista.add(pedido);
            }
        }
        return lista;
    }
        
    @Override
    public List<Pedido> listarPedidos() {
        String vetor[] = persistencia.select("SELECT *FROM PEDIDO", "codigo_pedido, idproduto, cpf, preco_total, data_pedido, status").split(";");
        Pedido ped;
        List<Pedido> list = new ArrayList<>();
        for (String pedido : vetor) {
            String str[] = pedido.split(",");
            if (str.length == 6) {
                ped = new Pedido();
                ped.setCodigo_pedido(str[0]);
                ped.setCodigo_produto(str[1]);
                ped.setCpf_cliente(str[2]);
                ped.setPreco(str[3]);
                ped.setData_pedido(str[4]);
                ped.setStatus(str[5]);
                list.add(ped);
            }

        }
        return list;
    }
    @Override
    public boolean alterar(Pedido pedido){
        return persistencia.executar("update pedido set idproduto = "+pedido.getCodigo_produto()+",cpf = '"+pedido.getCpf_cliente()+"', preco_total = "+pedido.getPreco()+", data_pedido = '"+pedido.getData_pedido()+"' where idproduto = "+pedido.getCodigo_produto());
    }
    
    @Override
    public boolean existe(Pedido pedido) {
        
        String info[] = persistencia.select("SELECT codigo_pedido FROM pedido WHERE codigo_pedido='" + pedido.getCodigo_pedido() + "'", "codigo_pedido").split(";");
        for (String str : info) {
            if (str.equals(pedido.getCodigo_pedido())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean existe(String codigo1) {
        String info[] = persistencia.select("SELECT codigo_pedido FROM pedido WHERE codigo_pedido=" + codigo1, "codigo_pedido").split(";");
        for(String str:info){
            if(info.length>0){
                return codigo1.equals(str);
            }
        }
        return false;
    }

    @Override
    public boolean excluirTodos() {
        return persistencia.executar("Delete FROM PEDIDO") && persistencia.executar("ALTER SEQUENCE pedido_codigo_seq RESTART WITH 1;");
    }

}
