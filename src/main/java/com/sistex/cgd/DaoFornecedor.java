/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;

/**
 * 1q
 *
 * @author jean
 */
public class DaoFornecedor extends DaoAbstract {

    private final Fabrica fabrica = Fabrica.make("fornecedor");
    private final Persistencia persistencia = fabrica.criaPersistencia();

    @Override
    public boolean cadastrar(Fornecedor fornecedor) {
        return persistencia.executar("insert into fornecedor(nome, cnpj, telefone, endereco) values('" + fornecedor.getNome() + "','" + fornecedor.getCnpj() + "','" + fornecedor.getTelefone() + "','" + fornecedor.getEndereco() + "')");
    }

    @Override
    public boolean alterar(Fornecedor fornecedor) {
        return persistencia.executar("update fornecedor set nome='" + fornecedor.getNome() + "', telefone = '" + fornecedor.getTelefone() + "', endereco = '" + fornecedor.getEndereco() + "' where cnpj='" + fornecedor.getCnpj() + "'");
    }

    @Override
    public Fornecedor buscar(String cnpj) {
        String[] result = persistencia.select("select *from fornecedor where cnpj='" + cnpj + "'", "cnpj, endereco, nome, telefone").split(";");
        Fornecedor fornecedor = fabrica.criaFornecedor();
        for (String linha : result) {
            String[] campo = linha.split(",");
            if (campo.length == 4) {
                fornecedor.setCnpj(campo[0]);
                fornecedor.setEndereco(campo[1]);
                fornecedor.setNome(campo[2]);
                fornecedor.setTelefone(campo[3]);
                return fornecedor;
            }

        }
        return null;

    }

    @Override
    public boolean excluir(Fornecedor fornecedor) {
        return persistencia.executar("delete from fornecedor where cnpj='" + fornecedor.getCnpj() + "'");
    }

    @Override
    public boolean excluirTodos() {
        return persistencia.executar("Delete FROM fornecedor");
    }

    @Override
    public boolean existe(Fornecedor fornecedor) {
        String[] result = persistencia.select("select *from fornecedor where cnpj='" + fornecedor.getCnpj() + "'", "cnpj").split(";");
        for (String linha : result) {
            return linha.equals(fornecedor.getCnpj());
        }
        return false;
    }

    @Override
    public List<Fornecedor> listarFornecedores() {
        String[] result = persistencia.select("select *from fornecedor", "cnpj, endereco, nome, telefone").split(";");
        List<Fornecedor> lista = new ArrayList();
        for (String linha : result) {
            
            String[] campo = linha.split(",");
            if (campo.length == 4) {
                Fornecedor fornecedor = fabrica.criaFornecedor();
                fornecedor.setCnpj(campo[0]);
                fornecedor.setEndereco(campo[1]);
                fornecedor.setNome(campo[2]);
                fornecedor.setTelefone(campo[3]);
                lista.add(fornecedor);
            }
        }
        return lista;
    }

    @Override
    public List<Fornecedor> listarFornecedores(String nome) {
        String[] result = persistencia.select("select *from fornecedor where UPPER(nome) like UPPER('%" + nome + "%')", "cnpj, endereco, nome, telefone").split(";");
        List<Fornecedor> lista = new ArrayList();
        for (String linha : result) {

            String[] campo = linha.split(",");
            if (campo.length == 4) {
                Fornecedor fornecedor = fabrica.criaFornecedor();
                fornecedor.setCnpj(campo[0]);
                fornecedor.setEndereco(campo[1]);
                fornecedor.setNome(campo[2]);
                fornecedor.setTelefone(campo[3]);
                lista.add(fornecedor);
            }

        }
        return lista;
    }

    @Override
    public boolean existe(String cnpj) {
        String[] result = persistencia.select("select cnpj from fornecedor where cnpj= '" + cnpj + "'", "cnpj").split(";");
        for (String linha : result) {
            if (linha.equals(cnpj)) {
                return true;
            }
        }
        return false;
    }

}
