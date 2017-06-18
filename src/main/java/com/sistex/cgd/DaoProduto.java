/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Item;
import com.sistex.cdp.Produto;
import java.util.ArrayList;
import java.util.List;
import padroes.Fabrica;
import static padroes.Tipo.produto;

/**
 *
 * @author jean
 */
public class DaoProduto implements Dao{
    Fabrica f = Fabrica.make(produto);
    private final Persistencia conexao = f.criaPersistencia();
    
    @Override
    public boolean cadastrar(Item item1) {
        Produto item = (Produto) item1;
        String comando = "INSERT INTO PRODUTO(codigo, nome, descricao, preco, marca, quantidade) VALUES("+",'"+item.getNome()+"','"+item.getDescricao()+"',"+item.getPreco()+",'"+item.getMarca()+"',"+item.getQuantidade()+")";
        Persistencia instance = f.criaPersistencia();
        return instance.executar(comando);
    }

    @Override
    public boolean excluir(Item item) {
        String comando = "DELETE FROM PRODUTO WHERE codigo=";
        Persistencia instance = f.criaPersistencia();
        return instance.executar(comando);
    }

    @Override
    public List<Item> listar() {
        Persistencia p = f.criaPersistencia();
        String vetor[] = p.getValores("SELECT *FROM PRODUTO").split(";");
        Produto prod;
        List<Item> lista = new ArrayList<>();
        for(String str:vetor){
            String dado[] = str.split(",");
            prod = new Produto();
//            prod.setCodigo(dado[0]);
            prod.setNome(dado[1]);
            prod.setDescricao(dado[2]);
            prod.setPreco(dado[3]);
            prod.setMarca(dado[4]);
            prod.setQuantidade(dado[5]);
            lista.add(prod);
        }
        return lista;
    }

    @Override
    public boolean existe(Item item) {
        return true;
    }

    @Override
    public boolean existe(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Item> listarVinculo(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public Item getItem(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluirAll() {
        return conexao.executar("Delete FROM PRODUTO") && conexao.executar("ALTER SEQUENCE produto_codigo_seq RESTART WITH 1;");
    }
    
}
