/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padroes;

import com.sistex.cci.ControladorCliente;
import com.sistex.cci.ControladorFornecedor;
import com.sistex.cdp.Cliente;
import com.sistex.cdp.Fornecedor;
import com.sistex.cgd.DaoCliente;
import com.sistex.cgd.DaoFornecedor;
import com.sistex.cgt.ControlarClientes;
import com.sistex.cgt.ControlarFornecedores;
import com.sistex.cgt.InterfaceControlar;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author jean
 */
public class FabricaFornecedor extends Fabrica{
    @Override
    public Fornecedor criaFornecedor(){return new Fornecedor();}
    
    @Override
    public DaoFornecedor criaDaoFornecedor(){return new DaoFornecedor();}
    
    @Override
    public HttpServlet criaControle(){return new ControladorFornecedor();}
    
    @Override
    public ControlarFornecedores criaApiFornecedor(){return new ControlarFornecedores();}
}
