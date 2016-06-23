/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.projetopod;

/**
 *
 * @author laerton
 */
public class Salesman {

    private int _personid;
    private String _phone;

    public Salesman(int _personid, String _phone) {
        this._personid = _personid;
        this._phone = _phone;
    }

    public int getPersonid() {
        return _personid;
    }

    public void setPersonid(int _personid) {
        this._personid = _personid;
    }

    public String getPhone() {
        return _phone;
    }

    public void setPhone(String _phone) {
        this._phone = _phone;
    }

}
