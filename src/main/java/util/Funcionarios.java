/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.sistex.cdp.Funcionario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jean
 */
public class Funcionarios {
    private List<Funcionario> funcionarios = new ArrayList<>();
    
     public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    /**
     * @param funcionarios the funcionarios to set
     */
    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = new ArrayList(funcionarios);
    }
}
