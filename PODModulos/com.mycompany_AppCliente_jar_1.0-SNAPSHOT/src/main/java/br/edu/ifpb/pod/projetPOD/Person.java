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
public class Person {
    private int _id;
    private String _nome, _phone;

    public String getPhone() {
        return _phone;
    }

    public void setPhone(String _phone) {
        this._phone = _phone;
    }

    public Person(int _id, String _nome, String _phone) {
        this._id = _id;
        this._nome = _nome;
        this._phone = _phone;
    }
    
    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getNome() {
        return _nome;
    }

    public void setNome(String _nome) {
        this._nome = _nome;
    }
    
    
    @Override
    public String toString(){
        return  _id + "|"+ _nome + "|"  + _phone;
    }
}
