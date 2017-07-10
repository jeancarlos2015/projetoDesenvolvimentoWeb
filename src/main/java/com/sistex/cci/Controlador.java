/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cih.Tela;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import padroes.Fabrica;

/**
 *
 * @author jean
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    private Fabrica fabrica;
    private HttpServlet controle;
    private final Tela tela = new Tela();
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (!"1".equals(tela.getInfo(request,"tipo"))) {
            fabrica = Fabrica.make(tela.getInfo(request,"tipo"));
            controle = fabrica.criaControle();
            controle.service(request, response);
        }else{
            tela.setSessaoAtributo(request, "mensagem", "Opção inválida!!!");
            tela.setSessaoAtributo(request, "usuario", null);
            tela.enviaMensagem(response, "acesso.jsp");
        }

    }
    
}
