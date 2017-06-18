/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Cliente;
import com.sistex.cdp.Funcionario;
import com.sistex.cdp.Item;
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;
import static padroes.Tipo.funcionario;

/**
 *
 * @author jean
 */
public class DaoFuncionario implements Dao {
    Fabrica fabr = Fabrica.make(funcionario);
    private final Persistencia conexao = fabr.criaPersistencia();
    

    @Override
    public boolean cadastrar(Item item) {
        Funcionario f = (Funcionario) item;
        return conexao.executar("INSERT INTO FUNCIONARIO (matricula,rg, nome,senha) VALUES('"+f.getMatricula()+"','"+f.getRg()+"','"+f.getNome()+"','"+f.getSenha()+"')");
    }

    @Override
    public boolean excluir(Item item) {
        Funcionario f = (Funcionario) item;
        return conexao.executar("DELETE FROM FUNCIONARIO WHERE matricula = '"+f.getMatricula()+"'");
    }

    @Override
    public List<Item> listar() {
       String[] result = conexao.getValores("SELECT *FROM FUNCIONARIO").split(";");
       List<Item> lista = new ArrayList<>();
       for(String linha:result){
           String[] campo = linha.split(",");
           Funcionario funcionario = (Funcionario) fabr.criaObjeto();
           funcionario.setMatricula(campo[0]);
           funcionario.setRg(campo[1]);
           funcionario.setNome(campo[2]);
           funcionario.setSenha(campo[3]);
           lista.add(funcionario);
       }
       return lista;
    }

    @Override
    public boolean existe(Item item1) {
        Funcionario item = (Funcionario) item1;
        String[] result = conexao.getValores("SELECT matricula FROM FUNCIONARIO WHERE matricula = '"+item.getMatricula()+"'").split(";");
        for(String str:result){
            if(item.getMatricula().equals(str)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existe(String matricula) {
        String[] result = conexao.getValores("SELECT matricula FROM FUNCIONARIO WHERE matricula = '"+matricula+"'").split(";");
        for(String str:result){
            if(str.equals(matricula)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Item> listarVinculo(Item item) {
        Funcionario f = (Funcionario) item;
        String[] result = conexao.getValores("SELECT *FROM CLIENTE WHERE matricula_funcionario = '"+f.getMatricula()+"'").split(";");
        List<Item> list = new ArrayList<>();
        for(String str:result){
            String[] dado = str.split(",");
        }
        
        return list;
    }

   

    @Override
    public Item getItem(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluirAll() {
        return conexao.executar("Delete FROM FUNCIONARIO") && conexao.executar("ALTER SEQUENCE funcionario_codigo_seq RESTART WITH 2;");
    }
    
}
