/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.node1;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.sql.SQLException;

/**
 *
 * @author laerton
 */
public class Main {
   
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        
        try {
            Socket conex = new Socket("localhost", 1071);
            Thread t = new Cliente(conex);
            t.start();
            t.sleep(500);
            System.err.println(((Cliente)t).recebeMensagem());
            
        } catch (Exception e) {
        }
        
    }
    
}
