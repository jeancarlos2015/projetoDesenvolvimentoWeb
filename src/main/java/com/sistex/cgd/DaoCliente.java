/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Cliente;
import com.sistex.cdp.Item;
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;
import static padroes.Tipo.cliente;

/**
 *
 * @author jean
 */
public class DaoCliente implements Dao{
    Fabrica f = Fabrica.make(cliente);
    private final Persistencia conexao = f.criaPersistencia();
    
    @Override
    public boolean cadastrar(Item cliente) {
        Cliente item = (Cliente) cliente;
        return conexao.executar("INSERT INTO CLIENTE(cpf, matricula, nome, idade, email, senha) " +
        "VALUES('"+item.getCpf()+"','"+item.getMatricula()+"','"+item.getNome()+"',"+item.getIdade()+",'"+item.getEmail()+"','"+item.getSenha()+"')");
    }

    @Override
    public boolean excluir(Item cliente) {
        Cliente item = (Cliente) cliente;
        return conexao.executar("Delete FROM CLIENTE WHERE cpf='"+item.getCpf()+"'");
    }

    @Override
    public List listar() {
        String[] result = conexao.getValores("SELECT *FROM CLIENTE").split(";");
       List<Item> lista = new ArrayList<>();
       for(String linha:result){
           String[] campo = linha.split(",");
           Cliente cliente = (Cliente) f.criaObjeto();
           cliente.setCpf(campo[0]);
           cliente.setMatricula(campo[1]);
           cliente.setNome(campo[2]);
           cliente.setIdade(campo[3]);
           cliente.setEmail(campo[4]);
           cliente.setSenha(campo[5]);
           lista.add(cliente);
       }
       return lista;
        
    }

    @Override
    public boolean existe(Item cliente) {
        Cliente item = (Cliente) cliente;
       String info[] = conexao.getValores("SELECT cpf,senha FROM cliente WHERE cpf='"+item.getCpf()+"' and senha='"+item.getSenha()+"'").split(";");
        for(String str:info){
            String[] dado = str.split(",");
            String cpf = dado[0];
            String senha = dado[1];
            if(cpf.equals(item.getCpf()) && senha.equals(item.getSenha())){
                return true;
            }
        }
       return false;
    }

    @Override
    public boolean existe(String codigo) {
        String[] info = conexao.getValores("SELECT cpf FROM cliente WHERE cpf='"+codigo+"'").split(";");
        boolean achou=false;
        for(String str:info){
            if(str.equals(codigo)){
                achou=true;
            }
        }
        return achou;
    }

    @Override
    public List<Item> listarVinculo(Item item) {
        return null;
    }

   

    @Override
    public Item getItem(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluirAll() {
        return conexao.executar("Delete FROM CLIENTE") && conexao.executar("ALTER SEQUENCE cliente_codigo_seq RESTART WITH 1;");
    }
    
}
