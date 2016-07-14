/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.node3;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author laerton
 */
public class Cliente {

    public static void main(String[] args)
            throws UnknownHostException, IOException, InterruptedException {

        // dispara cliente
        new Cliente("127.0.0.1", 12345).executa();

    }

    private String host;

    private int porta;

    public Cliente(String host, int porta) {

        this.host = host;

        this.porta = porta;

    }

    public void executa() throws UnknownHostException, IOException, InterruptedException {

        Socket cliente = new Socket(this.host, this.porta);

        System.out.println("O cliente se conectou ao servidor!");
        
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        Mensagem m = new MensagemRegistra(host, String.valueOf(porta));
        saida.println(m.toString());
        // thread para receber mensagens do servidor
        Recebedor r = new Recebedor(cliente.getInputStream());

        new Thread(r).start();

        // lê msgs do teclado e manda pro servidor
        

        
        
        
    }

}