/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.bus;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 *
 * @author laerton
 */
public class Clienteold {
    private Socket socket;
    private InputStream input;
    
    public Clienteold(String host, Integer porta) throws IOException{
        System.out.println("Cliente : conectando servidor...");
        socket = new Socket(host, porta);
    }
    public void enviaMensagem(Mensagem mensagem){
        
    }
    public void enviaMensagem(String mensagem) throws IOException{
        System.out.println("Cliente : Enviando mensagem...");
        socket.getOutputStream().write(mensagem.getBytes());
        socket.getOutputStream().flush();
    }
    
    public void close() throws IOException{
        System.out.println("Cliente : Encerrando mensagem...");
        socket.close();
    }
    
    public String recebeMensagem() throws IOException{
    input = socket.getInputStream();
    byte[] b = new byte[1024];
    input.read(b);
    return new String(b).trim();
    
    }
}
