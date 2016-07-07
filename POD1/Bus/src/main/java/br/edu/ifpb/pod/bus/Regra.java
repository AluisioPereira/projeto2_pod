/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.bus;

import com.sun.org.apache.bcel.internal.generic.Select;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author laerton
 */
public class Regra {
    private Topico topico1, topico2, topico3;
    private Servidor s;
    private Cliente c;

    public Servidor getServidor() {
        return s;
    }

    public void setServidor(Servidor s) {
        this.s = s;
    }
    
    public Regra(Servidor s) {
        this.s = s;
        topico1 = new Topico("TOPICO1");
        topico2 = new Topico("TOPICO2");
        topico3 = new Topico("TOPICO3");
    }

    /**
     * Método recebe a mensagem e efetua o registro da mesma no tópico correspondente,
     * caso seja uma inscrição a mesma trata a inscrição.
     */
    public void registraMensagem(Mensagem mensagem) throws IOException{
        if (mensagem.getTexto().toUpperCase().equals("REGISTRO")){
            addInscricao(mensagem);
            s.retornaMensagem("Node registrado com sucesso!");
        }else if (mensagem.getTexto().toUpperCase().equals("REQUISITAR")){
            s.retornaMensagem("Segue as mensagens requisitadas");
            s.retornaMensagem(getMensagens(mensagem.getRemetente()));
        }else{
            addMensagem(mensagem);
            s.retornaMensagem("Mensagem registrada com sucesso!");
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
    /**
     * Método faz inscrição de membro a um tópico.
     */
    private void addInscricao(Mensagem mensagem) throws IOException{
        switch (mensagem.getTopico().toUpperCase()){
            case "TOPICO1":
                topico1.AddInscrito(mensagem.getRemetente());
                s.retornaMensagem("Registro realizado com sucesso no Topico1!" + topico1.getStringMensagens()); ;
                break;
            case "TOPICO2":
                topico2.AddInscrito(mensagem.getRemetente());
                s.retornaMensagem("Registro realizado com sucesso no Topico2!" + topico2.getStringMensagens()); ;
                break;
            case "TOPICO3":
                topico3.AddInscrito(mensagem.getRemetente());
                s.retornaMensagem("Registro realizado com sucesso no Topico3!" + topico3.getStringMensagens()); ;
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

    private void update(Topico topico) throws IOException {
         LinkedList<Assinate> lista =  (LinkedList<Assinate>) topico.getAssinates();
         for (Iterator<Assinate> iterator = lista.iterator(); iterator.hasNext();) {
            Assinate next = iterator.next();
            next.update(topico, s);
            c = new Cliente(next.getIP(),Integer.parseInt(next.getPorta()) );
            c.enviaMensagem(next.getMensagem().toString());
        }
    }

    
}
