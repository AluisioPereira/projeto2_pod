package br.edu.ifpb.pod.node2;

/**
 *
 * @author Aluísio
 */
public class MensagemT3 extends Mensagem {

    public MensagemT3(String texto, String ip, String porta) {
        super(texto, ip, porta);
        topico = "TOPICO3";
    }
}
