/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padroes;

import com.sistex.cgt.ControlarClientes;
import com.sistex.cci.ControladorCliente;
import com.sistex.cdp.Cliente;
import com.sistex.cdp.Item;
import com.sistex.cgd.Dao;
import com.sistex.cgd.DaoCliente;
import com.sistex.cgd.Persistencia;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServlet;
import com.sistex.cgt.InterfaceControlar;

/**
 *
 * @author jean
 */
public class FabricaCliente extends Fabrica{
    @Override
    public Item criaObjeto(){return new Cliente();}
    
    @Override
    public Dao criaDao(){return new DaoCliente();}
    
    @Override
    public Persistencia criaPersistencia(){return new Persistencia();}
    
    @Override
    public HttpServlet criaControle(){return new ControladorCliente();}
    
    @Override
    public InterfaceControlar criaApi(){return new ControlarClientes();}
}
