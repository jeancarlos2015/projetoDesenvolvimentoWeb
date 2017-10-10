/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;
import padroes.Fabrica;
import static padroes.Tipo.cliente;

/**
 *
 * @author jean
 */
public class DaoClienteTest {
    private final Fabrica fabrica = Fabrica.make(cliente);
    private final DaoCliente dao = fabrica.criaDaoCliente();
    public DaoClienteTest() {
    }

    /**
     * Test of cadastrar method, of class DaoCliente.
     */
    @Test
    public void testCadastrar() {
        Cliente cliente = new Cliente();
        cliente.setCpf("teste");
        if(!dao.existe(cliente)){
            assertTrue(dao.cadastrar(cliente));
        }
        assertFalse(false);
    }
//    @Test
//    public void testExiste(){
//        Cliente cliente = new Cliente();
//        cliente.setCpf("123123123");
//        assertTrue(dao.existe(cliente));
//    }
//    @Test
//    public void testBuscar(){
//        Cliente cliente = dao.buscar("84390248");
//        assertEquals(cliente.getNome(), "jean");
//    }
//    /**
//     * Test of excluir method, of class DaoCliente.
//     */
//    @Test
//    public void testExcluir() {
//        Cliente cliente = new Cliente();
//        cliente.setCpf("teste");
//        if(dao.existe(cliente)){
//            assertTrue(dao.excluir(cliente));
//        }
//        assertFalse(false);
//    }
//    @Test
    public void testAlterar(){
        Cliente cliente = dao.buscar("1");
        cliente.setEmail("leandro@gmail.com");
        cliente.setNome("Leandro de castro");
        cliente.setIdade(40);
        cliente.setSenha(cliente.getNome());
        assertTrue(dao.alterar(cliente));
    }
//
//    /**
//     * Test of listarClientes method, of class DaoCliente.
//     */
//    @Test
//    public void testListarClientes() {
//        for(Cliente cliente:dao.listarClientes()){
//            System.out.println(cliente.toString());
//        }
//    }
//
//    /**
//     * Test of existe method, of class DaoCliente.
//     */
//    @Test
//    public void testAutentica_Cliente() {
//        Cliente cliente = new Cliente();
//        cliente.setCpf("12312312312");
//        cliente.setSenha("senha");
//        assertTrue(dao.autentica(cliente));
//    }
//
//    /**
//     * Test of existe method, of class DaoCliente.
//     */
//    @Test
//    public void testExiste_String() {
//     assertTrue(dao.existe("12312312312"));   
//    }
//
//    /**
//     * Test of excluirTodos method, of class DaoCliente.
//     */
//    
//    public void testExcluirTodos() {
//    }
//    
//    @Test
//    public void testPrecoTotal(){
//        System.out.println("Teste preco total");
//        System.out.println(dao.getPrecoTotal("123123123"));
//    }
}
