package br.edu.ifpb.pod.node3;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

/**
 *
 * @author Aluísio
 */
public class Servidor {

    private ServerSocket serverSocket;
    private InetSocketAddress porta;
    private Socket socket;
    private InputStream input;
    private Mensagem mensagem;

    public Servidor(int p) throws IOException {
        serverSocket = new ServerSocket();
        this.porta = new InetSocketAddress(p);
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

        Scanner s = new Scanner(socket.getInputStream()).useDelimiter("\\|");
        while (s.hasNext()) {
            retorno.setTexto(s.next());
        }
        return retorno;
    }
}
