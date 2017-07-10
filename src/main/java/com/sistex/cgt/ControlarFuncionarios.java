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
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;
import static padroes.Tipo.funcionario;

/**
 *
 * @author jean
 */
public class ControlarFuncionarios extends Controlar {

    public ControlarFuncionarios() {
        fabrica = Fabrica.make("funcionario");
        dao = fabrica.criaDaoFuncionario();

    }

    @Override
    public boolean cadastrar(Funcionario funcionario) {
        try {
            if (!valida(funcionario)) {
                return false;
            }
            if (!dao.existe(funcionario)) {
                return dao.cadastrar(funcionario);
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean excluir(Funcionario funcionario) {
        try {
            if (!valida(funcionario)) {
                return false;
            }
            if (dao.existe(funcionario)) {
                return dao.excluir(funcionario);
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean autenticar(Funcionario funcionario) {
        try {
            return dao.autentica(funcionario);
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Funcionario buscar(Funcionario funcionario) {
        try {
            Funcionario f = (Funcionario) dao.buscar(funcionario.getMatricula());
            return f;
        } catch (Exception e) {
            return new Funcionario();
        }

    }

    @Override
    public boolean valida(Funcionario funcionario) {
        try {
            boolean result = funcionario.getMatricula().equals("null");
            result = result || funcionario.getNome().equals("null");
            result = result || funcionario.getRg().equals("null");
            result = result || funcionario.getSenha().equals("null");
            return result;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<Funcionario> listarFuncionarios() {
        try {
            return dao.listarFuncionarios();
        } catch (Exception e) {
            return new ArrayList();
        }

    }

    @Override
    public boolean existe(Funcionario funcionario) {
        try {
            return dao.existe(funcionario);
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean existe(String codigo) {
        try {
            return dao.existe(codigo);
        } catch (Exception e) {
            return false;
        }

    }
}
