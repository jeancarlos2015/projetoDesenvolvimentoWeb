/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Produto;
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;
import static padroes.Tipo.produto;

/**
 *
 * @author jean
 */
public class DaoProduto extends DaoAbstract {

    Fabrica fabrica = Fabrica.make(produto);
    private final Persistencia persistencia = fabrica.criaPersistencia();

    @Override
    public boolean cadastrar(Produto produto) {
        String comando = "INSERT INTO PRODUTO(cnpj, matricula, nome, descricao, preco, marca, quantidade) VALUES('" + produto.getCnpj() + "','" + produto.getMatricula() + "','" + produto.getNome() + "','" + produto.getDescricao() + "'," + produto.getPreco() + ",'" + produto.getMarca() + "'," + produto.getQuantidade() + ")";
        return persistencia.executar(comando);
    }

    @Override
    public boolean excluir(Produto produto) {
        String comando = "DELETE FROM PRODUTO WHERE codigo_produto='" + produto.getCodigo() + "'";
        return persistencia.executar(comando);
    }

    @Override
    public Produto buscar(String codigo_produto) {
        Persistencia p = fabrica.criaPersistencia();
        String vetor[] = p.select("SELECT *FROM PRODUTO where codigo_produto = " + codigo_produto, "codigo_produto, nome, descricao, preco, marca, quantidade, cnpj, matricula").split(";");
        Produto produto = fabrica.criaProduto();
        for (String str : vetor) {
            String dado[] = str.split(",");
            if (dado[0].trim().equals(codigo_produto)) {
                produto = fabrica.criaProduto();
                produto.setCodigo(dado[0]);
                produto.setNome(dado[1]);
                produto.setDescricao(dado[2]);
                produto.setPreco(dado[3]);
                produto.setMarca(dado[4]);
                produto.setQuantidade(dado[5]);
                produto.setCnpj(dado[6]);
                produto.setMatricula(dado[7]);
                return produto;
            }
        }
        return produto;
    }

    @Override
    public List<Produto> listarProdutosNome(String nome) {
        String comando = "select *from produto where UPPER(nome) like UPPER('%" + nome.trim() + "%') or descricao like UPPER('%" + nome.trim() + "%')";
        String[] result = persistencia.select(comando, "codigo_produto, nome, descricao, preco, marca, quantidade, cnpj,matricula").split(";");
        List<Produto> lista = new ArrayList();
        for (String str : result) {
            String[] dado = str.split(",");
            if (dado.length == 8) {
                Produto produto = new Produto();
                produto.setCodigo(dado[0]);
                produto.setNome(dado[1]);
                produto.setDescricao(dado[2]);
                produto.setPreco(dado[3].trim());
                produto.setMarca(dado[4]);
                produto.setQuantidade(dado[5]);
                produto.setCnpj(dado[6]);
                produto.setMatricula(dado[7]);
                lista.add(produto);
            }

        }
        return lista;
    }

    @Override
    public List<Produto> listarProdutos() {
        Persistencia p = fabrica.criaPersistencia();
        String vetor[] = p.select("SELECT *FROM PRODUTO", "codigo_produto, nome, descricao, preco, marca, quantidade, cnpj, matricula, tipo").split(";");
        Produto produto;
        List<Produto> lista = new ArrayList<>();
        for (String str : vetor) {
            String dado[] = str.split(",");
            if (dado.length == 9) {
                produto = new Produto();
                produto.setCodigo(dado[0]);
                produto.setNome(dado[1]);
                produto.setDescricao(dado[2]);
                produto.setPreco(dado[3]);
                produto.setMarca(dado[4]);
                produto.setQuantidade(dado[5]);
                produto.setCnpj(dado[6]);
                produto.setMatricula(dado[7]);
                produto.setTipo(dado[8]);
                lista.add(produto);
            }

        }
        return lista;
    }

    @Override
    public boolean existe(Produto produto) {
        String[] result = persistencia.select("select codigo_produto from produto where codigo_produto=" + produto.getCodigo(), "codigo_produto").split(";");
        for (String str : result) {
            String[] dado = str.split(",");
            if (dado[0].equals(produto.getCodigo())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existe(String codigo_produto) {
        String[] result = persistencia.select("select codigo_produto from produto where codigo_produto='" + codigo_produto + "'", "codigo_produto").split(";");
        for (String str : result) {
            if (str.equals(codigo_produto)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean excluirTodos() {
        return persistencia.executar("Delete FROM PRODUTO") && persistencia.executar("ALTER SEQUENCE produto_codigo_produto_seq RESTART WITH 1;");
    }

}
