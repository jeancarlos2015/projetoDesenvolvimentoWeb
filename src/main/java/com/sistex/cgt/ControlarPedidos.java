/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Pedido;
import com.sistex.cdp.Produto;
import com.sistex.cgd.Dao;
import com.sistex.cgd.DaoProduto;
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;

/**
 *
 * @author jean
 */
public class ControlarPedidos extends Controlar {
    private final Fabrica fabrica_produto = Fabrica.make("produto");
    private final DaoProduto daoProduto = fabrica_produto.criaDaoProduto();
    public ControlarPedidos() {
        fabrica = Fabrica.make("pedido");
        dao = fabrica.criaDaoPedido();
    }

    @Override
    public boolean cadastrar(Pedido pedido) {
        try {
            if (!existe(pedido)) {
                return dao.cadastrar(pedido);
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean valida(Pedido pedido) {
        try {
            boolean result = pedido.getCodigo_pedido().equals("null");
            result = result && pedido.getCodigo_produto().equals("null");
            result = result && pedido.getPreco() == 0;
            result = result && pedido.getCpf_cliente().equals("null");
            return result;
        } catch (Exception e) {
            return false;
        }

    }
    @Override
    public boolean cadastrar(List<String> codigo_produtos, String cpf){
        DaoProduto daoproduto = fabrica_produto.criaDaoProduto();
        for(String codigo_produto:codigo_produtos){
            Produto produto = daoproduto.buscar(codigo_produto);
            Pedido pedido = fabrica.criaPedido();
            pedido.setCodigo_produto(codigo_produto);
            pedido.setCpf_cliente(cpf);
            pedido.setPreco(produto.getPreco());
            pedido.setStatus("pendente");
            if(!dao.cadastrar(pedido)){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public Pedido buscar(String codigo_pedido){
        try {
            return (Pedido) dao.buscar(codigo_pedido);
        } catch (Exception e) {
            return new Pedido();
        }
    }
    @Override
    public boolean alterar(Pedido pedido) {
        try {
            if (existe(pedido)) {
                return dao.alterar(pedido);
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean excluir(Pedido pedido) {
        try {
            if (existe(pedido)) {
                return dao.excluir(pedido);
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }
    @Override
    public List<Pedido> listarPedidosNome(String nome_produto){
        try {
            return dao.listarPedidosNome(nome_produto);
        } catch (Exception e) {
            return new ArrayList();
        }
    }
    @Override
    public List<Pedido> listarPedidos(String cpf) {
        try {
            return dao.listarPedidos(cpf);
        } catch (Exception e) {
            return new ArrayList();
        }

    }

    @Override
    public List<Pedido> listarPedidos() {
        try {
            return dao.listarPedidos();
        } catch (Exception e) {
            return new ArrayList();
        }

    }

    @Override
    public boolean existe(String codigo) {
        try {
            return dao.existe(codigo);
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean existe(Pedido pedido) {
        try {
            return dao.existe(pedido);
        } catch (Exception e) {
            return false;
        }

    }

}
