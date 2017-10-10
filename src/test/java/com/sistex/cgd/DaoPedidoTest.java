/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Pedido;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import padroes.Fabrica;

/**
 *
 * @author jean
 */
public class DaoPedidoTest {
    private final Fabrica fabrica = Fabrica.make("pedido");
    DaoPedido dao = fabrica.criaDaoPedido();
    public DaoPedidoTest() {
    }

    /**
     * Test of cadastrar method, of class DaoPedido.
     */
    @Test
    public void testCadastrar() {
        System.out.println("Cadastrar pedido");
        Pedido pedido = fabrica.criaPedido();
        pedido.setCodigo_produto("1");
        pedido.setCpf_cliente("123123123");
        pedido.setData_pedido("09/07/2017");
        pedido.setPreco("50");
        assertTrue(dao.cadastrar(pedido));
    }
//
//    /**
//     * Test of excluir method, of class DaoPedido.
//     */
//    @Test
//    public void testExcluir() {
//        System.out.println("Excluir pedido");
//        Pedido pedido = fabrica.criaPedido();
//        pedido.setCodigo_produto("1");
////        assertTrue(dao.excluir(pedido));
//    }
//
//    /**
//     * Test of listarPedidos method, of class DaoPedido.
//     */
//    @Test
//    public void testListarPedidos_String() {
//        System.out.println("Lista de todos os pedidos");
//        for(Pedido pedido:dao.listarPedidos()){
//            System.out.println(pedido.toString());
//        }
//        
//    }
//
//    /**
//     * Test of listarPedidos method, of class DaoPedido.
//     */
//    @Test
//    public void testListarPedidos_0args() {
//        System.out.println("Lista de pedidos por cpf");
//        List<Pedido> pedidos = dao.listarPedidos("123123123");
//        for(Pedido pedido:pedidos){
//            System.out.println(pedido.toString());
//        }
//    }
//
//    /**
//     * Test of existe method, of class DaoPedido.
//     */
//    //Verifica se o pedido 9 existe
//    @Test
//    public void testExiste_Pedido() {
//        Pedido pedido =fabrica.criaPedido();
//        pedido.setCodigo_pedido("9");
//        assertTrue(dao.existe(pedido));
//    }
//
//    /**
//     * Test of existe method, of class DaoPedido.
//     */
//    @Test
//    public void testExiste_String() {
//        assertTrue(dao.existe("9"));
//    }
//    @Test
//    public void testBuscar(){
//        Pedido pedido = dao.buscar("8");
//        assertEquals(pedido.getCodigo_pedido(), "8");
//    }
//    @Test
//    public void testAlterar(){
//       Pedido pedido = dao.buscar("8");
//       pedido.setData_pedido("10/10/2017");
//       pedido.setCpf_cliente("535435");
//       pedido.setPreco("120");
//        assertTrue(dao.alterar(pedido));
//    }
//    @Test
//    public void testData(){
//        System.out.println("Teste data");
//        Date data = new Date();
//        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
//        System.out.println(formatador.format(data));
//    }
//    
//    @Test
//    public void testListarPedidosNome(){
//        System.out.println("Testando lista por nome");
//        List<Pedido> pedidos = dao.listarPedidosNome("feijao");
//        for(Pedido pedido:pedidos){
//            System.out.println(pedido.toString());
//        }
//    }
}
