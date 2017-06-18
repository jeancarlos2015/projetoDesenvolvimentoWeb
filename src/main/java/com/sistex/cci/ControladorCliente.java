/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Cliente;
import com.sistex.cdp.Item;
import com.sistex.cgd.Dao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import padroes.Fabrica;
import com.sistex.cgt.InterfaceControlar;
import com.sistex.cih.TelaAbstract;
import com.sistex.cih.TelaControleClientes;
import com.sistex.cih.TelaControleProdutos;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import static padroes.Tipo.cliente;
import sun.rmi.server.Dispatcher;

/**
 *
 * @author jean
 */
public class ControladorCliente extends HttpServlet {

    private final Fabrica fabrica = Fabrica.make(cliente);
    private InterfaceControlar api;
    protected Item item = fabrica.criaObjeto();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("operacao").equals("controle")){
            cadastrar(request, response);
            geraTabelaClientes(response);
        }else if(request.getParameter("operacao").equals("cadastro")){
//            RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroClientes.jsp");
//            dispatcher.forward(request, response);
              
        }
        
        excluir(request);
    }
    private void menu(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter pw = response.getWriter();
        TelaControleClientes tela = new TelaControleClientes();
        tela.inicioHtml(response);
        tela.montahead(pw, "Controle De Registro de clientes");
        tela.inicioBody(pw);
        
        tela.abreFormulario(pw, "Controlador","");
        tela.criaCampoOculto(pw,"tipo","cliente");
        tela.criaCampoOculto(pw,"operacao","cadastro");
        tela.criaBotao(pw, "Clientes","bg-white radius campo");
        tela.fechaFormulario(pw);
        
        tela.abreFormulario(pw, "Controlador","");
        tela.criaCampoOculto(pw,"tipo","cliente");
        tela.criaBotao(pw, "Clientes","bg-white radius campo");
        tela.fechaFormulario(pw);
        
        tela.montarodape(pw);
        tela.fimBody(pw);
        tela.fimHtml(pw);
    }

    private void geraTabelaClientes(HttpServletResponse response) throws IOException {

        TelaControleClientes tela = new TelaControleClientes();
        item = fabrica.criaObjeto();
        Dao dao = fabrica.criaDao();
        PrintWriter pw = response.getWriter();
        tela.inicioHtml(response);
        tela.montahead(pw, "Controle De Registro de clientes");
        tela.inicioBody(pw);
        tela.montamenu(pw);
        tela.montacampos(pw, "Controle De Registro de Clientes","controle");
        tela.topoTabela(pw, "Tabela de clientes");
        
        tela.titulosTabela(pw,Arrays.asList(getAtributos()));
        tela.inicioConteudo(pw);
        for (Item i : dao.listar()) {
            Cliente cli = (Cliente) i;
            tela.abreLinha(pw);
            tela.abreFormulario(pw, "Controlador","");
            tela.criaCampoTabela(pw, cli.getCpf());
            tela.criaCampoTabela(pw, cli.getMatricula());
            tela.criaCampoTabela(pw, cli.getNome());
            tela.criaCampoTabela(pw, "" + cli.getIdade());
            tela.criaCampoTabela(pw, cli.getEmail());
            tela.fechaFormulario(pw);
            tela.fechaLinha(pw);
        }
        tela.finalConteudo(pw);
        tela.abreFormulario(pw, "Controlador","");
        tela.criaCampo(pw, "cpf", "Digite o cpf do cliente","campo1");
        tela.criaBotao(pw, "Excluir","campo1");
        tela.fechaFormulario(pw);
        tela.montarodape(pw);
        tela.fimBody(pw);
        tela.fimHtml(pw);
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        item = fabrica.criaObjeto();
        if (TelaAbstract.valida(request, item.getAtributos())) {
            if (request.getParameter("operacao").equals("cadastro")) {
                api = fabrica.criaApi();
                item = getItem(request);
                api.cadastrar(item);
            }
        }
    }

    private void excluir(HttpServletRequest request) throws IOException {
        if(request.getParameter("operacao").equals("exclusao")){
            api = fabrica.criaApi();
            item = getItem(request);
            api.excluir(item);
        }
    }

    private boolean autentica(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        TelaAbstract.alert("Esse usuario não existe!!!", response.getWriter());
        Cliente item1 = (Cliente) item;
        api = fabrica.criaApi();
        item1.setCpf(request.getParameter("cpf"));
        item1.setSenha(request.getParameter("senha"));
        return api.existe(item);
    }


    private Item getItem(HttpServletRequest request) {
        Cliente item1 = (Cliente) fabrica.criaObjeto();
        item1.setCpf(request.getParameter("cpf"));
        item1.setNome(request.getParameter("nome"));
        item1.setIdade(request.getParameter("idade"));
        item1.setEmail(request.getParameter("email"));
        item1.setSenha(request.getParameter("senha"));
        return item1;
    }
    public String[] getAtributos(){
        String vetor[] = {"cpf","matricula","nome","idade","email"};
        return vetor;
    }
}
