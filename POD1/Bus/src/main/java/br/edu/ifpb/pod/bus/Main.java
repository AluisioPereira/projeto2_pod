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
   
    private static Regra reg;
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        reg = new Regra();
        Servidor servidor = new Servidor(1071);
        Mensagem m = servidor.exibeMensagem();
        String r = reg.registraMensagem(m);
        servidor.retornaMensagem(r);
        servidor.close();
    }
    
}
