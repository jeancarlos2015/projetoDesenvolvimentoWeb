/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import com.sistex.cdp.Cliente;
import com.sistex.cdp.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jean
 */
public class Clientes {
    private List<Cliente> clientes = new ArrayList<>();
    
     public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(List<Item> clientes) {
        this.clientes = new ArrayList(clientes);
    }
}
