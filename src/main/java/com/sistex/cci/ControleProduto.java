/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Cliente;
import com.sistex.cdp.Item;
import com.sistex.cdp.Produto;
import com.sistex.cgd.Dao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import padroes.Fabrica;
import padroes.Tipo;
import com.sistex.cgt.InterfaceControlar;
import com.sistex.cih.TelaAbstract;
import com.sistex.cih.TelaControleClientes;
import com.sistex.cih.TelaControleProdutos;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author jean
 */
@WebServlet(name = "CadastroProduto", urlPatterns = {"/CadastroProduto"})
public class ControleProduto extends HttpServlet {
    private final Fabrica fabrica = Fabrica.make(Tipo.produto);
    private InterfaceControlar api;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            cadastrar(request, response);
            excluir(request, response);
            listar(request, response);
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
                
                
                
            }
        }
    }
    
    public Item getItem(HttpServletRequest request) {
        Produto item = (Produto) fabrica.criaObjeto();
        item.setCodigo(request.getParameter("codigo"));
        item.setNome(request.getParameter("nome"));
        item.setDescricao(request.getParameter("descricao"));
        item.setPreco(request.getParameter("preco"));
        item.setMarca(request.getParameter("marca"));
        item.setQuantidade(request.getParameter("quantidade"));
        
        
        return item;
    }
    
    private void geraTabelaProdutos(HttpServletResponse response) throws IOException {

        TelaControleProdutos tela = new TelaControleProdutos();
        Item item = fabrica.criaObjeto();
        Dao dao = fabrica.criaDao();
        PrintWriter pw = response.getWriter();
        tela.inicioHtml(response);
        tela.montahead(pw, "Controle de produtos");
        tela.inicioBody(pw);
        tela.montamenu(pw);
        tela.montacampos(pw, "Cadastro De Produtos","controle");
        tela.topoTabela(pw, "Tabela De Produtos");
        
        tela.titulosTabela(pw,Arrays.asList(item.getAtributos()));
        tela.inicioConteudo(pw);
        for (Item i : dao.listar()) {
            Produto prod = (Produto) i;
            tela.abreLinha(pw);
            tela.abreFormulario(pw, "Controlador","");
            tela.criaCampoTabela(pw, prod.getCodigo());
            tela.criaCampoTabela(pw, prod.getCnpj());
            tela.criaCampoTabela(pw, prod.getMatricula());
            tela.criaCampoTabela(pw, prod.getNome());
            tela.criaCampoTabela(pw, prod.getDescricao());
            tela.criaCampoTabela(pw,""+ prod.getPreco());
            tela.criaCampoTabela(pw, prod.getMarca());
            tela.criaCampoTabela(pw,""+ prod.getQuantidade());
            tela.fechaFormulario(pw);
            tela.fechaLinha(pw);
        }
        tela.finalConteudo(pw);
        tela.montarodape(pw);
        tela.fimBody(pw);
        tela.fimHtml(pw);
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Item item = fabrica.criaObjeto();
        if (TelaAbstract.valida(request, item.getAtributos())) {
            if (request.getParameter("operacao").equals("cadastro")) {
                api = fabrica.criaApi();
                item = getItem(request);
                api.cadastrar(item);
            }
        }
    }
}
