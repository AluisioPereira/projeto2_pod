/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.projetopod;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author laerton
 */
public class Main {
    private static Regras regras;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        /*Servidor server = new Servidor(1099);
        Person pessoa = server.getPerson();
        
        */
        Servidor server = new Servidor(1099);
         //processa a mensagem e registra os dados no banco
        server.processaMensagem();
        try {
            Cliente client = new Cliente("localhost", 1097);
            //Verifica se a mensagem tem dados para encaminhar para node 1 e encaminha
            server.encaminhaMensagem(client);
        } catch (Exception e) 
        {
            System.err.println(e.getMessage()); 
        }
        
    }
    
}
