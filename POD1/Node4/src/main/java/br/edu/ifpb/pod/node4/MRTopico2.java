package br.edu.ifpb.pod.node4;


import br.edu.ifpb.pod.node4.Mensagem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laerton
 */
public class MRTopico2 extends Mensagem{
    
    public MRTopico2(String host, String porta) {
        super.porta = porta;
        super.ip = host;
        super.topico = "TOPICO2";
        super.texto ="REGISTRO";
    }
    
    @Override
    public void setTexto(String texto){
        
    }
   
            
}
