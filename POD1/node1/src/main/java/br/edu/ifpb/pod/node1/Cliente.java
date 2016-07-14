/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.node1;

import java.io.IOException;
import java.io.InputStream;
<<<<<<< HEAD
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
=======
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
>>>>>>> master

/**
 *
 * @author laerton
 */
<<<<<<< HEAD
public class Cliente extends Thread {

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
        } finally {
            try {
                close();
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
=======
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
        Mensagem m = new Mensagem("Laerton", host, String.valueOf(porta));
        
        saida.println(m.toString());
        Thread.sleep(3000);
        cliente.close();
        
>>>>>>> master
    }

}
