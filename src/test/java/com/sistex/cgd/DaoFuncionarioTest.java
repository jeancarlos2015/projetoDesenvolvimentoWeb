/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;
import padroes.Fabrica;

/**
 *
 * @author jean
 */
public class DaoFuncionarioTest {
    private Fabrica fabrica = Fabrica.make("funcionario");
    private DaoFuncionario dao = fabrica.criaDaoFuncionario();
    public DaoFuncionarioTest() {
    }

    /**
     * Test of cadastrar method, of class DaoFuncionario.
     */
    @Test
    public void testCadastrar() {
        Funcionario funcionario = fabrica.criaFuncionario();
        funcionario.setMatricula("123123");
        funcionario.setNome("Sistema");
        funcionario.setRg("1345380");
        funcionario.setSenha("senhasenha1");
        dao.cadastrar(funcionario);
        
        funcionario = fabrica.criaFuncionario();
        funcionario.setMatricula("123124");
        funcionario.setNome("Maria Das Graças");
        funcionario.setRg("1345381");
        funcionario.setSenha("senhasenha2");
        dao.cadastrar(funcionario);
        
        funcionario = fabrica.criaFuncionario();
        funcionario.setMatricula("123125");
        funcionario.setNome("Marcio De La Vega");
        funcionario.setRg("1345382");
        funcionario.setSenha("senhasenha3");
        dao.cadastrar(funcionario);
        
        funcionario = fabrica.criaFuncionario();
        funcionario.setMatricula("123126");
        funcionario.setNome("Mário Silva");
        funcionario.setRg("1345383");
        funcionario.setSenha("senhasenha4");
        dao.cadastrar(funcionario);
        
        funcionario = fabrica.criaFuncionario();
        funcionario.setMatricula("123127");
        funcionario.setNome("Rose Oliveira");
        funcionario.setRg("1345384");
        funcionario.setSenha("senhasenha5");
        dao.cadastrar(funcionario);
        
        funcionario = fabrica.criaFuncionario();
        funcionario.setMatricula("123123");
        funcionario.setNome("Sistema");
        funcionario.setRg("1345380");
        funcionario.setSenha("senhasenha1");
        dao.cadastrar(funcionario);
    }

//    /**
//     * Test of excluir method, of class DaoFuncionario.
//     */
//    @Test
//    public void testBuscar(){
//        Funcionario funcionario1 = fabrica.criaFuncionario();
//        funcionario1.setMatricula("1");
//        Funcionario funcionario = dao.buscar(funcionario1);
//        assertEquals(funcionario.getMatricula(), funcionario1.getMatricula());
//    }
//    
//    public void testExcluir() {
//        Funcionario funcionario = fabrica.criaFuncionario();
//        funcionario.setMatricula("432432");
////        assertTrue(dao.excluir(funcionario));
//        
//    }
//    @Test
//    public void testAlterar(){
//        Funcionario funcionario = dao.buscar("1");
//        funcionario.setNome("Maria das gracas");
//        funcionario.setRg("54334555");
//        funcionario.setSenha("alegria");
//        assertTrue(dao.alterar(funcionario));
//    }
//
//    /**
//     * Test of listarFuncionarios method, of class DaoFuncionario.
//     */
//    
//    public void testListarFuncionarios() {
//        for(Funcionario funcionario:dao.listarFuncionarios()){
//            System.out.println(funcionario.toString());
//        }
//    }
//
//    /**
//     * Test of existe method, of class DaoFuncionario.
//     */
//    @Test
//    public void testExiste_Funcionario() {
//        Funcionario funcionario = fabrica.criaFuncionario();
//        funcionario.setMatricula("0");
//        funcionario.setSenha("teste");
//        assertTrue(dao.existe(funcionario));
//    }
//
//    /**
//     * Test of existe method, of class DaoFuncionario.
//     */
//    @Test
//    public void testExiste_String() {
//        assertTrue(dao.existe("1"));
//    }
//
//    /**
//     * Test of excluirTodos method, of class DaoFuncionario.
//     */
//    @Test
//    public void testExcluirTodos() {
//    }
    
}
