/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import com.sistex.cdp.Item;
import com.sistex.cdp.Pedido;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jean
 */
public class Pedidos {
    private List<Pedido> pedidos = new ArrayList<>();

    /**
     * @return the pedidos
     */
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(List<Item> pedidos) {
        this.pedidos =  new ArrayList(pedidos);
    }
    
    
}
