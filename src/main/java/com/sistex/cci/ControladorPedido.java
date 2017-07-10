/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Cliente;
import com.sistex.cdp.Pedido;
import com.sistex.cdp.Produto;
import com.sistex.cgt.ControlarClientes;
import com.sistex.cgt.ControlarPedidos;
import com.sistex.cgt.ControlarProdutos;
import com.sistex.cih.FiguraPedido;
import com.sistex.cih.Tela;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import padroes.Fabrica;
import static padroes.Tipo.cliente;
import static padroes.Tipo.pedido;
import static padroes.Tipo.produto;
import util.Ferramenta;

/**
 *
 * @author jean
 */
public class ControladorPedido extends HttpServlet {

    private final Fabrica fabrica_pedido = Fabrica.make(pedido);
    private final ControlarPedidos api_pedido = fabrica_pedido.criaApiPedido();
    private final Fabrica fabrica_cliente = Fabrica.make(cliente);
    private final Fabrica fabrica_produto = Fabrica.make(produto);
    private final ControlarProdutos api_produto = fabrica_produto.criaApiProduto();
    private final ControlarClientes api_cliente = fabrica_cliente.criaApiCliente();
    private final Tela tela = fabrica_pedido.criaTela();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Ferramenta.fechaSessao(request, response);
        listar(request, response);
        cadastrar(request, response);
        excluir(request, response);
    }

    private String geraTabela(List<Pedido> pedidos) {
        String tags = "";
        for (Pedido pedido : pedidos) {
            Produto produto = api_produto.buscar(pedido.getCodigo_produto());
            tags += "<tr>"
                    + "<th>" + pedido.getCodigo_pedido() + "</th>"
                    + "<th>" + produto.getNome() + "</th>"
                    + "<th>" + produto.getPreco() + "</th>"
                    + "</tr>";
        }
        return tags;
    }

    public void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (tela.getInfo(request,"operacao").equals("cadastro")) {
            if (tela.usuarioEstaLogado("usuario", request)) {
                String[] codigo_produtos = request.getParameterValues("tipo1");
                String cpf = tela.getInfo(request,"cpf");
                api_pedido.cadastrar(Arrays.asList(codigo_produtos), cpf);
                List<Pedido> pedidos = api_pedido.listarPedidos(cpf);
                float preco_total = api_cliente.getPrecoTotal(cpf);
                String tabela_resultados = geraTabela(pedidos);
                Cliente cliente = api_cliente.buscar(cpf);
                tela.setSessaoAtributo(request, "confirmacao_nome_cliente", cliente.getNome());
                tela.setSessaoAtributo(request, "resultado_pedidos", tabela_resultados);
                tela.setSessaoAtributo(request, "confirmacao_cpf_cliente", cpf);
                tela.setSessaoAtributo(request, "preco_total", preco_total);
                tela.enviaMensagem(response, "telaConfirmacaoPedido.jsp");
            }else{
                tela.setSessaoAtributo(request, "mensagem_pesquisa_produtos", "Precisa se autenticar!!!");
                tela.enviaMensagem(response, "index.jsp");
            }

        }
    }
    
    
    public void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (tela.getInfo(request,"operacao").equals("exclusao")) {
            String codigo_pedido = tela.getInfo(request, "codigo_pedido");
            Pedido pedido = (Pedido) api_pedido.buscar(codigo_pedido);
            if (api_pedido.excluir(pedido)) {
                listar(request, response);
                tela.setSessaoAtributo(request, "mensagem_exclusao_pedido", "Pedido foi excluido com sucesso!!!");
                tela.enviaMensagem(response, "controlePedidos.jsp");
            }else{
                tela.setSessaoAtributo(request, "mensagem_exclusao_pedido", "Pedido nao foi excluido");
                tela.enviaMensagem(response, "restrito/controlePedidos.jsp");
            }
        }
    }
//codigo_pedido, nome_produto, preco, status
    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (tela.getInfo(request,"operacao").equals("listar")) {
            String nome_produto  = tela.getInfo(request, "nome");
            List<Pedido> pedidos = api_pedido.listarPedidosNome(nome_produto);
            List<FiguraPedido> figuras = new ArrayList();
            
            for(Pedido pedido:pedidos){
                Produto produto = api_produto.buscar(pedido.getCodigo_produto());
                String info = pedido.getCodigo_pedido()+","+ produto.getNome()+","+pedido.getPreco()+","+pedido.getStatus();
                FiguraPedido figura = new FiguraPedido(info);
                figuras.add(figura);
            }
            tela.setSessaoAtributo(request, "figuras_pedidos", tela.desenhaTelaFigurasPedido(figuras));
            tela.enviaMensagem(response, "restrito/controlePedidos.jsp");
        }
    }
    public void alterar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(tela.getInfo(request, "operacao").equals("alteracao")){
            String codigo_pedido = tela.getInfo(request, "codigo_pedido");
            PrintWriter pw = response.getWriter();
            pw.println("teste aleracao codigo pedido: "+codigo_pedido);
        }
    }
    
    public Pedido getItem(HttpServletRequest request) {
        Pedido pedido = fabrica_pedido.criaPedido();
        pedido.setDescricao(tela.getInfo(request,"descricao"));
        pedido.setPreco(tela.getInfo(request,"preco"));

        return pedido;
    }
}
