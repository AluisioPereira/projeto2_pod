/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.bus;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

/**
 *
 * @author laerton
 */
public class Main {
   
    private static Regra reg;
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        ServerSocket s = null;
        
        try {
            s = new ServerSocket(1071);
            
            while (true) {
                Socket conex = s.accept();
                Thread t = new Servidor(conex);
                t.start();
                
            }
        } catch (Exception e) {
        
        }
        
    }
    
}
