/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.bus;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author laerton
 */
public class Main {
   
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        /*
        //Enviando dados de persoa 
        Person pessoa = new Person(1, "Joe", "35222786");
        Cliente node1 = new Cliente("10.3.188.193", 1099);
        node1.enviaMensagem(pessoa.toString());
        //Cliente node3 = new Cliente("x.x.x.x", 1099);
        
*/
        Servidor servidor = new Servidor(1071);
        System.out.println(servidor.exibeMensagemtexto());
        servidor.close();
    }
    
}
