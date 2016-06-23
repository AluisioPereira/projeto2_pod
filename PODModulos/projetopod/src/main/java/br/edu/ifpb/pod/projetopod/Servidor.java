/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.projetopod;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.sql.SQLException;
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
    private Person _person;
    
    public Servidor(int porta) throws IOException{
        _person = new Person();
        _serverSocket = new ServerSocket();
        this._porta = new InetSocketAddress(porta);
        _serverSocket.bind(_porta);
        _socket = _serverSocket.accept();
        System.out.println("Server : cliente conectado...");
        
     }
     
    public void close() throws IOException{
        _socket.close();
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
     
    public Person getPerson() throws IOException{
     
        return _person;
    }
    
    
    
    private Person montaMensagem(Socket socket) throws IOException {
        Person retorno = new Person();
        //mensagem = new Mensagem());
        Scanner s = new Scanner(socket.getInputStream()).useDelimiter("\\|");
       while (s.hasNext()) {            
            retorno.setId((Integer.parseInt(s.next())));
            retorno.setNome(s.next());
            retorno.setPhone(s.next());
        }
       return retorno;
    }

    void processaMensagem() throws ClassNotFoundException, SQLException, IOException {
        _person = montaMensagem(_socket);
        DAOPessoa dao = new DAOPessoa();
        dao.Add(_person);
    }

    void encaminhaMensagem(Cliente client) throws IOException {
        client.enviaMensagem(_person.getId() +"|" + _person.getPhone());
    }
}
