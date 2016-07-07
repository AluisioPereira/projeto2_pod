package br.edu.ifpb.pod.node2;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

/**
 *
 * @author Aluísio
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        try {
            Socket conex = new Socket("localhost", 1071);
            Thread t = new Cliente(conex);
            t.start();
        } catch (Exception e) {
        }

    }

}
