/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Cliente;
import com.sistex.cgd.Dao;
import com.sistex.cgt.ControlarClientes;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import padroes.Fabrica;
import com.sistex.cih.Tela;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import static padroes.Tipo.cliente;
import util.Ferramenta;

/**
 *
 * @author jean
 */
public class ControladorCliente extends HttpServlet {

    private final Fabrica fabrica = Fabrica.make(cliente);
    private final ControlarClientes api = fabrica.criaApiCliente();
    Tela tela = new Tela();
    protected Dao dao = fabrica.criaDaoCliente();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Ferramenta.fechaSessao(request, response);
        cadastrar(request, response);
        autentica(request, response);
        atualizar(request, response);
        excluir(request, response);
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if (tela.getInfo(request,"operacao").equals("cadastro")) {
            Cliente cliente = getItem(request);
            if (api.cadastrar(cliente)) {
                tela.setSessaoAtributo(request, "usuario", cliente.getNome());
                tela.setSessaoAtributo(request, "cpf", cliente.getCpf());
                tela.setSessaoAtributo(request, "nome", cliente.getNome());
                tela.setSessaoAtributo(request, "matricula", cliente.getMatricula());
                tela.setSessaoAtributo(request, "idade", cliente.getIdade());
                tela.setSessaoAtributo(request, "email", cliente.getEmail());
                tela.setSessaoAtributo(request, "senha", cliente.getSenha());
                tela.enviaMensagem(response, "restrito/telaConfirmacaoCadastro.jsp");
                
            } else {
                tela.setSessaoAtributo(request, "mensagem_cliente", "Cliente nao foi cadastrado!!!");
                tela.enviaMensagem(response, "cadastroClientes.jsp");
            }
        }
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (tela.getInfo(request,"operacao").equals("exclusao")) {
            Cliente cliente = getItem(request);
            if(api.excluir(cliente)){
                tela.setSessaoAtributo(request, "mensagem_exclusao", "Cliente excluido com sucesso!!!");
            }else{
                tela.setSessaoAtributo(request, "mensagem_exclusao", "Cliente nao excluido com sucesso!!!");
            }
            tela.enviaMensagem(response,"controleClientes.jsp");
        }
    }

    public void atualizar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (tela.getInfo(request,"operacao").equals("atualizar")) {
            Cliente cliente = getItem(request);
            if (api.alterar(cliente)) {
                tela.setSessaoAtributo(request,"mensagem_alteracao", "Dados alterados com sucesso!!!");
            }else{
                tela.setSessaoAtributo(request,"mensagem_alteracao", "Dados nao foram alterados!!!");
            }
            tela.enviaMensagem(response, "restrito/alterarDadoCliente.jsp");
        }

    }

    private void autentica(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String operacao = tela.getInfo(request,"operacao");
        if (operacao.equals("autenticacao")) {
            Cliente cliente = fabrica.criaCliente();
            cliente.setCpf(tela.getInfo(request,"cpf"));
            cliente.setSenha(tela.getInfo(request,"senha"));

            if (api.autenticar(cliente)) {
                Cliente novo = api.buscar(cliente);
                tela.setSessaoAtributo(request, "usuario", novo.getNome() + " Logado");
                tela.setSessaoAtributo(request,"valor_matricula", novo.getMatricula());
                tela.setSessaoAtributo(request,"titulo", novo.getNome());
                tela.setSessaoAtributo(request,"valor_nome", novo.getNome());
                tela.setSessaoAtributo(request,"valor_idade", novo.getIdade());
                tela.setSessaoAtributo(request,"valor_cpf", novo.getCpf());
                tela.setSessaoAtributo(request,"valor_email", novo.getEmail());
                tela.enviaMensagem(response,"restrito/contaCliente.jsp");
            } else {
                tela.setSessaoAtributo(request,"mensagem", "Usuário ou senha invalidos!!!");
                tela.setSessaoAtributo(request,"usuario", null);
                tela.enviaMensagem(response, "acesso.jsp");
            }

        }

    }

    private Cliente getItem(HttpServletRequest request) {
        Cliente cliente1 = fabrica.criaCliente();
        cliente1.setCpf(tela.getInfo(request,"cpf"));
        cliente1.setNome(tela.getInfo(request,"nome"));
        cliente1.setIdade(tela.getInfo(request,"idade"));
        cliente1.setEmail(tela.getInfo(request,"email"));
        cliente1.setSenha(tela.getInfo(request,"senha"));
        cliente1.setMatricula(tela.getInfo(request,"matricula"));
        return cliente1;
    }

    public String[] getAtributos() {
        String vetor[] = {"cpf", "matricula", "nome", "idade", "email"};
        return vetor;
    }
}
