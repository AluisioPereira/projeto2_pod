/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.bus;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laerton
 */
public class TrataMensagem implements Runnable {

    private InputStream cliente;

    private Server servidor;
    private Mensagem m;

    public TrataMensagem(InputStream cliente, Server servidor) {

        this.cliente = cliente;

        this.servidor = servidor;

    }

    TrataMensagem(Mensagem m, Server servidor) {
        this.servidor = servidor;
        this.m = m;
    }

    public void run() {

        // quando chegar uma msg, distribui pra todos
        String m = "";
        Scanner s = new Scanner(this.cliente);
           
           while (s.hasNextLine()) {
            try {
                m = s.nextLine();
                servidor.distribuiMensagem(m);
                System.out.println(m);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
           }
           
           s.close();
        /*Mensagem m = new Mensagem();
        Scanner s = new Scanner(cliente).useDelimiter("\\|");
        while (s.hasNext()) {
            m.setRemetente(s.next());
            m.setTopico(s.next());
            m.setTexto(s.next());
        }*/
        
        //servidor.distribuiMensagem(m);
        //s.close();

    }

}
