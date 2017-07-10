/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Cliente;
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;
import static padroes.Tipo.cliente;

/**
 *
 * @author jean
 */
public class DaoCliente extends DaoAbstract {

    Fabrica fabrica = Fabrica.make(cliente);
    private final Persistencia persistencia = fabrica.criaPersistencia();

    @Override
    public boolean cadastrar(Cliente cliente) {
        return persistencia.executar("INSERT INTO CLIENTE(cpf, matricula, nome, idade, email, senha) "
                + "VALUES('" + cliente.getCpf() + "','" + cliente.getMatricula() + "','" + cliente.getNome() + "'," + cliente.getIdade() + ",'" + cliente.getEmail() + "','" + cliente.getSenha() + "')");
    }

    @Override
    public boolean excluir(Cliente cliente) {
        return persistencia.executar("Delete FROM CLIENTE WHERE cpf='" + cliente.getCpf() + "'");
    }

    @Override
    public List<Cliente> listarClientes() {
        String[] result = persistencia.select("SELECT *FROM CLIENTE", "cpf, matricula, nome,  idade, idade, email, senha").split(";");
        List<Cliente> lista = new ArrayList<>();
        for (String linha : result) {
            String[] campo = linha.split(",");
            if (campo.length == 7) {
                Cliente cliente = fabrica.criaCliente();
                cliente.setCpf(campo[0]);
                cliente.setMatricula(campo[1]);
                cliente.setNome(campo[2]);
                cliente.setIdade(campo[3]);
                cliente.setEmail(campo[4]);
                cliente.setSenha(campo[5]);
                lista.add(cliente);
            }

        }
        return lista;

    }

    @Override
    public List<Cliente> listarClientes(String cpf) {
        String[] result = persistencia.select("SELECT *FROM CLIENTE cpf = '" + cpf + "'", "cpf, matricula, nome,  idade, idade, email, senha").split(";");
        List<Cliente> lista = new ArrayList<>();
        for (String linha : result) {
            String[] campo = linha.split(",");
            if (campo.length == 7) {
                Cliente cliente = fabrica.criaCliente();
                cliente.setCpf(campo[0]);
                cliente.setMatricula(campo[1]);
                cliente.setNome(campo[2]);
                cliente.setIdade(campo[3]);
                cliente.setEmail(campo[4]);
                cliente.setSenha(campo[5]);
                lista.add(cliente);
            }

        }
        return lista;

    }
    @Override
    public boolean alterar(Cliente cliente){
        return persistencia.executar("update cliente set matricula='"+cliente.getCpf()+"', nome='"+cliente.getNome()+"', idade='"+cliente.getIdade()+"', email='"+cliente.getEmail()+"', senha='"+cliente.getSenha()+"' where cpf = '"+cliente.getCpf()+"'");
    }
    
    @Override
    public Cliente buscar(String cpf) {
        String[] result = persistencia.select("SELECT *FROM CLIENTE where cpf='" + cpf + "'", "cpf, matricula, nome,  idade, idade, email, senha").split(";");
        Cliente cliente = fabrica.criaCliente();
        for (String linha : result) {
            String[] campo = linha.split(",");
            cliente.setCpf(campo[0]);
            cliente.setMatricula(campo[1]);
            cliente.setNome(campo[2]);
            cliente.setIdade(campo[3]);
            cliente.setEmail(campo[4]);
            cliente.setSenha(campo[5]);
            return cliente;
        }
        return null;

    }
    @Override
    public float getPrecoTotal(String cpf){
        String[] result = persistencia.select("select sum(preco) as total from  produto as prod, pedido as ped where prod.codigo_produto = ped.codigo_produto and ped.cpf='"+cpf+"'", "total").split(";");
        float preco_total=0;
        for(String str:result){
            if(str!=null){
                preco_total = Float.parseFloat(str.trim());
            }
        }
        return preco_total;
    }
    @Override
    public boolean existe(Cliente cliente) {
        String info[] = persistencia.select("SELECT cpf FROM cliente WHERE cpf='" + cliente.getCpf()+"'", "cpf").split(";");
        for (String str : info) {
            if (str.trim().equals(cliente.getCpf())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean autentica(Cliente cliente) {
        String info[] = persistencia.select("SELECT cpf,senha FROM cliente WHERE cpf='" + cliente.getCpf() + "' and senha='" + cliente.getSenha() + "'", "cpf, senha").split(";");
        for (String str : info) {
            String[] dado = str.split(",");
            if (dado.length == 2) {
                String cpf = dado[0];
                String senha = dado[1];
                if (cpf.equals(cliente.getCpf()) && senha.equals(cliente.getSenha())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean existe(String cpf) {
        String[] info = persistencia.select("SELECT cpf FROM cliente WHERE cpf='" + cpf + "'", "cpf").split(";");
        boolean achou = false;
        for (String str : info) {
            if (str.equals(cpf)) {
                achou = true;
            }
        }
        return achou;
    }

    @Override
    public boolean excluirTodos() {
        return persistencia.executar("Delete FROM CLIENTE") && persistencia.executar("ALTER SEQUENCE cliente_codigo_seq RESTART WITH 1;");
    }

}
