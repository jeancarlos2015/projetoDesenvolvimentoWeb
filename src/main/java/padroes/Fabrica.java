/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padroes;

import com.sistex.cci.Controlador;
import com.sistex.cdp.Cliente;
import com.sistex.cdp.Fornecedor;
import com.sistex.cdp.Funcionario;
import com.sistex.cdp.Pedido;
import com.sistex.cdp.Produto;
import com.sistex.cgd.Dao;
import com.sistex.cgd.DaoCliente;
import com.sistex.cgd.DaoFornecedor;
import com.sistex.cgd.DaoFuncionario;
import com.sistex.cgd.DaoPedido;
import com.sistex.cgd.DaoProduto;
import com.sistex.cgd.Persistencia;
import com.sistex.cgt.ControlarClientes;
import com.sistex.cgt.ControlarFornecedores;
import com.sistex.cgt.ControlarFuncionarios;
import com.sistex.cgt.ControlarPedidos;
import com.sistex.cgt.ControlarProdutos;
import javax.servlet.http.HttpServlet;
import com.sistex.cgt.InterfaceControlar;
import com.sistex.cih.Tela;

public class Fabrica {
    public static Fabrica make(Tipo tipo){
        switch(tipo){
            case cliente:
                return new FabricaCliente();
            case produto:
                return new FabricaProduto();
            case pedido:
                return new FabricaPedido();
            case funcionario:
                return new FabricaFuncionario();
            case fornecedor:
                return new FabricaFornecedor();
            default:
                return new Fabrica();
        }
    }
    public static Fabrica make(String tipo){
        switch(tipo){
            case "cliente":
                return new FabricaCliente();
            case "produto":
                return new FabricaProduto();
            case "pedido":
                return new FabricaPedido();
            case "funcionario":
                return new FabricaFuncionario();
            case "fornecedor":
                return new FabricaFornecedor();
            default:
                return new Fabrica();
        }
    }
    public Produto criaProduto(){return null;}
    public Cliente criaCliente(){return null;}
    public Pedido criaPedido(){return null;}
    public Funcionario criaFuncionario(){return null;}
    public Fornecedor criaFornecedor(){return null;}
    
    public DaoProduto criaDaoProduto(){return null;}
    public DaoCliente criaDaoCliente(){return null;}
    public DaoFornecedor criaDaoFornecedor(){return null;}
    public DaoPedido criaDaoPedido(){return null;}
    public DaoFuncionario criaDaoFuncionario(){return null;}
    
    public Persistencia criaPersistencia(){return new Persistencia();}
    public HttpServlet criaControle(){return new Controlador();}
    
    public ControlarFuncionarios criaApiFuncionario(){return null;}
    public ControlarProdutos criaApiProduto(){return null;}
    public ControlarFornecedores criaApiFornecedor(){return null;}
    public ControlarPedidos criaApiPedido(){return null;}
    public ControlarClientes criaApiCliente(){return null;}
    
    
    public Tela criaTela(){return new Tela();}
}
