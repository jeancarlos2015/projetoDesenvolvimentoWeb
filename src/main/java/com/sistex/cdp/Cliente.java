/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cdp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jean
 */
public class Cliente extends ItemAbstract{
    private String cpf="12312312312";
    private String nome="fulano";
    private int idade=0;
    private String email="fulano@servidor";
    private String senha="senha";
    private String matricula="0";
    public Cliente() {
        super("cliente");
        this.nome = "fulano";
    }
    
    public int getIdade() {
        return idade;
    }

    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public void setIdade(String idade) {
        this.setIdade(Integer.parseInt(idade.trim()));
    }
    
    
    public String getEmail() {
        return email;
    }


    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public  String[] getAtributos(){
        String vetor[] = {"cpf","matricula","nome","idade","email","senha"};
        return vetor;
    }
    
    
    @Override
    public String toString(){
        return getCpf()+" "+getMatricula()+" "+getNome()+" "+getIdade()+" "+getEmail()+" "+getSenha();
    }

    
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String parameter) {
       this.nome = parameter;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

   

  
        
}
