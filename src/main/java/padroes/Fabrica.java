/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padroes;

import com.sistex.cci.Controlador;
import com.sistex.cdp.Item;
import com.sistex.cgd.Dao;
import com.sistex.cgd.Persistencia;
import javax.servlet.http.HttpServlet;
import com.sistex.cgt.InterfaceControlar;

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
            default:
                return new Fabrica();
        }
    }
    public Item criaObjeto(){return null;}
    public Dao criaDao(){return null;}
    public Persistencia criaPersistencia(){return new Persistencia();}
    public HttpServlet criaControle(){return new Controlador();}
    public InterfaceControlar criaApi(){return null;}
}
