/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Fornecedor;
import com.sistex.cdp.Funcionario;
import com.sistex.cdp.Produto;
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;
import static padroes.Tipo.fornecedor;
import static padroes.Tipo.funcionario;
import static padroes.Tipo.produto;

/**
 *
 * @author jean
 */
public class DaoProduto extends DaoAbstract {

    private final Fabrica fabrica = Fabrica.make(produto);
    private final Fabrica fabricaFornecedor = Fabrica.make(fornecedor);
    private final Fabrica fabricaFuncionario = Fabrica.make(funcionario);
    private final Persistencia persistencia = fabrica.criaPersistencia();
    private final DaoFornecedor daoFornecedor = fabricaFornecedor.criaDaoFornecedor();
    private final DaoFuncionario daoFuncionario = fabricaFuncionario.criaDaoFuncionario();

    @Override
    public boolean cadastrar(Produto produto) {
        Fornecedor fornecedor = produto.getFornecedor();
        Funcionario funcionario = produto.getFuncionario();
        String comando = "INSERT INTO PRODUTO(cnpj, matricula, nome, descricao, preco, marca, quantidade) VALUES('" + fornecedor.getCnpj() + "','" + funcionario.getMatricula() + "','" + produto.getNome() + "','" + produto.getDescricao() + "'," + produto.getPreco() + ",'" + produto.getMarca() + "'," + produto.getQuantidade() + ")";
        return persistencia.executar(comando);
    }

    @Override
    public boolean excluir(Produto produto) {
        String comando = "DELETE FROM PRODUTO WHERE idproduto='" + produto.getIdproduto() + "'";
        return persistencia.executar(comando);
    }

    private Produto toProduto(String[] dado) {
        Produto produto = fabrica.criaProduto();
        produto.setIdproduto(dado[0]);
        produto.setNome(dado[1]);
        produto.setDescricao(dado[2]);
        produto.setPreco(dado[3]);
        produto.setMarca(dado[4]);
        produto.setQuantidade(dado[5]);
        Fornecedor fornecedor = daoFornecedor.buscar(dado[6]);
        produto.setFornecedor(fornecedor);
        Funcionario funcionario = daoFuncionario.buscar(dado[7]);
        produto.setFuncionario(funcionario);
      
        return produto;

    }

    @Override
    public Produto buscar(String idproduto) {
        Persistencia p = fabrica.criaPersistencia();
        String vetor[] = p.select("SELECT *FROM PRODUTO where idproduto = " + idproduto, "idproduto, nome, descricao, preco, marca, quantidade, cnpj, matricula").split(";");
        Produto produto = fabrica.criaProduto();
        for (String str : vetor) {
            String dado[] = str.split(",");
            if (dado[0].trim().equals(idproduto)) {
               return toProduto(dado);
            }
        }
        return produto;
    }

    @Override
    public List<Produto> listarProdutosNome(String nome) {
        String comando = "select *from produto where UPPER(nome) like UPPER('%" + nome.trim() + "%') or descricao like UPPER('%" + nome.trim() + "%')";
        String[] result = persistencia.select(comando, "idproduto, nome, descricao, preco, marca, quantidade, cnpj,matricula").split(";");
        List<Produto> lista = new ArrayList();
        for (String str : result) {
            String[] dado = str.split(",");
            if (dado.length == 8) {
                Produto produto = toProduto(dado);
                lista.add(produto);
            }

        }
        return lista;
    }

    @Override
    public List<Produto> listarProdutos() {
        Persistencia p = fabrica.criaPersistencia();
        String vetor[] = p.select("SELECT *FROM PRODUTO", "idproduto, nome, descricao, preco, marca, quantidade, cnpj, matricula, tipo").split(";");
        Produto produto;
        List<Produto> lista = new ArrayList();
        for (String str : vetor) {
            String dado[] = str.split(",");
            if (dado.length == 9) {
                produto = toProduto(dado);
                produto.setTipo(dado[8]);
                lista.add(produto);
            }

        }
        return lista;
    }

    @Override
    public boolean existe(Produto produto) {
        String[] result = persistencia.select("select idproduto from produto where idproduto=" + produto.getIdproduto(), "idproduto").split(";");
        for (String str : result) {
            String[] dado = str.split(",");
            if (dado[0].equals(produto.getIdproduto())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existe(String idproduto) {
        String[] result = persistencia.select("select idproduto from produto where idproduto='" + idproduto + "'", "idproduto").split(";");
        for (String str : result) {
            if (str.equals(idproduto)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean excluirTodos() {
        return persistencia.executar("Delete FROM PRODUTO") && persistencia.executar("ALTER SEQUENCE produto_idproduto_seq RESTART WITH 1;");
    }

}
