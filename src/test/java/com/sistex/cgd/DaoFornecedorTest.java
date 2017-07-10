/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Fornecedor;
import org.junit.Test;
import static org.junit.Assert.*;
import padroes.Fabrica;

/**
 *
 * @author jean
 */
public class DaoFornecedorTest {
    private Fabrica fabrica = Fabrica.make("fornecedor");
    private DaoFornecedor dao = fabrica.criaDaoFornecedor();
    public DaoFornecedorTest() {
    }

    /**
     * Test of cadastrar method, of class DaoFornecedor.
     */
    @Test
    public void testCadastrar() {
        Fornecedor f = new Fornecedor();
        f.setCnpj("1223");
        f.setCnpj(f.getCnpj()+"1");
//        assertTrue(dao.cadastrar(f));
    }

    /**
     * Test of buscar method, of class DaoFornecedor.
     */
    @Test
    public void testBuscar() {
        Fornecedor f = dao.buscar("1231235");
        System.out.println(f.toString());
    }

    /**
     * Test of excluir method, of class DaoFornecedor.
     */
    @Test
    public void testExcluir() {
        Fornecedor f = new Fornecedor();
        f.setCnpj("1223");
//        assertTrue(dao.excluir(f));
    }

    /**
     * Test of excluirTodos method, of class DaoFornecedor.
     */
    @Test
    public void testExcluirTodos() {
    }

    /**
     * Test of existe method, of class DaoFornecedor.
     */
    @Test
    public void testExiste_Fornecedor() {
        Fornecedor fornecedor = fabrica.criaFornecedor();
        fornecedor.setCnpj("1231235");
        fornecedor.setNome("Ciclano");
        fornecedor.setTelefone("33413211");
        fornecedor.setTelefone("Rua sabara 277");
        assertTrue(dao.existe(fornecedor));
    }

    /**
     * Test of listarFornecedores method, of class DaoFornecedor.
     */
    @Test
    public void testListarFornecedores_0args() {
        for(Fornecedor fornecedor:dao.listarFornecedores()){
            System.out.println(fornecedor.toString());
        }
    }

    /**
     * Test of listarFornecedores method, of class DaoFornecedor.
     */
    @Test
    public void testListarFornecedores_String() {
        for(Fornecedor fornecedor:dao.listarFornecedores()){
            System.out.println(fornecedor.toString());
        }
    }

    /**
     * Test of existe method, of class DaoFornecedor.
     */
    @Test
    public void testExiste_String() {
        assertTrue(dao.existe("1231235"));
    }
    @Test
    public void testAlterar(){
        Fornecedor fornecedor = dao.buscar("1231235");
        fornecedor.setNome("Imperial");
        fornecedor.setTelefone("3555-2400");
        fornecedor.setEndereco("BR 040 Pav. SG Box 09-09A Contagem - MG - CEP: 32145-900");
        assertTrue(dao.alterar(fornecedor));
    }
}
