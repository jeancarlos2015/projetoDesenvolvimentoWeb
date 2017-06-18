/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Funcionario;
import com.sistex.cdp.Item;
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

/**
 *
 * @author jean
 */
public class ControladorFuncionario extends HttpServlet{
    private final Fabrica fabrica = Fabrica.make(Tipo.funcionario);
    private InterfaceControlar api;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        cadastrar(request, response);
        excluir(request, response);
        listar(request, response);
        
    }
    
    public void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(request.getParameter("operacao").equals("cadastro")){
            Item item = fabrica.criaObjeto();
            if(TelaAbstract.valida(request, item.getAtributos())){
                api = fabrica.criaApi();
                if(api.cadastrar(getItem(request))){
                    
                }
            }
        } 
    }
    
    public void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(request.getParameter("operacao").equals("exclusao")){
            Item item = fabrica.criaObjeto();
            if(TelaAbstract.valida(request, item.getAtributos())){
                api = fabrica.criaApi();
                if(api.excluir(getItem(request))){
                    
                }
            }
        } 
    }
    
    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(request.getParameter("operacao").equals("listar")){
            Item item = fabrica.criaObjeto();
            if(TelaAbstract.valida(request, item.getAtributos())){
                
                
            }
        }
    }
    
    public Item getItem(HttpServletRequest request) {
        Funcionario item = (Funcionario) fabrica.criaObjeto();
        //item.setCodigo(request.getParameter("matricula"));
        item.setNome(request.getParameter("rg"));
        item.setMatricula(request.getParameter("nome"));
        item.setSenha(request.getParameter("senha"));
        return item;
    }
}
