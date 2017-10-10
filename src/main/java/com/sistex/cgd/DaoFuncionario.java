/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Funcionario;
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;
import static padroes.Tipo.funcionario;

/**
 *
 * @author jean
 */
public class DaoFuncionario extends DaoAbstract {

    Fabrica fabrica = Fabrica.make(funcionario);
    private final Persistencia persistencia = fabrica.criaPersistencia();

    @Override
    public boolean cadastrar(Funcionario funcionario) {
        return persistencia.executar("INSERT INTO FUNCIONARIO (matricula,rg, nome,senha) VALUES('" + funcionario.getMatricula() + "','" + funcionario.getRg() + "','" + funcionario.getNome() + "','" + funcionario.getSenha() + "')");
    }

    public Funcionario buscar(Funcionario funcionario) {
        String[] result = persistencia.select("select *from funcionario where matricula = '" + funcionario.getMatricula() + "'", "matricula, rg, nome, senha").split(";");
        Funcionario func = fabrica.criaFuncionario();
        for (String str : result) {
            String[] dado = str.split(",");
            func.setMatricula(dado[0]);
            func.setRg(dado[1]);
            func.setNome(dado[2]);
            func.setSenha(dado[3]);
            return func;
        }
        return null;
    }

    @Override
    public boolean autentica(Funcionario funcionario) {
        String info[] = persistencia.select("SELECT matricula,senha FROM funcionario WHERE matricula='" + funcionario.getMatricula() + "' and senha='" + funcionario.getSenha() + "'", "matricula, senha").split(";");
        for (String str : info) {
            String[] dado = str.split(",");
            if (dado.length == 2) {
                String matricula = dado[0];
                String senha = dado[1];
                if (matricula.equals(funcionario.getMatricula()) && senha.equals(funcionario.getSenha())) {
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public Funcionario buscar(String matricula) {
        String[] result = persistencia.select("select *from funcionario where matricula = '" + matricula + "'", "matricula, rg, nome, senha").split(";");
        Funcionario func = fabrica.criaFuncionario();
        for (String str : result) {
            String[] dado = str.split(",");
            func.setMatricula(dado[0]);
            func.setRg(dado[1]);
            func.setNome(dado[2]);
            func.setSenha(dado[3]);
            return func;
        }
        return null;
    }

    @Override
    public boolean excluir(Funcionario funcionario) {
        return persistencia.executar("DELETE FROM FUNCIONARIO WHERE matricula = '" + funcionario.getMatricula() + "'");
    }

    @Override
    public List<Funcionario> listarFuncionarios() {
        String[] result = persistencia.select("SELECT *FROM FUNCIONARIO", "matricula, rg, nome, senha").split(";");
        List<Funcionario> lista = new ArrayList<>();
        for (String linha : result) {
            String[] campo = linha.split(",");
            Funcionario funcionario = fabrica.criaFuncionario();
            funcionario.setMatricula(campo[0]);
            funcionario.setRg(campo[1]);
            funcionario.setNome(campo[2]);
            funcionario.setSenha(campo[3]);
            lista.add(funcionario);
        }
        return lista;
    }
   
    @Override
    public boolean alterar(Funcionario funcionario){
        return persistencia.executar("update funcionario set rg='"+funcionario.getRg()+"', nome='"+funcionario.getNome()+"', senha = '"+funcionario.getSenha()+"' where matricula='"+funcionario.getMatricula()+"'");
    }
    @Override
    public boolean existe(Funcionario funcionario) {
        String[] result = persistencia.select("SELECT matricula, senha FROM FUNCIONARIO WHERE matricula = '" + funcionario.getMatricula() + "'", "matricula, senha").split(";");
        for (String str : result) {
            String[] dado = str.split(",");
            if (dado.length == 2) {
                String matricula = dado[0];
                String senha = dado[1];
                if (matricula.equals(funcionario.getMatricula()) && senha.equals(funcionario.getSenha())) {
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public boolean existe(String matricula) {
        String[] result = persistencia.select("SELECT matricula FROM FUNCIONARIO WHERE matricula = '" + matricula + "'", "matricula").split(";");
        for (String str : result) {
            if (str.equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean excluirTodos() {
        return persistencia.executar("Delete FROM FUNCIONARIO") && persistencia.executar("ALTER SEQUENCE funcionario_codigo_seq RESTART WITH 2;");
    }

}
