package br.edu.ifpb.pod.node3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluísio
 */
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

    public void enviarMensagem(Mensagem msg) throws IOException {
        enviarMensagem(msg.toString());
    }

    public void enviarMensagem(String msg) throws IOException {
        System.out.println("Cliente : Enviando mensagem...");
        saida = new ObjectOutputStream(socket.getOutputStream());
        saida.writeObject(msg);
        socket.getOutputStream().flush();
    }

    public void close() throws IOException {
        System.out.println("Cliente : Encerrando mensagem...");
        socket.close();
    }

    public String recebeMensagem() throws IOException, ClassNotFoundException {
        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
        return entrada.readObject().toString();
    }

    @Override
    public void run() {
        try {

            Mensagem msg = new Mensagem("teste", "localhost", "1072");
            enviarMensagem(msg);
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
    }
}
