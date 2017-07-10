/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.sistex.cdp.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jean
 */
public class Produtos {
    private List<Produto1> produtos = new ArrayList();
    class Produto1{
        private String nome;
        private String descricao;
        private String imagem;

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
         * @return the descricao
         */
        public String getDescricao() {
            return descricao;
        }

        /**
         * @param descricao the descricao to set
         */
        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        /**
         * @return the imagem
         */
        public String getImagem() {
            return imagem;
        }

        /**
         * @param imagem the imagem to set
         */
        public void setImagem(String imagem) {
            this.imagem = imagem;
        }
        
        public String toString(){
            return descricao+" "+imagem;
        }
        
    }
   
    
     /**
     * @param produtos
     * @return the produtos
     */
    
    public void setProdutos(List<Produto> produtos) {
        for(Produto prodItem:produtos){
            Produto1 produto1 = new Produto1();
            Produto produto = (Produto) prodItem;
            produto1.nome = produto.getNome();
            produto1.imagem = produto.getTipoImagem();
            this.produtos.add(produto1);
        }
    }
}
