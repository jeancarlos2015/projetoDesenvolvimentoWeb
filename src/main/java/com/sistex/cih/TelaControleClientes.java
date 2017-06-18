/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cih;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jean
 */
public class TelaControleClientes extends TelaAbstract{
   
    
    @Override
    public void montapagina(HttpServletResponse response){
        PrintWriter pw = null;
        try {
            inicioHtml(response);
            montahead(pw, "CONTROLE DE CLIENTES");
            montabody(pw, "CONTROLE DE CLIENTES");
            fimHtml(pw);
            
        } catch (IOException ex) {
            Logger.getLogger(TelaControleClientes.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }
        
    @Override
    public void montabody(PrintWriter pw, String titulo){
        pw.println("<body>");
        montamenu(pw);
        montacampos(pw,titulo,"controle");
        montaTabela(pw,titulo);
        montarodape(pw);
        pw.println("</body>");
    }

    @Override
    public void montamenu(PrintWriter pw) {
        abreMenu(pw);
        criaItemMenu(pw, "home", "acesso.jsp", "Logout");
        fechaMenu(pw);
    }

    @Override
    public void montacampos(PrintWriter pw, String titulo, String tipo) {
        pw.println("<section class='newsletter container bg-grey'>");
        pw.println("<h1 class='bg-titulo'>"+titulo+"</h1>");
        pw.println("<form method='post' action='Controlador'>");
        criaCampoOculto(pw, "matricula", "0");
        criaCampo(pw, "nome", "Nome do cliente","bg-white radius campo");
        criaCampo(pw, "idade", "Idade do cliente","bg-white radius campo");
        criaCampo(pw, "cpf", "CPF do cliente","bg-white radius campo");
        criaCampo(pw, "email", "Email do Cliente","bg-white radius campo");
        criaCampoSenha(pw, "senha", "Senha do Cliente","bg-white radius campo");
        criaCampoOculto(pw, "tipo", "cliente");
        criaCampoOculto(pw, "operacao", tipo);
        criaBotao(pw, "Cadastrar Clientes","bg-white radius campo");
        pw.println("</form>");
        pw.println("</section>");
    }

    
    

}
