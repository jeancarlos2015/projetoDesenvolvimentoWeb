/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cci;

import com.sistex.cdp.Fornecedor;
import com.sistex.cdp.Funcionario;
import com.sistex.cdp.Produto;
import com.sistex.cgt.ControlarProdutos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import padroes.Fabrica;
import padroes.Tipo;
import com.sistex.cih.FiguraProduto;
import com.sistex.cih.Tela;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import static padroes.Tipo.fornecedor;
import static padroes.Tipo.funcionario;

/**
 *
 * @author jean
 */
@WebServlet(name = "CadastroProduto", urlPatterns = {"/CadastroProduto"})
public class ControladorProduto extends HttpServlet {

    private final Fabrica fabrica = Fabrica.make(Tipo.produto);
    private final Tela tela = fabrica.criaTela();
    private final ControlarProdutos api = fabrica.criaApiProduto();
    private final Fabrica fabricaFuncionario = Fabrica.make(funcionario);
    private final Fabrica fabricaFornecedor = Fabrica.make(fornecedor);
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        cadastrar(request, response);
        listar(request, response);

    }

    public void excluir(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (tela.getInfo(request,"operacao").equals("exclusao")) {
            Produto produto = getItem(request);
            if (api.excluir(produto)) {
                
            }
        }
    }
    
    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (tela.getInfo(request,"operacao").equals("listar")) {
            PrintWriter pw = response.getWriter();
            String nome = tela.getInfo(request,"nome");
            List<Produto> produtos = api.listarProdutosNome(nome);
            List<FiguraProduto> figuras = new ArrayList();
            for (Produto p : produtos) {
                pw.println(p.toFigura());
                FiguraProduto figura = new FiguraProduto(p.toFigura());
                figuras.add(figura);
            }
            tela.setSessaoAtributo(request,"figuras_produtos", tela.topaginas(figuras));
            if(produtos.size()>0){
                tela.setSessaoAtributo(request,"botao_pedido",tela.toBotao_pedido());
            }else{
                tela.setSessaoAtributo(request,"botao_pedido","");
            }
            tela.enviaMensagem(response, "index.jsp");
        }
    }

    public Produto getItem(HttpServletRequest request) {
        Produto produto = fabrica.criaProduto();
        produto.setNome(tela.getInfo(request,"nome"));
        produto.setDescricao(tela.getInfo(request,"descricao"));
        produto.setPreco(tela.getInfo(request,"preco"));
        produto.setMarca(tela.getInfo(request,"marca"));
        produto.setQuantidade(tela.getInfo(request,"quantidade"));
        Fornecedor fornecedor = fabricaFornecedor.criaFornecedor();
        Funcionario funcionario = fabricaFuncionario.criaFuncionario();
        funcionario.setMatricula(tela.getInfo(request,"matricula"));
        fornecedor.setCnpj(tela.getInfo(request,"cnpj"));
        return produto;
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (tela.getInfo(request,"operacao").equals("cadastro")) {
            Produto produto = getItem(request);
            HttpSession session = request.getSession();
            tela.setSessaoAtributo(request,"mensagem", null);
            if (!api.existe(produto)) {
                if (api.cadastrar(produto)) {
                    tela.setSessaoAtributo(request,"mensagem_produto", "Produto cadastrado com sucesso!!!");
                    response.sendRedirect("restrito/cadastroProdutos.jsp");
                } else {
                    tela.setSessaoAtributo(request,"mensagem_produto", "Houve um erro e o produto nao foi cadastrado");
                    response.sendRedirect("restrito/cadastroProdutos.jsp");
                }
            } else {
                tela.setSessaoAtributo(request,"mensagem_produto", "Esse produto ja existe!!!");
                response.sendRedirect("restrito/cadastroProdutos.jsp");
            }

        }
    }
}
