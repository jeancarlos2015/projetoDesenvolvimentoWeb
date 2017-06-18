/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cdp;

import java.util.List;


/**
 *
 * @author jean
 */
public interface Item {
    
    public void setDescricao(String descricao);
    public String getDescricao();
    public String[] getAtributos();
    public String getTipo();
    
    
}
