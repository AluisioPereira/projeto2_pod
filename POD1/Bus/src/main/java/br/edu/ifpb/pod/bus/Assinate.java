/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.bus;

<<<<<<< HEAD
=======
import java.io.PrintStream;
>>>>>>> master
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
<<<<<<< HEAD
=======
    private PrintStream ps;
>>>>>>> master

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
    
<<<<<<< HEAD
    public Assinate(Observable TopicoObservable, String node, String IP, String porta) {
=======
    public Assinate(Observable TopicoObservable, String node, String IP, String porta, PrintStream ps) {
>>>>>>> master
        this.TopicoObservable = TopicoObservable;
        this.node = node;
        this.IP = IP;
        this.porta = porta;
        TopicoObservable.addObserver(this);
<<<<<<< HEAD
=======
        this.ps = ps;
>>>>>>> master
        
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Topico){
            Topico t = (Topico) o;
            m = t.getUltimaMensagem();
<<<<<<< HEAD
=======
            ps.println(m.getTopico() + "!" + m.getDataHora() + "!Publicado por: " + m.getRemetente().split(";")[0] + "!Mensagem: " + m.getTexto() + "!");
>>>>>>> master
        }
    }
    
    public Mensagem getMensagem(){
        return m;
    }
    
    public String getNode(){
        return node;
    }
    
    
}
