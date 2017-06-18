/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padroes;

import com.sistex.cgt.ControlarProdutos;
import com.sistex.cci.ControleProduto;
import com.sistex.cdp.Item;
import com.sistex.cdp.Produto;
import com.sistex.cgd.Dao;
import com.sistex.cgd.DaoProduto;
import com.sistex.cgd.Persistencia;
import javax.servlet.http.HttpServlet;
import com.sistex.cgt.InterfaceControlar;

/**
 *
 * @author jean
 */
public class FabricaProduto extends Fabrica{
    @Override
    public Item criaObjeto(){return new Produto();}
    
    @Override
    public Dao criaDao(){return new DaoProduto();}
    
    @Override
    public Persistencia criaPersistencia(){return new Persistencia();}
    
    @Override
    public HttpServlet criaControle(){return new ControleProduto();}
    
    @Override
    public InterfaceControlar criaApi(){return new ControlarProdutos();}
}
