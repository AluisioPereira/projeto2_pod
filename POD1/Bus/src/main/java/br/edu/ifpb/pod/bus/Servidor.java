/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.bus;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintStream;
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
    private Integer _porta; //InetSocketAddress _porta;
    private Socket _socket;
    private InputStream _input;
    private Mensagem mensagem;
    private final Regra reg = new Regra();
    
    public Servidor(int porta) throws IOException{
        //_serverSocket = new ServerSocket();
        this._porta = porta;//new InetSocketAddress(porta);
        //_serverSocket.bind(_porta);
        //_socket = _serverSocket.accept();
       
        mensagem = new Mensagem();
     }

    Servidor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Regra getRegra(){return  this.reg;}
    public Mensagem getMensagem(){return  mensagem;}
    public void close() throws IOException{
        _socket.close();
    }
    

   public Servidor(Socket conex) {
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
     public void setSocket(Socket socket){
         this._socket = socket;
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
    
    public static void main(String[] args) throws IOException {
        new Servidor(1071).start();
    }
    
    @Override
    public void run(){
      
        try {
            _serverSocket = new ServerSocket(_porta);
            System.out.println("Porta " + _porta + " aberta.");
            
            while (true) {                
                _socket = _serverSocket.accept();
                System.err.println("Server : cliente " + _socket.getInetAddress().getHostAddress() + " conectado.");
                PrintStream ps = new PrintStream(_socket.getOutputStream());
                mensagem = this.exibeMensagem();
                ps.println(reg.registraMensagem(mensagem));
                System.out.println(this.mensagem);
            }
            //reg = new Regra(this);
            //    this.mensagem = exibeMensagem();
            //    reg.registraMensagem(mensagem);
            //    System.out.println(mensagem);
             //   this.retornaMensagem("Retorno:" + mensagem);
            //    System.err.println(reg.getTopico1().getStringMensagens());
            //this.retornaMensagem("teste" + this.mensagem);
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
