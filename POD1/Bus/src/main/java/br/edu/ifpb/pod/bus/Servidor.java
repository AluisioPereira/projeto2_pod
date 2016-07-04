/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.bus;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laerton
 */
public class Servidor extends Thread{
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
    

    Servidor(Socket conex) {
        _socket = conex;
        System.out.println("Server : cliente conectado...");
    }
    
     public Mensagem exibeMensagem() throws IOException
     {
        return montaMensagem(_socket);
     }
     
     public void retornaMensagem(String mensagem) throws IOException
     {
        _socket.getOutputStream().write(mensagem.getBytes());
        _socket.getOutputStream().flush();
     }
     
     public String exibeMensagemtexto() throws IOException, ClassNotFoundException{
        ObjectInputStream entrada = new ObjectInputStream(_socket.getInputStream());
        return entrada.readObject().toString();
     }
     
    private Mensagem montaMensagem(Socket socket) throws IOException {
        Mensagem retorno = new Mensagem();
        Scanner s = new Scanner(socket.getInputStream()).useDelimiter("\\|");
       while (s.hasNext()) {            
            retorno.setRemetente(s.next());
            retorno.setTopico(s.next());
            retorno.setTexto(s.next());
        }
       return retorno;
    }
    
    @Override
    public void run(){
        try {
            Regra reg = new Regra(this);
            Mensagem m = exibeMensagem();
            reg.registraMensagem(m);
            System.out.println(m.toString());
            retornaMensagem("recebido");
            //close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
