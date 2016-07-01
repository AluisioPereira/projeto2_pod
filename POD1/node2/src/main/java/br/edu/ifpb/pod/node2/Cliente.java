package br.edu.ifpb.pod.node2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Document Cliente
 * @Date  30/06/2016 @Time 19:51:44
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 

public class Cliente {
    private Socket socket;
    private  ObjectOutputStream saida;
    
    public Cliente(String host, Integer porta) throws IOException{
        System.out.println("Cliente : conectando servidor...");
        socket = new Socket(host, porta);
    }
 
    public void enviaMensagem(Mensagem mensagem) throws IOException{
        System.out.println("Cliente : Enviando mensagem...");
         saida = new ObjectOutputStream(socket.getOutputStream());
         saida.writeObject(mensagem);
        socket.getOutputStream().flush();
    }
    
    public void close() throws IOException{
        System.out.println("Cliente : Encerrando mensagem...");
        socket.close();
     
    }   
}