/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Cliente;
import com.sistex.cdp.Fornecedor;
import com.sistex.cdp.Funcionario;
import com.sistex.cdp.Pedido;
import com.sistex.cdp.Produto;
import java.util.List;

/**
 *
 * @author jean
 */
public interface Dao {
    public boolean cadastrar(Produto produto);
    public boolean cadastrar(Cliente cliente);
    public boolean cadastrar(Fornecedor fornecedor);
    public boolean cadastrar(Funcionario funcionario);
    public boolean cadastrar(Pedido pedido);
    
    public boolean alterar(Produto produto);
    public boolean alterar(Pedido pedido);
    public boolean alterar(Cliente cliente);
    public boolean alterar(Fornecedor fornecedor);
    public boolean alterar(Funcionario funcionario);
    
    public Object buscar(String codigo);
    
    //codigo  = matricula || cpf || cnpj
    public float getPrecoTotal(String codigo);
    
    public boolean excluir(Produto produto);
    public boolean excluir(Cliente cliente);
    public boolean excluir(Funcionario funcionario);
    public boolean excluir(Fornecedor fornecedor);
    public boolean excluir(Pedido pedido);
    
    public boolean excluirTodos();
    
    public boolean existe(Produto produto);
    public boolean existe(Cliente cliente);
    public boolean existe(Funcionario funcionario);
    public boolean existe(Fornecedor fornecedor);
    public boolean existe(Pedido pedido);
    public boolean existe(String codigo);
    
    public boolean autentica(Cliente cliente);
    public boolean autentica(Funcionario funcionario);
    
    public List<Produto> listarProdutos();
    public List<Cliente> listarClientes();
    public List<Fornecedor> listarFornecedores();
    public List<Pedido> listarPedidos();
    public List<Funcionario> listarFuncionarios();
    
    public List<Produto> listarProdutos(String nome);    
    public List<Produto> listarProdutosNome(String nome);
    
    
    public List<Cliente> listarClientes(String matricula);
    public List<Fornecedor> listarFornecedores(String codigo_produtoOUnome);
    
    public List<Pedido> listarPedidos(String cpf);
    public List<Pedido> listarPedidosNome(String nome_produto);
    
    
    
    
}
