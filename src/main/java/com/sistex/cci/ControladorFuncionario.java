/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Funcionario;
import com.sistex.cgt.ControlarFuncionarios;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import padroes.Fabrica;
import com.sistex.cih.Tela;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpSession;
import util.Ferramenta;

/**
 *
 * @author jean
 */
public class ControladorFuncionario extends HttpServlet {

    private final Fabrica fabrica = Fabrica.make("funcionario");
    private final ControlarFuncionarios api = fabrica.criaApiFuncionario();
    private final Tela tela = fabrica.criaTela();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Ferramenta.fechaSessao(request, response);
        cadastrar(request, response);
        autenticar(request, response);
        excluir(request, response);
        listar(request, response);
    }

    public void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (tela.getInfo(request,"operacao").equals("cadastro")) {
            Funcionario funcionario = fabrica.criaFuncionario();
            funcionario.setNome(tela.getInfo(request,"nome"));
            funcionario.setDescricao(tela.getInfo(request,"rg"));
            funcionario.setMatricula(tela.getInfo(request,"matricula"));
            funcionario.setMatricula(tela.getInfo(request,"senha"));
            if (!api.existe(funcionario)) {
                if (api.cadastrar(getItem(request))) {
                    tela.setSessaoAtributo(request,"mensagem_funcionario", "Funcionario cadastrado com sucesso!!!");
                }
            } else {
                tela.setSessaoAtributo(request,"me    nsagem_funcionario", "Funcionario nao foi cadastratado!!!");
            }
            response.sendRedirect("restrito/cadastroFuncionarios.jsp");
        }
    }

    

    public void autenticar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (tela.getInfo(request,"operacao").equals("autenticacao")) {
            Funcionario funcionario = fabrica.criaFuncionario();
            funcionario.setMatricula(tela.getInfo(request,"cpf"));
            funcionario.setSenha(tela.getInfo(request,"senha"));
            if (api.autenticar(funcionario)) {
                Funcionario novo = api.buscar(funcionario);
                tela.setSessaoAtributo(request,"usuario", novo.getNome() + " Logado");
                tela.setSessaoAtributo(request,"titulo", novo.getNome());
                tela.enviaMensagem(response, "restrito/contaFuncionario.jsp");
            } else {
                tela.setSessaoAtributo(request,"mensagem", "Usuario ou senha invalidos!!!");
                tela.setSessaoAtributo(request,"usuario", null);
                tela.setSessaoAtributo(request,"titulo", null);
                tela.enviaMensagem(response, "acesso.jsp");
            }
        }
    }

    public void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (tela.getInfo(request,"operacao").equals("exclusao")) {
            Funcionario funcionario = getItem(request);
            if (api.excluir(funcionario)) {
                tela.setSessaoAtributo(request, "mensagem_exclusao_funcionario", "Funcionario foi excluido com sucesso!!");
            }else{
                tela.setSessaoAtributo(request, "mensagem_exclusao_funcionario", "Funcionario nao foi excluido com sucesso!!");
            }
            tela.enviaMensagem(response, "controleFuncionarios.jsp");
        }
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (tela.getInfo(request,"operacao").equals("listar")) {
            List<Funcionario> funcionarios = api.listarFuncionarios();
            PrintWriter pw = response.getWriter();
            pw.println(funcionarios.toString());
        }
    }

    public Funcionario getItem(HttpServletRequest request) {
        Funcionario item = fabrica.criaFuncionario();
        item.setNome(tela.getInfo(request,"rg"));
        item.setMatricula(tela.getInfo(request,"nome"));
        item.setSenha(tela.getInfo(request,"senha"));
        return item;
    }
}
