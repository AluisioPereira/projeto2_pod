package br.edu.ifpb.pod.projetpod;

/**
 *
 * @author Wellington
 */
public class Mensagem {

    private String texto;
    private String topico;
    private String remetente;

   public  Mensagem() {

    }

    public String getTopico() {
        return topico;
    }

    public void setTopico(String topico) {
        this.topico = topico;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
 @Override
    public String toString(){
        return remetente + ";" + topico + ";" + texto ;
    }

    public Mensagem(String texto, String topico, String remetente) {
        this.texto = texto;
        this.topico = topico;
        this.remetente = remetente;
    }
}
