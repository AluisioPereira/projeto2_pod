
package br.edu.ifpb.pod.node1;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 *
 * @author laerton
 */
public class Cliente {
    private Socket socket;
    private InputStream input;
    
    public Cliente(String host, Integer porta) throws IOException{
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
