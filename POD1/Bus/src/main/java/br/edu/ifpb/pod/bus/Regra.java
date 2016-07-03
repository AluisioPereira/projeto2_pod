/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.bus;

import com.sun.org.apache.bcel.internal.generic.Select;

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
    public String registraMensagem(Mensagem mensagem){
        if (mensagem.getTexto().toUpperCase().equals("REGISTRO")){
            addInscricao(mensagem);
            return "Registro realizado com sucesso!";
        }else if (mensagem.getTexto().toUpperCase().equals("REQUISITAR")){
            return getMensagens(mensagem.getRemetente());
        }else{
            addMensagem(mensagem);
            return "Mensagem lançada com sucesso!";
        }
    }
    /**
     * Método adiciona uma mensagem ao respectivo tópico a que ela destina.
     */
    private void addMensagem(Mensagem mensagem){
        switch (mensagem.getTopico().toUpperCase()){
            case "TOPICO1":
                topico1.AddMensagem(mensagem);
                break;
            case "TOPICO2":
                topico2.AddMensagem(mensagem);
                break;
            case "TOPICO3":
                topico3.AddMensagem(mensagem);
                break;
                
        }
               
    }
    /**
     * Método faz inscrição de membro a um tópico.
     */
    private void addInscricao(Mensagem mensagem){
        switch (mensagem.getTopico().toUpperCase()){
            case "TOPICO1":
                topico1.AddInscrito(mensagem.getRemetente());
                break;
            case "TOPICO2":
                topico2.AddInscrito(mensagem.getRemetente());
                break;
            case "TOPICO3":
                topico3.AddInscrito(mensagem.getRemetente());
                break;
                
        }
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
}
