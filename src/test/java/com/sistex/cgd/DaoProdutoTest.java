/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Fornecedor;
import com.sistex.cdp.Funcionario;
import com.sistex.cdp.Produto;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import padroes.Fabrica;

/**
 *
 * @author jean
 */
public class DaoProdutoTest {
    private final Fabrica fabrica = Fabrica.make("produto");
    private final DaoProduto dao = fabrica.criaDaoProduto();
    public DaoProdutoTest() {
    }

    /**
     * Test of cadastrar method, of class DaoProduto.
     */
    @Test
    public void testCadastrar() {
        Produto produto = new Produto();
        Fornecedor fornecedor = new Fornecedor();
        Funcionario funcionario = new Funcionario();
        fornecedor.setCnpj("1231231");
        funcionario.setMatricula("123123");
        produto.setNome("Prato personalizado carne seca");
        produto.setPreco(20);
        produto.setQuantidade(10);
        produto.setMarca("Rio doce");
        produto.setFornecedor(fornecedor);
        produto.setFuncionario(funcionario);
        dao.cadastrar(produto);
        
        
        fornecedor = new Fornecedor();
        funcionario = new Funcionario();
        
        produto = fabrica.criaProduto();
        fornecedor.setCnpj("1231231");
        funcionario.setMatricula("123123");
        produto.setNome("Macarronada");
        produto.setPreco(20);
        produto.setQuantidade(10);
        produto.setMarca("Macarrao");
        produto.setFornecedor(fornecedor);
        produto.setFuncionario(funcionario);
        dao.cadastrar(produto);
        
        fornecedor = new Fornecedor();
        funcionario = new Funcionario();
        produto = fabrica.criaProduto();
        fornecedor.setCnpj("1231231");
        funcionario.setMatricula("123123");
        produto.setNome("Prato com carne assada");
        produto.setPreco(20);
        produto.setQuantidade(10);
        produto.setMarca("sistex");
        produto.setFornecedor(fornecedor);
        produto.setFuncionario(funcionario);
        dao.cadastrar(produto);
        
        fornecedor = new Fornecedor();
        funcionario = new Funcionario();
        produto = fabrica.criaProduto();
        fornecedor.setCnpj("1231231");
        funcionario.setMatricula("123123");
        produto.setNome("Regrigerante coca-cola");
        produto.setPreco(20);
        produto.setQuantidade(10);
        produto.setMarca("Coca-cola");
        produto.setFornecedor(fornecedor);
        produto.setFuncionario(funcionario);
        dao.cadastrar(produto);
        
        fornecedor = new Fornecedor();
        funcionario = new Funcionario();
        produto = fabrica.criaProduto();
        fornecedor.setCnpj("1231231");
        funcionario.setMatricula("123123");
        produto.setNome("Regrigerante fanta");
        produto.setPreco(20);
        produto.setQuantidade(10);
        produto.setMarca("Guarana");
        produto.setFornecedor(fornecedor);
        produto.setFuncionario(funcionario);
        dao.cadastrar(produto);
        
        fornecedor = new Fornecedor();
        funcionario = new Funcionario();
        produto = fabrica.criaProduto();
        fornecedor.setCnpj("1231231");
        funcionario.setMatricula("123123");
        produto.setNome("Prato personalizado carne de frango frito");
        produto.setPreco(20);
        produto.setQuantidade(10);
        produto.setMarca("Rio doce");
        produto.setFornecedor(fornecedor);
        produto.setFuncionario(funcionario);
        dao.cadastrar(produto);
        
        fornecedor = new Fornecedor();
        funcionario = new Funcionario();
        produto = fabrica.criaProduto();
        fornecedor.setCnpj("1231231");
        funcionario.setMatricula("123123");
        produto.setNome("Prato personalizado carne seca");
        produto.setPreco(20);
        produto.setQuantidade(10);
        produto.setMarca("Rio doce");
        produto.setFornecedor(fornecedor);
        produto.setFuncionario(funcionario);
        dao.cadastrar(produto);
        assertTrue(dao.cadastrar(produto));
    }
//
//    /**
//     * Test of excluir method, of class DaoProduto.
//     */
//    @Test
//    public void testExcluir() {
//        Produto produto = new Produto();
//        produto.setIdproduto("41");
////        assertTrue(dao.excluir(produto));
//    }
//
//    /**
//     * Test of listarProdutos method, of class DaoProduto.
//     */
//    @Test
//    public void testListarProdutos() {
//        List<Produto> produtos = dao.listarProdutosNome("feijao");
//        for(Produto produto:produtos){
//            System.out.println(produto.toString());
//        }
//    }
//
//    /**
//     * Test of existe method, of class DaoProduto.
//     */
//    @Test
//    public void testExiste_Produto() {
//        Produto produto = fabrica.criaProduto();
//        produto.setNome("feijao");
//        assertTrue(dao.existe(produto));
//    }
//
//    /**
//     * Test of existe method, of class DaoProduto.
//     */
//    @Test
//    public void testExiste_String() {
//        assertTrue(dao.existe("1"));
//    }
//
//    /**
//     * Test of excluirTodos method, of class DaoProduto.
//     */
//    
//    public void testExcluirTodos() {
//        dao.excluirTodos();
//    }
//    
//    @Test
//    public void testBuscar(){
//        System.out.println("Teste busca");
//        Produto produto = dao.buscar("2");
//        System.out.println(produto.toString());
//    }
}
