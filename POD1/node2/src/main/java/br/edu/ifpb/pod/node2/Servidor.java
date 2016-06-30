package br.edu.ifpb.pod.node2;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

/**
 * Document Servidor
 *
 * @Date 30/06/2016 @Time 19:53:24
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class Servidor {

    private ServerSocket serverSocket;
    private InetSocketAddress porta;
    private Socket socket;
    private InputStream input;
    private Mensagem mensagem;

    public Servidor(int porta1) throws IOException {
        serverSocket = new ServerSocket();
        this.porta = new InetSocketAddress(porta1);
        serverSocket.bind(porta);
        socket = serverSocket.accept();
        System.out.println("Server : cliente conectado...");

    }

    public void close() throws IOException {
        socket.close();
    }

    public Mensagem exibeMensagem() throws IOException {
        return montaMensagem(socket);
    }

    public void retornaMensagem(String mensagem) throws IOException {
        socket.getOutputStream().write(mensagem.getBytes());
    }

    public String exibeMensagemtexto() throws IOException {
        input = socket.getInputStream();
        byte[] b = new byte[1024];
        input.read(b);
        return new String(b).trim();
    }

    private Mensagem montaMensagem(Socket socket) throws IOException {
        Mensagem retorno = new Mensagem();
        //mensagem = new Mensagem());
        Scanner s = new Scanner(socket.getInputStream()).useDelimiter("\\|");
        while (s.hasNext()) {
            retorno.setRemetente(s.next());
            retorno.setTopico(s.next());
            retorno.setTexto(s.next());
        }
        return retorno;
    }
}
