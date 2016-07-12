/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.bus;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author laerton
 */
public class Server {

    private Regra reg = new Regra();

    public static void main(String[] args) throws IOException {

        // inicia o servidor
        new Server(12345).executa();

    }

    private int porta;
    private List<PrintStream> clientes;

    public Server(int porta) {
        this.porta = porta;
        this.clientes = new ArrayList<PrintStream>();

    }

    public void executa() throws IOException {

        ServerSocket servidor = new ServerSocket(this.porta);

        System.out.println("Porta 12345 aberta!");

        while (true) {

            // aceita um cliente
            Socket cliente = servidor.accept();
            System.out.println("Nova conexão com o cliente "
                    + cliente.getInetAddress().getHostAddress()
            );

            // adiciona saida do cliente à lista
            PrintStream ps = new PrintStream(cliente.getOutputStream());

            this.clientes.add(ps);
            TrataMensagem tc
                    = new TrataMensagem(cliente.getInputStream(), this);

            new Thread(tc).start();

        }

    }

    public String registraMensagem(String msg) throws IOException {
        Mensagem m = new Mensagem();
        String[] as = msg.split("|");
        
            m.setRemetente(as[0]);
            m.setTopico(as[1]);
            m.setTexto(as[2]);
        
        String r = this.reg.registraMensagem(m);
        System.out.println(this.reg.getTopico1().getStringMensagens());
        return r;
    }

    public void distribuiMensagem(String msg) throws IOException {
        // envia msg para todo mundo
        System.out.println(msg.toString());
        
        for (PrintStream cliente : this.clientes) {
            
            cliente.println(registraMensagem(msg));
        }

    }

}
