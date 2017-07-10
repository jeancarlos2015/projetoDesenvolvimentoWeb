/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

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
public interface InterfaceControlar {
    
    public boolean cadastrar(Produto produto);
    public boolean cadastrar(Cliente cliente);
    public boolean cadastrar(Pedido pedido);
    public boolean cadastrar(Fornecedor fornecedor);
    public boolean cadastrar(Funcionario funcionario);
    public boolean cadastrar(List<String> codigo_produtos, String cpf);
    
    public boolean existe(Pedido pedido);
    public boolean existe(Produto produto);
    public boolean existe(Fornecedor fornecedor);
    public boolean existe(Funcionario funcionario);
    public boolean existe(Cliente cliente);
    public boolean existe(String codigo);
    
    public Cliente buscar(Cliente cliente);
    public Produto buscar(Produto produto);
    public Fornecedor buscar(Fornecedor fornecedor);
    public Pedido buscar(Pedido pedido);
    public Funcionario buscar(Funcionario funcionario);
    public Object buscar(String codigo);
    
    public float getPrecoTotal(String codigo);
    
    public boolean alterar(Pedido pedido);
    public boolean alterar(Produto produto);
    public boolean alterar(Fornecedor fornecedor);
    public boolean alterar(Cliente cliente);
    public boolean alterar(Funcionario funcionario);
    
    
    public boolean valida(Cliente cliente);
    public boolean valida(Produto produto);
    public boolean valida(Fornecedor fornecedor);
    public boolean valida(Pedido pedido);
    public boolean valida(Funcionario funcionario);
    
    public boolean excluir(Produto produto);
    public boolean excluir(Cliente cliente);
    public boolean excluir(Pedido pedido);
    public boolean excluir(Funcionario funcionario);
    public boolean excluir(Fornecedor fornecedor);
    
    
    public List<Produto> listarProdutos();
    public List<Cliente> listarClientes();
    public List<Pedido> listarPedidos();
    public List<Fornecedor> listarFornecedores();
    public List<Funcionario> listarFuncionarios();
    
    public List<Cliente> listarClientes(String matricula);
    public List<Pedido> listarPedidos(String cpf);
    public List<Fornecedor> listarFornecedores(String nomeproduto);
    public List<Pedido> listarPedidosNome(String nome_produto);
    
    public boolean autenticar(Cliente cliente);
    public boolean autenticar(Funcionario funcionario);
    public String msg();
    public void msg(String msg);
}
