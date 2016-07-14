package br.edu.ifpb.pod.node3;


import br.edu.ifpb.pod.node3.Mensagem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laerton
 */
public class MensagemRegistra extends Mensagem{
    
    public MensagemRegistra(String host, String porta) {
        super.porta = porta;
        super.ip = host;
        super.texto ="REGISTRO";
    }
    
    @Override
    public void setTexto(String texto){
        
    }
            
}
