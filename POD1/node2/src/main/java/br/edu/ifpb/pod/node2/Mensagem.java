package br.edu.ifpb.pod.node2;

/**
 * Document Mensagem
 * @Date  30/06/2016 @Time 19:53:24
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
public class Mensagem {
    private String texto;
    private String remetente;
    private String topico;

    public Mensagem(){
        
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

    public void setRemetente(String tamanho) {
        this.remetente = tamanho;
    }

    public String getTopico() {
        return topico;
    }

    public void setTopico(String nome) {
        this.topico = nome;
    }
    
    @Override
    public String toString(){
        return remetente + ";" + topico + ";" + texto ;
    }

    public Mensagem( String remetente, String topico, String texto) {
        this.texto = texto;
        this.remetente = remetente;
        this.topico = topico;
    }

    
    
    
}
