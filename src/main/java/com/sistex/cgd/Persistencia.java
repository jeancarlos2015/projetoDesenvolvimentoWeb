/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Cliente;
import com.sistex.cdp.Funcionario;
import com.sistex.cdp.Item;
import com.sistex.cdp.Pedido;
import com.sistex.cdp.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jean
 */
public class Persistencia {
    private String url="jdbc:postgresql://localhost:5432/bancoSistex", 
            usuario="postgres", senha="ifes";
    private Connection con;
    private Statement stm;
    private String driver = "org.postgresql.Driver";
    private ResultSet rs;
    public boolean executar(String comando) {
        try {

            Class.forName(driver);

            con = DriverManager.getConnection(url, usuario, senha);

            stm = con.createStatement();

            //stm.executeQuery(comando);  
            stm.executeUpdate(comando);
            //Editado 21/09/2011 para correção: executeQuery é usado para pesquisa, executeUpdate deve ser usado para inserir  
            con.close();

            return true;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
// 
//    public  String[] getValores(String comando, Item item){
//        try {
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, usuario, senha);
//            stm = con.createStatement(); 
//            rs = stm.executeQuery(comando);
//            String result="";
//            rs.next();
//            int index;
//            do {
//                for(index=0;index<item.getAtributos().length-1;index++){
//                    result +=rs.getString(item.getAtributos()[index])+",";
//                }
//                result+=rs.getString(item.getAtributos()[index])+";";
//            }while (rs.next());
//            rs.close();
//            stm.close();
//            
//            //Editado 21/09/2011 para correção: executeQuery é usado para pesquisa, executeUpdate deve ser usado para inserir  
//            con.close();
//            return result.split(";");
//        } catch (SQLException |ArrayIndexOutOfBoundsException | ClassNotFoundException ex) {
//            System.out.println(ex.getCause());
//              return null;
//        }
//       
//    }
    
    private String obterTabela(String comando){
            String comando1 = comando.toLowerCase();
            if(!comando1.contains("where")){
                return comando.toLowerCase().split("from")[1].trim();
            }
            
            String parte2 = comando1.split("from")[1];
            String tabela = parte2.split(" ")[1];
            return tabela;
       
    }
    
    private Item obterItem(String tabela){
        switch(tabela){
            case "cliente":
                return new Cliente();
            case "produto":
                return new Produto();
            case "pedido":
                return new Pedido();
            case "funcionario":
                return new Funcionario();
            default:
                return null;
            }
    }
  
    private List<String> obterColunas(String comando){
        String parte1 = null;
        
        String buffer = comando.toLowerCase();
        
        if(!buffer.contains("*from")){
            parte1 = buffer.split("from")[0];   
            List<String> list = new ArrayList<>();
            if(!parte1.contains(",")){
                list.add(parte1.split(" ")[1]);
                return list;
            }else{
                return Arrays.asList(parte1.split(" ")[1].split(","));
            }
        }else{
            String tabela = obterTabela(comando);
            Item item = obterItem(tabela);
            if(item==null){
                return new ArrayList<>();
            }
            return Arrays.asList(item.getAtributos());
        }
           
    }
    public  String getValores(String comando){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, senha);
            stm = con.createStatement(); 
            rs = stm.executeQuery(comando.toLowerCase());
            String result="";
            List<String> itens = obterColunas(comando.toLowerCase());
            int index=0;
            while(rs.next()){
                if(itens.size()==1){
                    result+=rs.getString(itens.get(0))+";";
                }else{
                    for(index=0;index<itens.size()-1;index++){
                        result +=rs.getString(itens.get(index))+",";
                    }
                    result+=rs.getString(itens.get(index))+";";
                }
            }    
            rs.close();
            stm.close();
            con.close();
            return result;
        } catch (SQLException |ArrayIndexOutOfBoundsException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
              return null;
        }
       
    }
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @return the stm
     */
    public Statement getStm() {
        return stm;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @param stm the stm to set
     */
    public void setStm(Statement stm) {
        this.stm = stm;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }
}
