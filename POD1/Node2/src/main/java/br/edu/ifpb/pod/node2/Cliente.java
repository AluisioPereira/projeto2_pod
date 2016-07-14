package br.edu.ifpb.pod.node2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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

        // thread para receber mensagens do servidor
        Recebedor r = new Recebedor(cliente.getInputStream());

        new Thread(r).start();

        // lê msgs do teclado e manda pro servidor
        Scanner teclado = new Scanner(System.in);

        PrintStream saida = new PrintStream(cliente.getOutputStream());
        MenTopico2 m = new MenTopico2("Laerton sei lá", host, String.valueOf(porta));
        MenTopico3 m3 = new MenTopico3("Laerton oi de novo", host, String.valueOf(porta));
        saida.println(m.toString());
        saida.println(m3.toString());
        Thread.sleep(3000);
        cliente.close();
        
    }

}
