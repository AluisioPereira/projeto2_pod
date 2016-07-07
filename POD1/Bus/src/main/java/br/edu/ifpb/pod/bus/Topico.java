/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.bus;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author laerton
 */
public class Topico extends Observable {
    private List<Mensagem> mensagens;
    private List<Assinate> assinates;
    private String nome;

    public Topico(String nome) 
    {
        mensagens = new LinkedList<Mensagem>();
        assinates = new LinkedList<Assinate>();
        this.nome = nome;
    }
    /**
     * Método adiciona mensagem ao tópico
     */
    public void AddMensagem(Mensagem mensagem){
        mensagens.add(mensagem);
        setChanged();
        notifyObservers();
         
    }
    /**
     * Método adiciona inscritos para o topico
     */
    public void AddInscrito(String inscrito){
        String[] dados = inscrito.split(";");
        if (!isInscrito(dados[0])){
            Assinate a = new Assinate(this, dados[0],dados[1], dados[2]);
            assinates.add(a);
        }
    }
    
    public boolean isInscrito(String nome){
        for (Iterator<Assinate> iterator = assinates.iterator(); iterator.hasNext();) {
            Assinate a = iterator.next();
            if (a.getNode().toUpperCase().equals(nome.toUpperCase())){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo retorna em forma de string todas as mensagens de um tópico
     */
    public String getStringMensagens(){
        String retorno = "";
        if (mensagens.size()== 0)   {
            return  "Não exite mensagens para " + this.nome;
        }
        for (Iterator<Mensagem> iterator = mensagens.iterator(); iterator.hasNext();) {
            retorno +=  iterator.next().toString();
            
        }
        return  retorno;
    }
    
    public Mensagem getUltimaMensagem (){
        if (mensagens.size()>0){
            return mensagens.get(mensagens.size()-1);
        }
        return new Mensagem("Bus", "", "Não há mensagens.");
                
    }
    
    public List<Assinate> getAssinates(){
        return assinates;
    }
}
