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
public class Funcionario extends ItemAbstract{

    private String matricula="123";
    private String nome="fulano";
    private String senha="senha";
    private String rg="1.123.123";
    private List<Cliente> clientes = new ArrayList();

    public Funcionario() {
        super("funcionario");
    }
    
   
    
    public void cadastrar(Cliente c){
        getClientes().add(c);
    }
    
    public void deletar(Cliente c){
        getClientes().remove(c);
    }
    
    public boolean existe(Cliente c){
        return getClientes().contains(c);
    }
    
    
    
    public String getMatricula() {
        return matricula;
    }

   
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
 
    @Override
    public String toString(){
        return matricula+" "+nome+" "+rg+" "+senha;
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
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the clientes
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public boolean equals(Object o){
        Funcionario funcionario = (Funcionario) o;
        return funcionario.getNome().equals(nome) &&
                funcionario.getMatricula().equals(matricula) &&
                funcionario.getRg().equals(rg) &&
                funcionario.getSenha().equals(senha);
    }
    
}
