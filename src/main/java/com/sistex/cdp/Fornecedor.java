/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cdp;

import java.util.Objects;

/**
 *
 * @author jean
 */
public class Fornecedor extends ItemAbstract{
    private String nome="Fulano", cnpj="1234123412", telefone="12312",endereco="teste", email="teste@gmail.com";
    
    public Fornecedor() {
        super("fornecedor");
    }
    
    
    
    @Override
    public String toString(){
        return cnpj+" "+nome+" "+telefone+" "+endereco+" "+ email;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public boolean equals(Object o){
        Fornecedor fornecedor = (Fornecedor) o;
        return cnpj.equals(fornecedor.getCnpj())&& 
                nome.equals(fornecedor.getNome()) && 
                endereco.equals(fornecedor.getEndereco()) && 
                telefone.equals(fornecedor.getTelefone());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.cnpj);
        hash = 79 * hash + Objects.hashCode(this.telefone);
        hash = 79 * hash + Objects.hashCode(this.endereco);
        return hash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
