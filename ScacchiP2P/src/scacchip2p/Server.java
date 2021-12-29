/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchip2p;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stagno_alberto
 */
public class Server extends Thread {

    DatagramSocket server;

    public Server() {
        try {
            server = new DatagramSocket(42069);
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String ascolta() {
        byte[] buffer = new byte[1500];

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        try {
            server.receive(packet);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] dataReceived = packet.getData(); // copia del buffer dichiarato sopra
        String messaggioRicevuto = new String(dataReceived, 0, packet.getLength());

        return messaggioRicevuto;
    }

    public void run() {
        while (true) {
            String messaggioRicevuto = ascolta();

            String campi[] = messaggioRicevuto.split(";");

            switch (campi[0]) {
                case "c":
                    break;
                case "sc":
                    break;
            }
        }
    }
}
