///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.sistex.cgt;
//
//import com.sistex.cdp.Pedido;
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import padroes.Fabrica;
//import static padroes.Tipo.pedido;
//
///**
// *
// * @author jean
// */
//public class ControlarPedidosTest {
//    private Fabrica fabrica = Fabrica.make(pedido);
//    private ControlarPedidos api = fabrica.criaApiPedido();
//    public ControlarPedidosTest() {
//    }
//
//    /**
//     * Test of cadastrar method, of class ControlarPedidos.
//     */
//    @Test
//    public void testCadastrar_Pedido() {
//    }
//
//    /**
//     * Test of valida method, of class ControlarPedidos.
//     */
//    @Test
//    public void testValida() {
//    }
//
//    /**
//     * Test of cadastrar method, of class ControlarPedidos.
//     */
//    
//    public void testCadastrar_List_String() {
//        List<String> lista_codigo_produtos = new ArrayList();
//        lista_codigo_produtos.add("3");
//        lista_codigo_produtos.add("4");
//        String cpf="4382948329434311";
//        assertTrue(api.cadastrar(lista_codigo_produtos, cpf));
//    }
//
//    /**
//     * Test of alterar method, of class ControlarPedidos.
//     */
//    @Test
//    public void testAlterar() {
//    }
//
//    /**
//     * Test of excluir method, of class ControlarPedidos.
//     */
//    @Test
//    public void testExcluir() {
//    }
//
//    /**
//     * Test of listarPedidos method, of class ControlarPedidos.
//     */
//    @Test
//    public void testListarPedidos_String() {
//    }
//
//    /**
//     * Test of listarPedidos method, of class ControlarPedidos.
//     */
//    @Test
//    public void testListarPedidos_0args() {
//    }
//
//    /**
//     * Test of existe method, of class ControlarPedidos.
//     */
//    @Test
//    public void testExiste_String() {
//    }
//
//    /**
//     * Test of existe method, of class ControlarPedidos.
//     */
//    @Test
//    public void testExiste_Pedido() {
//    }
//    @Test
//    public void testListaPedidosNome(){
//        System.out.println("Listar pedidos por nome");
//        List<Pedido> lista = api.listarPedidosNome("feijao");
//        for(Pedido pedido:lista){
//            System.out.println(pedido);
//        }
//    }
//    
//    @Test
//    public void testBuscarPedido(){
//        Pedido pedido = api.buscar("5");
//        assertEquals(pedido.getCodigo_pedido(), "5");
//    }
//}
