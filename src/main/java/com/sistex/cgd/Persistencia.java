/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistex.cgd;

import com.sistex.cdp.Cliente;
import com.sistex.cdp.Funcionario;
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

    private String url = "jdbc:postgresql://localhost:5432/bancoSistex",
            usuario = "postgres", senha = "ifes";
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

    public String select(String comando, String colunas) {
        try {
            Class.forName(driver);
            String comando1 = comando.toLowerCase();
            con = DriverManager.getConnection(url, usuario, senha);
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
        }
    }

    
}
