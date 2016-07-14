/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.node1;

/**
 *
 * @author Laerton
 */
<<<<<<< HEAD
public class Mensagem2 extends Mensagem {

    public Mensagem2(String texto, String ip, String porta) {
        super(texto, ip, porta);
        topico = "TOPICO2";
    }

    @Override
    public String toString() {
        return remetente + ";" + ip + ";" + porta + "|" + topico + "|" + texto;
=======
public class Mensagem2 extends Mensagem{
    
        
    public Mensagem2(String texto, String ip, String porta){
        super(texto,ip,porta);
        topico = "TOPICO2";
    }
    @Override
    public String toString() {
        return remetente+";"+ip+";"+ porta + ":" + topico + ":" + texto;
>>>>>>> master
    }
}
