/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padroes;

import com.sistex.cgt.ControlarFuncionarios;
import com.sistex.cci.ControladorCliente;
import com.sistex.cci.ControladorFuncionario;
import com.sistex.cdp.Funcionario;
import com.sistex.cdp.Item;
import com.sistex.cgd.DaoFuncionario;
import com.sistex.cgd.Dao;
import com.sistex.cgd.Persistencia;
import javax.servlet.http.HttpServlet;
import com.sistex.cgt.InterfaceControlar;

/**
 *
 * @author jean
 */
public class FabricaFuncionario extends Fabrica{
    @Override
    public Item criaObjeto(){return new Funcionario();}
    
    @Override
    public Dao criaDao(){return new DaoFuncionario();}
    
    @Override
    public Persistencia criaPersistencia(){return new Persistencia();}
    
    @Override
    public HttpServlet criaControle(){return new ControladorFuncionario();}
    
    @Override
    public InterfaceControlar criaApi(){return new ControlarFuncionarios();}
}
