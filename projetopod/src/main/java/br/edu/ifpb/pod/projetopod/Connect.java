/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.projetopod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author laerton
 */
public class Connect {
    private final Connection _conn;
    private static Connect _instance = null;
    //private static final String url = "jdbc:postgresql://localhost:5432/gis"; 
    private static final String driver = "org.postgresql.Driver";
    //private static final String usuario = "postgres";
    //private static final String senha = "postgres";
    
    private Connect (String url, String user, String senha) throws ClassNotFoundException, SQLException{
        Class.forName(driver); 
         _conn = DriverManager.getConnection(url, user, senha);
        
    }
    
    public static Connect getInstance (String url, String user, String senha) throws ClassNotFoundException, SQLException{
        if (_instance == null){
            _instance = new Connect(url, user, senha);
        }
        return _instance;
    }
    
    public Connection getConnect(){
        return _conn;
    }
}
