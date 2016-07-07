/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.node1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laerton
 */
public class Cliente extends Thread{

    private Socket socket;
    private ObjectOutputStream saida;

    public Cliente(String host, Integer porta) throws IOException {
        System.out.println("Cliente : conectando servidor...");
        socket = new Socket(host, porta);
    }

    public Cliente(Socket conex) {
        this.socket = conex;
    }

    public void enviaMensagem(Mensagem mensagem) throws IOException {
        enviaMensagem(mensagem.toString());
    }

    public void enviaMensagem(String mensagem) throws IOException {
        System.out.println("Cliente : Enviando mensagem...");
        //saida = new ObjectOutputStream(socket.getOutputStream());
        //saida.writeObject(mensagem);
        //socket.getOutputStream().flush();
        socket.getOutputStream().write(mensagem.getBytes());
        socket.getOutputStream().flush();

    }

    public void close() throws IOException {
        System.out.println("Cliente : Encerrando mensagem...");
        socket.close();
    }

    public String recebeMensagem() throws IOException, ClassNotFoundException {
        /*ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
        return entrada.readObject().toString();*/
        //recebendo mensagem
        InputStream input = socket.getInputStream();
        //"deslinearizando" (resolvendo) a mensagem
        byte[] b = new byte[1024];
        input.read(b);
        return new String(b).trim();
    }

    @Override
    public void run() {
        try {
            Mensagem2 men = new Mensagem2("teste5", "localhost", "1072");
            enviaMensagem(men);
            String mensagem = recebeMensagem();
            System.out.println(mensagem);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                close();
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
