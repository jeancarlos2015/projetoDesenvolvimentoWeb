/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Item;
import java.util.List;

/**
 *
 * @author jean
 */
public interface Dao {
    public boolean cadastrar(Item item);
    public boolean excluir(Item item);
    public boolean excluirAll();
    public List<Item> listar();
    public List<Item> listarVinculo(Item item);
    public boolean existe(Item item);
    public boolean existe(String cpf);
    public Item getItem(String cpfCodigo);
}
