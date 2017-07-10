/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padroes;

import com.sistex.cgt.ControlarPedidos;
import com.sistex.cci.ControladorPedido;
import com.sistex.cdp.Pedido;
import com.sistex.cgd.Dao;
import com.sistex.cgd.DaoPedido;
import com.sistex.cgd.Persistencia;
import javax.servlet.http.HttpServlet;
import com.sistex.cgt.InterfaceControlar;

/**
 *
 * @author jean
 */
public class FabricaPedido extends Fabrica{
    @Override
    public Pedido criaPedido(){return new Pedido();}
    
    @Override
    public DaoPedido criaDaoPedido(){return new DaoPedido();}
    
    
    @Override
    public HttpServlet criaControle(){return new ControladorPedido();}
    
    @Override
    public ControlarPedidos criaApiPedido(){return new ControlarPedidos();}
    
}
