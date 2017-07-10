/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;
import padroes.Fabrica;

/**
 *
 * @author jean
 */
public class ControlarFuncionariosTest {
    private Fabrica fabrica = Fabrica.make("funcionario");
    private ControlarFuncionarios api = fabrica.criaApiFuncionario();
    public ControlarFuncionariosTest() {
    }

    /**
     * Test of cadastrar method, of class ControlarFuncionarios.
     */
    @Test
    public void testCadastrar() {
    }

    /**
     * Test of excluir method, of class ControlarFuncionarios.
     */
    @Test
    public void testExcluir() {
    }

    /**
     * Test of buscar method, of class ControlarFuncionarios.
     */
    @Test
    public void testBuscar() {
        Funcionario funcionario = fabrica.criaFuncionario();
        funcionario.setMatricula("0");
        funcionario.setSenha("teste");
        Funcionario novo = api.buscar(funcionario);
        System.out.println(novo.toString());
    }

    /**
     * Test of valida method, of class ControlarFuncionarios.
     */
    @Test
    public void testValida() {
    }

    /**
     * Test of listarFuncionarios method, of class ControlarFuncionarios.
     */
    @Test
    public void testListarFuncionarios() {
    }

    /**
     * Test of existe method, of class ControlarFuncionarios.
     */
    @Test
    public void testExiste_Funcionario() {
        Funcionario f = new Funcionario();
        f.setMatricula("0");
        f.setSenha("teste");
        assertTrue(api.existe(f));
    }

    /**
     * Test of existe method, of class ControlarFuncionarios.
     */
    @Test
    public void testExiste_String() {
    }
    
}
