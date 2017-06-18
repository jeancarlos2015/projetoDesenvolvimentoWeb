/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;
import padroes.Fabrica;
import static padroes.Tipo.funcionario;

/**
 *
 * @author jean
 */
public class ControlarFuncionarios extends Controlar{

    public ControlarFuncionarios() {
        super(Fabrica.make(funcionario));
    }
    
}
