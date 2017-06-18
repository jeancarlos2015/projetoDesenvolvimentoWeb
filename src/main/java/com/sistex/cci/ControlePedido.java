/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Item;
import com.sistex.cdp.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import padroes.Fabrica;
import padroes.Tipo;
import com.sistex.cgt.InterfaceControlar;
import com.sistex.cih.TelaAbstract;
import com.sistex.cih.TelaControlePedidos;

/**
 *
 * @author jean
 */
public class ControlePedido extends HttpServlet {
    private final Fabrica fabrica = Fabrica.make(Tipo.pedido);
    private InterfaceControlar api;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            TelaAbstract tela = new TelaControlePedidos();
            tela.montapagina(response);
    }
    
    public void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(request.getParameter("operacao").equals("cadastro")){
            Item item = fabrica.criaObjeto();
            if(TelaAbstract.valida(request, item.getAtributos())){
                api = fabrica.criaApi();
                item = getItem(request);
                if(api.cadastrar(item)){
                    
                }
            }
        } 
    }
    
    public void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(request.getParameter("operacao").equals("exclusao")){
            Item item = fabrica.criaObjeto();
            if(TelaAbstract.valida(request, item.getAtributos())){
                api = fabrica.criaApi();
                item = getItem(request);
                if(api.excluir(item)){
                    
                }
            }
        } 
    }
    
    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(request.getParameter("operacao").equals("listar")){
            Item item = fabrica.criaObjeto();
            if(TelaAbstract.valida(request, item.getAtributos())){
                api = fabrica.criaApi();
                
            }
        }
    }
    
    public Item getItem(HttpServletRequest request) {
        Pedido item = (Pedido) fabrica.criaObjeto();
        item.setCodigo_pedido(request.getParameter("codigo"));
        //item.setCodigo_cliente(request.getParameter("codigo_cliente"));
        item.setCodigo_produto(request.getParameter("codigo_produto"));
        item.setDescricao(request.getParameter("descricao"));
        item.setPreco(request.getParameter("preco"));
        return item;
    }
}
