package br.edu.ifpb.pod.node2;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Document Main
 *
 * @Date 30/06/2016 @Time 19:52:54
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Cliente cliente = new Cliente("127.0.0.1", 12345);
        Mensagem mensagem = new Mensagem();
        mensagem.setRemetente("Node2");
        mensagem.setTopico("Topico 2");
        mensagem.setTexto("Qual o significado da existencia..");
        cliente.enviaMensagem(mensagem);
        
        Mensagem mensagem2 = new Mensagem();
        mensagem2.setRemetente("Node2");
        mensagem2.setTopico("Topico 3");
        mensagem2.setTexto("Quem nasceu primeiro a ave ou o lagarto?");
        cliente.enviaMensagem(mensagem);

    }

}
