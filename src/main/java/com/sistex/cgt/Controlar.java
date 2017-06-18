/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Item;
import com.sistex.cgd.Dao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import padroes.Fabrica;

/**
 *
 * @author jean
 */
public abstract class  Controlar implements InterfaceControlar{
    protected final  Dao dao;
    protected final Fabrica fabrica;
    protected HttpServletRequest request;
    
    public Controlar(Fabrica f){
        dao = f.criaDao();
        fabrica = f;
    }
    
    @Override
    public boolean cadastrar(Item item) {
        return dao.cadastrar(item);   
    }
    
    @Override
    public boolean excluir(Item item) {
        return dao.excluir(item);
    }
    
    @Override
    public List<Item> listarVinculados(Item item) {
        return dao.listarVinculo(item);
    }
    
    @Override
    public List<Item> listar() {
        return dao.listar();
    }

    @Override
    public boolean existe(Item item){
        return dao.existe(item);
    }
    
    
    
    @Override
    public boolean excluirAll(){
        return dao.excluirAll();
    }
    
    
    
   
    
}
