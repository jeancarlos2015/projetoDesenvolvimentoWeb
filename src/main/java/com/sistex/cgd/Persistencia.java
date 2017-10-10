/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jean
 */
public class Persistencia {

    private String url = "jdbc:postgresql://localhost:5432/testeheroku",
            usuario = "postgres", senha = "ifes";
    private Connection con;
    private Statement stm;
    private final String driver = "org.postgresql.Driver";
    private ResultSet rs;

    private static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        return DriverManager.getConnection(dbUrl, username, password);
    }

    private  Connection getConnection1() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, senha);
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    public boolean executar(String comando) {
//        try {
//
//            Class.forName(driver);
//
//            con = DriverManager.getConnection(url, usuario, senha);
//
//            stm = con.createStatement();
//
//            //stm.executeQuery(comando);  
//            stm.executeUpdate(comando);
//            //Editado 21/09/2011 para correção: executeQuery é usado para pesquisa, executeUpdate deve ser usado para inserir  
//            con.close();
//
//            return true;
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
//    }
    public boolean executar(String comando) {
        try {

            con = getConnection();
            stm = con.createStatement();

            //stm.executeQuery(comando);  
            stm.executeUpdate(comando);
            //Editado 21/09/2011 para correção: executeQuery é usado para pesquisa, executeUpdate deve ser usado para inserir  
            con.close();

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (URISyntaxException ex) {
            return false;
        }
        
    }

    public String select(String comando, String colunas) {
        try {
            Class.forName(driver);
            String comando1 = comando.toLowerCase();
            con = getConnection();
            stm = con.createStatement();
            rs = stm.executeQuery(comando1);
            String[] colunas_str = colunas.split(",");
            String result = "";
            int index = 0;
            while (rs.next()) {
                for (index = 0; index < colunas_str.length - 1; index++) {
                    if (rs.getString(colunas_str[index].trim()) != null) {
                        result += rs.getString(colunas_str[index].trim()) + ",";
                    }
                }
                result += rs.getString(colunas_str[index].trim()) + ";";
            }
            rs.close();
            stm.close();
            con.close();
            return result;
        } catch (SQLException | ArrayIndexOutOfBoundsException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        } catch (URISyntaxException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
