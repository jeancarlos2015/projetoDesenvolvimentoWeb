/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Produto;
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;

/**
 *
 * @author jean
 */
public class ControlarProdutos extends Controlar {

    public ControlarProdutos() {
        fabrica = Fabrica.make("produto");
        dao = fabrica.criaDaoProduto();
    }

    @Override
    public boolean cadastrar(Produto produto) {
        try {
            return dao.cadastrar(produto);
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean valida(Produto produto) {
        try {
            boolean result = produto.getCodigo().equals("null");
            result = result && produto.getCnpj().equals("null");
            result = result && produto.getMatricula().equals("null");
            result = result && produto.getNome().equals("null");
            result = result && produto.getPreco() == 0;
            result = result && produto.getMarca().equals("null");
            result = result && produto.getQuantidade() == 0;
            result = result && produto.getTipo().equals("null");
            return result;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean excluir(Produto produto) {
        try {
            if (existe(produto)) {
                msg("Produto foi excluido com sucesso!!!");
                return dao.excluir(produto);
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<Produto> listarProdutos() {
        try {
            return dao.listarProdutos();
        } catch (Exception e) {
            return new ArrayList();
        }

    }

    public List<Produto> listarProdutosNome(String nome) {
        try {
            return dao.listarProdutosNome(nome);
        } catch (Exception e) {
            return new ArrayList();
        }

    }

    @Override
    public boolean existe(Produto produto) {
        try {
            return dao.existe(produto);
        } catch (Exception e) {
            return false;
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
    public Produto buscar(String codigo_produto) {
        try {
            if (existe(codigo_produto)) {
                return (Produto) dao.buscar(codigo_produto);
            }
            return new Produto();
        } catch (Exception e) {
            return new Produto();
        }

    }

}
