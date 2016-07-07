package br.edu.ifpb.pod.node2;

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

    public void enviarMensagemT2(MensagemT2 msgT2) throws IOException {
        enviarMensagem(msgT2.toString());
    }

    public void enviarMensagemT3(MensagemT3 msgT3) throws IOException {
        enviarMensagem(msgT3.toString());
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
            /**
             * teste para mensagem enviada a topico2
             */
            MensagemT2 msgt2 = new MensagemT2("teste", "localhost", "1072");
            enviarMensagemT2(msgt2);
            String mensagem2 = recebeMensagem();
            System.out.println(mensagem2);
            /**
             * teste para mensagem enviada a topico3
             */
            MensagemT3 msgt3 = new MensagemT3("teste", "localhost", "1072");
            enviarMensagemT3(msgt3);
            String mensagem3 = recebeMensagem();
            System.out.println(mensagem3);

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
