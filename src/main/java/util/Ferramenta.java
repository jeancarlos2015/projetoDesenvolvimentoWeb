/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Random;

/**
 *
 * @author jean
 */
public class Ferramenta {
    private Random aleatorio;

    public Ferramenta() {
        aleatorio = new Random();
    }
    public String getcpf(){
        String cpf ="";
        for(int num=0;num<11;num++){
            cpf+=aleatorio.nextInt(9);
        }
        return cpf;
    }
    
    private String[] getNomes(){
        String vetor[]={"Rafael Delano","Pedro Albuquerque","Jose Oliveira",
        "Amanda Oliguedes", "Santiago De La", "Thiago De Sam","Joana Sanatos"};
        return vetor;
    }
    
    
    
    public String getNome(){
        String[] nomes = getNomes();
        int index=aleatorio.nextInt(nomes.length-1);
        return nomes[index];
    }
    public int getIdade(){
        return aleatorio.nextInt(80);
    }
    
}
