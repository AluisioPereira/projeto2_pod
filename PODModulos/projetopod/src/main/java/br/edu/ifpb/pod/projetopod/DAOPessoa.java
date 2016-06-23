/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.projetopod;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laerton
 */
public class DAOPessoa implements IDAO<Person>{
    private Connection conex;
    
    public DAOPessoa() throws ClassNotFoundException, SQLException{
        conex = new Regras().getConnection();
    }
    
    @Override
    public void Add(Person tipo) {
        
     try {
            Statement s = (Statement) conex.createStatement();
            s.execute("insert into person (id, name) values ("+ tipo.getId() + ",'" + tipo.getNome() + "');");
            
            s.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
