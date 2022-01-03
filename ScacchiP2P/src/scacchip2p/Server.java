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
    String messaggioRicevuto;
    boolean isReceveid;

    public Server() throws SocketException {
        server = new DatagramSocket(42069);
        messaggioRicevuto = "";
        isReceveid = false;
    }

    public Server(int port) throws SocketException {
        server = new DatagramSocket(port);
        messaggioRicevuto = "";
        isReceveid = false;
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
            messaggioRicevuto = ascolta();

//            String campi[] = messaggioRicevuto.split(";");
//            switch (campi[0]) {
//                case "c":
//                    break;
//                case "sc":
//
//                    break;
//                case "r":
//                    break;
//                case "m":
//                    break;
//            }
        }
    }

    public String getMessaggioRicevuto() {
        return messaggioRicevuto;
    }
}
