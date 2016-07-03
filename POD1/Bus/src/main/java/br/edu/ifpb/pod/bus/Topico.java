/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.bus;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author laerton
 */
public class Topico {
    private List<Mensagem> mensagens;
    private List<String> inscritos;
    private String nome;

    public Topico(String nome) 
    {
        mensagens = new LinkedList<>();
        inscritos = new LinkedList<>();
        this.nome = nome;
    }
    /**
     * Método adiciona mensagem ao tópico
     */
    public void AddMensagem(Mensagem mensagem){
        mensagens.add(mensagem);
    }
    /**
     * Método adiciona inscritos para o topico
     */
    public void AddInscrito(String inscrito){
        inscritos.add(inscrito);
    }
    
    public boolean isInscrito(String inscrito){
        for (Iterator<String> iterator = inscritos.iterator(); iterator.hasNext();) {
            if (iterator.next().toUpperCase().equals(inscrito.toUpperCase())){
                return true;
            }
        }
        return  false;
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
    
}
