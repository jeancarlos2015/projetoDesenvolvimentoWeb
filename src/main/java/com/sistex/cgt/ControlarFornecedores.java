/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgt;

import com.sistex.cdp.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;

/**
 *
 * @author jean
 */
public class ControlarFornecedores extends Controlar {

    public ControlarFornecedores() {
        fabrica = Fabrica.make("fornecedor");
        dao = fabrica.criaDaoFornecedor();
    }

    @Override
    public boolean cadastrar(Fornecedor fornecedor) {
        try {
            if (!valida(fornecedor)) {
                return false;
            }
            if (!dao.existe(fornecedor)) {
                if (dao.cadastrar(fornecedor)) {
                    msg("O fornecedor foi cadastrado com sucesso!!!");
                    return true;
                }
            }
            msg("O fornecedor ja esta cadastrado!!!");
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean valida(Fornecedor fornecedor) {
        try {
            boolean result = fornecedor.getCnpj().equals("null");
            result = result || fornecedor.getEndereco().equals("null");
            result = result || fornecedor.getNome().equals("null");
            result = result | fornecedor.getTelefone().equals("null");
            return result;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean excluir(Fornecedor fornecedor) {
        try {
            if (!valida(fornecedor)) {
                return false;
            }
            if (dao.existe(fornecedor)) {
                if (dao.excluir(fornecedor)) {
                    msg("Fornecedor excluido com sucesso!!!");
                    return true;
                }
                msg("Fornecedor nao foi excluido!!");
                return false;
            } else {
                msg("O Fornecedor nao existe!!!");
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<Fornecedor> listarFornecedores() {
        try {
            return dao.listarFornecedores();
        } catch (Exception e) {
            return new ArrayList();
        }

    }

    @Override
    public boolean existe(Fornecedor fornecedor) {
        try {
            return dao.existe(fornecedor);
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean existe(String cnpj) {
        try {
            return dao.existe(cnpj);
        } catch (Exception e) {
            return false;
        }

    }

}
