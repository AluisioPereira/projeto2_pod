package br.edu.ifpb.pod.node2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Laerton
 */
public class MenTopico3 extends MenTopico2{
    
        
    public MenTopico3(String texto, String ip, String porta){
        super(texto,ip,porta);
        topico = "TOPICO3";
    }
    @Override
    public String toString() {
        return remetente+";"+ip+";"+ porta + ":" + topico + ":" + texto;
    }
}
