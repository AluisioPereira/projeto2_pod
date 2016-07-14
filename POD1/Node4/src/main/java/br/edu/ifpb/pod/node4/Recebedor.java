/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.node4;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laerton
 */
public class Recebedor implements Runnable {

 

   private InputStream servidor;

 

   public Recebedor(InputStream servidor) {

     this.servidor = servidor;

   }

 

   public void run() {

     // recebe msgs do servidor e imprime na tela

     Scanner s = new Scanner(this.servidor);

      while (s.hasNextLine()) {
       String[] t =  s.nextLine().split("!");
       for (int i = 0; i < t.length; i++) {
             System.out.println(t[i]);
       }
     }

   }

 }
