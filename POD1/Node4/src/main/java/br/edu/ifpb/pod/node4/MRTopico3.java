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
public class MRTopico3 extends Mensagem{
    public MRTopico3(String host, String porta) {
        super.porta = porta;
        super.ip = host;
        super.topico = "TOPICO3";
        super.texto ="REGISTRO";
    }
    
    @Override
    public void setTexto(String texto){
        
    }
}
