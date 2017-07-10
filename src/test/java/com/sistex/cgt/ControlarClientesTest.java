/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;
import padroes.Fabrica;
import static padroes.Tipo.cliente;

/**
 *
 * @author jean
 */
public class ControlarClientesTest {
    private Fabrica fabrica = Fabrica.make(cliente);
    private InterfaceControlar api = fabrica.criaApiCliente();
    public ControlarClientesTest() {
    }

    /**
     * Test of buscar method, of class ControlarClientes.
     */
    @Test
    public void testBuscar() {
        Cliente cliente = new Cliente();
        cliente.setCpf("123123123");
        Cliente cliente1 = api.buscar(cliente);
        System.out.println(cliente1.toString());
        assertEquals(cliente1.getCpf(),"123123123");
    }

    /**
     * Test of cadastrar method, of class ControlarClientes.
     */
    
    public void testCadastrar() {
        Cliente cliente = (Cliente) api.buscar("1");
        cliente.setCpf("434444");
        cliente.setEmail("leandro@gmail.com");
        cliente.setNome("Leandro de castro");
        cliente.setIdade(40);
        cliente.setSenha(cliente.getNome());
        assertTrue(api.cadastrar(cliente));
    }
    @Test
    public void testAlterar() {
        Cliente cliente = (Cliente) api.buscar("1");
        cliente.setEmail("maria@gmail.com");
        cliente.setNome("Maria de castro");
        cliente.setIdade(40);
        cliente.setSenha(cliente.getNome());
        assertTrue(api.alterar(cliente));
    }
    /**
     * Test of excluir method, of class ControlarClientes.
     */
    @Test
    public void testExcluir() {
    }

    /**
     * Test of listarClientes method, of class ControlarClientes.
     */
    @Test
    public void testListarClientes() {
    }

    /**
     * Test of valida method, of class ControlarClientes.
     */
    @Test
    public void testValida() {
    }

    /**
     * Test of existe method, of class ControlarClientes.
     */
    @Test
    public void testExiste_Cliente() {
        Cliente cliente = fabrica.criaCliente();
        cliente.setCpf("1");
        assertTrue(api.existe(cliente));
    }

    /**
     * Test of existe method, of class ControlarClientes.
     */
    @Test
    public void testExiste_String() {
        assertTrue(api.existe("1"));
    }
    
    @Test
    public void testPrecoTotal(){
        System.out.println(api.getPrecoTotal("123123123"));
    }
    
}
