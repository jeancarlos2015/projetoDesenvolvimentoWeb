/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Fornecedor;
import com.sistex.cgt.ControlarFornecedores;
import com.sistex.cih.Tela;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import padroes.Fabrica;
import util.Ferramenta;

/**
 *
 * @author jean
 */
@WebServlet(name = "ControladorFornecedor", urlPatterns = {"/ControladorFornecedor"})
public class ControladorFornecedor extends HttpServlet {

    private final Fabrica fabrica = Fabrica.make("fornecedor");
    private final ControlarFornecedores api = fabrica.criaApiFornecedor();
    private final Tela tela = fabrica.criaTela();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Ferramenta.fechaSessao(request, response);
        cadastrar(request, response);
        
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operacao = tela.getInfo(request,"operacao");
        if (operacao.equals("cadastro")) {
            String nome = tela.getInfo(request,"nome");
            String cnpj = tela.getInfo(request,"cnpj");
            String telefone = tela.getInfo(request,"telefone");
            String endereco = tela.getInfo(request,"endereco");
            if (api.existe(cnpj)) {
                tela.setSessaoAtributo(request,"mensagem_fornecedor", "Este fornecedor ja existe!!!");
                tela.enviaMensagem(response, "cadastroFornecedor.jsp");
            } else {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setNome(nome);
                fornecedor.setCnpj(cnpj);
                fornecedor.setTelefone(telefone);
                fornecedor.setEndereco(endereco);
                if (api.cadastrar(fornecedor)) {
                    tela.setSessaoAtributo(request,"mensagem_fornecedor", "Fornecedor cadastrado com sucesso!!!");
                    tela.enviaMensagem(response, "cadastroFornecedor");
                }
            }
        }

    }

}
