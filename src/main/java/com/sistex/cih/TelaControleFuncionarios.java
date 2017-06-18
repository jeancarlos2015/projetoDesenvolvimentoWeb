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
public class TelaControleFuncionarios extends TelaAbstract{
    
    /**
     *
     * @param response
     * @throws IOException
     */
    
    
    @Override
    public void montapagina(HttpServletResponse response){
        PrintWriter pw = null;
        try {
            response.setContentType("text/html");
            pw = response.getWriter();
            pw.println(" <!DOCTYPE html>");
            pw.println(" <html lang='pt-br'>");
            montahead(pw, "CONTROLE DE FUNCIONÁRIOS");
            montabody(pw, "CONTROLE DE FUNCIONÁRIOS");
            pw.println("</html>");
        } catch (IOException ex) {
            Logger.getLogger(TelaControleFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }

    }
 
    @Override
    public void montabody(PrintWriter pw, String titulo){
        pw.println("<body>");
        montamenu(pw);
        montacampos(pw,titulo,"cadastro");
        montarodape(pw);
        pw.println("</body>");
    }
   
    
    @Override
    public void montamenu(PrintWriter pw) {
        pw.println("<header class='cabecalho container'>");
        pw.println("<a href='index.html'><h1 class='logo'> SISclientes</h1></a>");
        pw.println("<button class='btn-menu bg-gradient'><i class='fa fa-bars fa-lg'></i></button>");
        pw.println("<nav class='menu' id='close1'>");
        pw.println("<a class='btn-close'><i class='fa fa-times'></i></a>");
        pw.println("<ul>");
        pw.println("<li class='home'><a href='index.jsp'>Home</a></li>");
        pw.println("<li class='home'><a href='acesso.jsp'>Acesso</a></li>");
        pw.println("</ul>");
        pw.println("</nav>");
        pw.println("</header>");
    }
    
    @Override
    public void montacampos(PrintWriter pw, String titulo, String tipo) {
        pw.println("<section class='newsletter container bg-grey'>");
        pw.println("<h1 class='bg-titulo'>"+titulo+"</h1>");
        pw.println("<form method='post' action='Controlador' onsubmit='mensagem();'>");
        criaCampo(pw, "nome", "Nome do funcionário","bg-white radius campo");
        criaCampo(pw, "matricula", "Sua matrícula","bg-white radius campo");
        criaCampo(pw, "cpf", "Seu cpf","bg-white radius campo");
        criaCampo(pw, "senha", titulo,"bg-white radius campo");
        criaCampoOculto(pw, "tipo","funcionario");
        criaCampoOculto(pw, "operacao", tipo);
        criaBotao(pw, "Cadastrar Funcionario","bg-white radius campo");
        pw.println("</form>");
        pw.println("</section>");
    }

    
}
