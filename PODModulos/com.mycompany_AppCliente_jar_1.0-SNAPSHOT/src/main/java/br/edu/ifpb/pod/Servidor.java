/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

/**
 *
 * @author laerton
 */
public class Servidor {
    private ServerSocket _serverSocket;
    private InetSocketAddress _porta;
    private Socket _socket;
    private InputStream _input;
    private Mensagem mensagem;
    
    public Servidor(int porta) throws IOException{
        _serverSocket = new ServerSocket();
        this._porta = new InetSocketAddress(porta);
        _serverSocket.bind(_porta);
        _socket = _serverSocket.accept();
        System.out.println("Server : cliente conectado...");
        
     }
     
    public void close() throws IOException{
        _socket.close();
    }
     
    
     public Mensagem exibeMensagem() throws IOException
     {
        return montaMensagem(_socket);
     }
     
     public void retornaMensagem(String mensagem) throws IOException
     {
       _socket.getOutputStream().write(mensagem.getBytes());   
     }
     
     public String exibeMensagemtexto() throws IOException{
        _input = _socket.getInputStream();
        byte[] b = new byte[1024];
        _input.read(b);
        return new String(b).trim();
     }
     
    private Mensagem montaMensagem(Socket socket) throws IOException {
        Mensagem retorno = new Mensagem();
        //mensagem = new Mensagem());
        Scanner s = new Scanner(socket.getInputStream()).useDelimiter("\\|");
       while (s.hasNext()) {            
            retorno.setTexto(s.next());
            retorno.setTamanho(s.next());
            retorno.setNome(s.next());
        }
       return retorno;
    }
}
