package br.edu.ifpb.pod.node2;

/**
 *
 * @author Aluísio
 */
public class Mensagem {

    protected String texto;
    protected String ip;
    protected String porta;
    protected final String remetente = "NODE2";
    protected String topico;

    public Mensagem(String texto, String ip, String porta) {
        this.texto = texto;
        this.ip = ip;
        this.porta = porta;
    }

    public Mensagem() {
        this.texto = "";
        this.ip = "";
        this.porta = "";
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getRemetente() {
        return remetente;
    }

    public String getTopico() {
        return topico;
    }

    @Override
    public String toString() {
        return remetente + ";" + ip + ";" + porta + "|" + topico + "|" + texto;
    }

}
