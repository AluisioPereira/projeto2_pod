/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod.node1;

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

       System.out.println(s.nextLine());

     }

   }

 }
