/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Produto;
import org.junit.Test;
import static org.junit.Assert.*;
import padroes.Fabrica;

/**
 *
 * @author jean
 */
public class ControlarProdutosTest {
    private final Fabrica fabrica = Fabrica.make("produto");
    private final ControlarProdutos api = fabrica.criaApiProduto();
    public ControlarProdutosTest() {
    }

    /**
     * Test of cadastrar method, of class ControlarProdutos.
     */
    @Test
    public void testCadastrar() {
    }

    /**
     * Test of valida method, of class ControlarProdutos.
     */
    @Test
    public void testValida() {
    }

    /**
     * Test of excluir method, of class ControlarProdutos.
     */
    @Test
    public void testExcluir() {
    }

    /**
     * Test of listarProdutos method, of class ControlarProdutos.
     */
    @Test
    public void testListarProdutos() {
    }

    /**
     * Test of listarProdutosNome method, of class ControlarProdutos.
     */
    @Test
    public void testListarProdutosNome() {
    }

    /**
     * Test of existe method, of class ControlarProdutos.
     */
    @Test
    public void testExiste_Produto() {
    }

    /**
     * Test of existe method, of class ControlarProdutos.
     */
    @Test
    public void testExiste_String() {
    }

    /**
     * Test of buscar method, of class ControlarProdutos.
     */
    @Test
    public void testBuscar() {
        Produto produto = api.buscar("10");
        assertEquals(produto.getIdproduto(), "10");
    }
    
}
