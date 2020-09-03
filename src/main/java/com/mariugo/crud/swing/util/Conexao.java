package com.mariugo.crud.swing.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {
    
    private Connection connection;
    
    public Conexao() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/swingdb";
        String driver = "org.postgresql.Driver";
        Class.forName(driver);
        connection = DriverManager.getConnection(url, "postgres", "postdba");
    }
    
    public Connection getConexao(){
        return connection;
    }
    
}
