/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author laerton
 */
public class Main {
   
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        
        Person pessoa = new Person(8, "Laerton", "988024146");
        //CadastraVendedor(pessoa);
        //Order order = new Order("PD005", 1, 1, 1);
        //CadastrarOrdem(order, pessoa);
        CadastraVendedor(pessoa);
    }
    
    private static void CadastraVendedor(Person pessoa) throws IOException{
        Cliente node = new Cliente("localhost", 1099);
        node.enviaMensagem(pessoa.toString());
    }
    
    private static void CadastrarOrdem(Order ordem, Person pessoa) throws IOException{
        Cliente node = new Cliente("localhost", 1098);
        node.enviaMensagem(ordem.toString() +"|"+ pessoa.toString());
    }
    
}
