/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Cliente;
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;

/**
 *
 * @author jean
 */
public class ControlarClientes extends Controlar {

    public ControlarClientes() {
        fabrica = Fabrica.make("cliente");
        dao = fabrica.criaDaoCliente();
    }
    @Override
    public float getPrecoTotal(String cpf){
        try {
            return dao.getPrecoTotal(cpf);
        } catch (Exception e) {
            return 0;
        }
    }
    @Override
    public Cliente buscar(Cliente cliente) {
        try {
            return (Cliente) dao.buscar(cliente.getCpf());
        } catch (Exception e) {
            return new Cliente();
        }

    }
    
    @Override
    public Cliente buscar(String cpf){
        try {
            return (Cliente) dao.buscar(cpf);
        } catch (Exception e) {
            return new Cliente();
        }
    }
    @Override
    public boolean alterar(Cliente cliente){
        try {
            if(existe(cliente)){
                return dao.alterar(cliente);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public boolean cadastrar(Cliente cliente) {
        try {
            if (!dao.existe(cliente)) {
                if (dao.cadastrar(cliente)) {
                    msg("O cliente foi cadastrado com sucesso!!!");
                    return true;
                }
            }
            msg("O cliente ja esta cadastrado!!!");
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean excluir(Cliente cliente) {
        try {
            if (!valida(cliente)) {
                return false;
            }
            if (dao.existe(cliente)) {
                if (dao.excluir(cliente)) {
                    msg("Cliente excluido com sucesso!!!");
                    return true;
                }
                msg("Cliente nao foi excluido!!");
                return false;
            } else {
                msg("O cliente nao existe!!!");
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<Cliente> listarClientes() {
        try {
            return dao.listarClientes();
        } catch (Exception e) {
            return new ArrayList();
        }

    }

    @Override
    public boolean valida(Cliente cliente) {
        try {
            boolean result = cliente.getCpf().equals("null");
            result = result || cliente.getMatricula().equals("null");
            result = result || cliente.getNome().equals("null");
            result = result || cliente.getIdade() == 0;
            result = result || cliente.getEmail().equals("null");
            result = result || cliente.getSenha().equals("null");
            return result;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean autenticar(Cliente cliente) {
        try {
            return dao.autentica(cliente);
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean existe(Cliente cliente) {
        try {
            return dao.existe(cliente);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean existe(String codigo) {
        try {
            if (dao.existe(codigo)) {
                msg("Cliente existe!!!");
                return true;
            }
            msg("Cliente nao existe!!!");
            return false;
        } catch (Exception e) {
            return false;
        }

    }
}
