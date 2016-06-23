/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.projetPOD;

/**
 *
 * @author laerton
 */
public class Mensagem {
    private String texto;
    private String tamanho;
    private String nome;

    public Mensagem(){
        
    }
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString(){
        return texto + ";" + tamanho + ";" + nome ;
    }

    public Mensagem(String texto, String tamanho, String nome) {
        this.texto = texto;
        this.tamanho = tamanho;
        this.nome = nome;
    }

    
    
    
}
