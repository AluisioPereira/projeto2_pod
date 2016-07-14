/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.bus;


import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author laerton
 */
public class Regra {
    private Topico topico1, topico2, topico3;
    
    public Regra() {
       
        topico1 = new Topico("TOPICO1");
        topico2 = new Topico("TOPICO2");
        topico3 = new Topico("TOPICO3");
    }

    /**
     * Método recebe a mensagem e efetua o registro da mesma no tópico correspondente,
     * caso seja uma inscrição a mesma trata a inscrição.
     */
    public String registraMensagem(Mensagem mensagem, PrintStream ps) throws IOException{
        if (mensagem.getTexto().toUpperCase().equals("REGISTRO")){
            return addInscricao(mensagem, ps);
             
        }else if (mensagem.getTexto().toUpperCase().equals("REQUISITAR")){
            
            return "Segue as mensagens requisitadas " + (getMensagens(mensagem.getRemetente()));
        }else{
            addMensagem(mensagem);
            return "Mensagem registrada com sucesso!";
        }
    }
    /**
     * Método adiciona uma mensagem ao respectivo tópico a que ela destina.
     */
    private void addMensagem(Mensagem mensagem) throws IOException{
        switch (mensagem.getTopico().toUpperCase()){
            case "TOPICO1":
                topico1.AddMensagem(mensagem);
                update(topico1);
                break;
            case "TOPICO2":
                topico2.AddMensagem(mensagem);
                update(topico2);
                break;
            case "TOPICO3":
                topico3.AddMensagem(mensagem);
                update(topico3);
                break;
            
                
        }
               
    }
    public Topico getTopico1(){return topico1;}
    /**
     * Método faz inscrição de membro a um tópico.
     */
    private String addInscricao(Mensagem mensagem, PrintStream ps) throws IOException{
        String retorno = "";
        switch (mensagem.getTopico().toUpperCase()){
            case "TOPICO1":
                topico1.AddInscrito(mensagem.getRemetente(), ps);
                retorno = ("Registro realizado com sucesso no Topico1!" + topico1.getStringMensagens()); 
                break;
            case "TOPICO2":
                topico2.AddInscrito(mensagem.getRemetente(),ps);
                retorno = ("Registro realizado com sucesso no Topico2!" + topico2.getStringMensagens()); ;
                break;
            case "TOPICO3":
                topico3.AddInscrito(mensagem.getRemetente(),ps);
                retorno = ("Registro realizado com sucesso no Topico3!" + topico3.getStringMensagens()); ;
                break;
                
        }
        return retorno;
    }
    /**
     * Método retorna todas as mensagens de cujo o inscrito está registrado.
     */
    public String getMensagens(String inscrito){
        
        return  getMensagemTopico1(inscrito) + " " + getMensagemTopico2(inscrito) + " " +
                getMensagemTopico3(inscrito);
                
    }
    /**
     * Método retorna todas as mensagens do topico1 de cujo o inscrito está registrado.
     */
    private String getMensagemTopico1(String inscrito){
        if (topico1.isInscrito(inscrito)){
            return "Mensagens do topico1 " + topico1.getStringMensagens();
        }
        return "";
    }
     
    /**
     * Método retorna todas as mensagens do topico2 de cujo o inscrito está registrado.
     */
    private String getMensagemTopico2(String inscrito){
        if (topico1.isInscrito(inscrito)){
            return "Mensagens do topico2 " + topico2.getStringMensagens();
        }
        return "";
    }
    /**
     * Método retorna todas as mensagens do topico3 de cujo o inscrito está registrado.
     */
    private String getMensagemTopico3(String inscrito){
        if (topico1.isInscrito(inscrito)){
            return "Mensagens do topico3 " + topico3.getStringMensagens();
        }
        return "";
    }

    private void update(Topico topico ) throws IOException {
         
        LinkedList<Assinate> lista =  (LinkedList<Assinate>) topico.getAssinates();
        
         for (Iterator<Assinate> iterator = lista.iterator(); iterator.hasNext();) {
            Assinate next = iterator.next();
            next.update(topico, null);
             
        }
    }

    
}
