package br.edu.ifpb.pod.node2;

/**
 *
 * @author Aluísio
 */
public class MensagemT2 extends Mensagem {

    public MensagemT2(String texto, String ip, String porta) {
        super(texto, ip, porta);
        topico = "TOPICO2";
    }

    @Override
    public String toString() {
        return remetente + ";" + ip + ";" + porta + "|" + topico + "|" + texto;
    }
}
