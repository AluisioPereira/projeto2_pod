package br.edu.ifpb.pod.node2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author laerton
 */
public class MenTopico2 {

    protected String texto;
    protected String ip;
    protected String porta;
    protected final String remetente = "NODE2";
    protected String topico ;

    public MenTopico2(String texto, String ip, String porta) {
        this.texto = texto;
        this.ip = ip;
        this.porta = porta;
        topico= "TOPICO2";
    }
    
    public MenTopico2(){
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
        return remetente+";"+ip+";"+ porta + ":" + topico + ":" + texto;
    }

    

}
