/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.bus;

import java.util.Observable;
import java.util.Observer;


/**
 *
 * @author laerton
 */
public class Assinate implements Observer{

    private Observable TopicoObservable;
    private Mensagem m;
    private String node;
    private String IP;
    private String porta;

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }
    
    public Assinate(Observable TopicoObservable, String node, String IP, String porta) {
        this.TopicoObservable = TopicoObservable;
        this.node = node;
        this.IP = IP;
        this.porta = porta;
        TopicoObservable.addObserver(this);
        
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Topico){
            Topico t = (Topico) o;
            m = t.getUltimaMensagem();
        }
    }
    
    public Mensagem getMensagem(){
        return m;
    }
    
    public String getNode(){
        return node;
    }
    
    
}
