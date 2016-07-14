/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.node4;



/**
 *
 * @author laerton
 */
public class Mensagem {

    protected String texto;
    protected String ip;
    protected String porta;
    protected String remetente;
    protected String topico ;

    public Mensagem(String texto, String ip, String porta) {
        this.texto = texto;
        this.ip = ip;
        this.porta = porta;
        this.remetente = "NODE4";
    }
    
    public Mensagem(){
        this.texto = "";
        this.ip = "";
        this.porta = "";
        this.remetente = "NODE4";
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
        return remetente+";"+ip+";"+ porta + ":" + topico + ":" + texto;
    }

    

}
