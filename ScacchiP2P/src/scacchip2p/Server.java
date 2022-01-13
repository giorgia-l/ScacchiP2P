/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchip2p;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stagno_alberto
 */
public class Server extends Thread {

    DatagramSocket server;
    String messaggioRicevuto;
    boolean puoRicevere;

    DatagramPacket packet;

    ArrayList<String> bufferMessaggi;

    public Server() throws SocketException {
        server = new DatagramSocket(42069);
        messaggioRicevuto = "";
        puoRicevere = true;
        bufferMessaggi = new ArrayList<String>();
    }

    public Server(int port) throws SocketException {
        server = new DatagramSocket(port);
        messaggioRicevuto = "";
        puoRicevere = true;
        bufferMessaggi = new ArrayList<String>();
    }

    public String ascolta() {
        byte[] buffer = new byte[1500];

        packet = new DatagramPacket(buffer, buffer.length);

        try {
            server.receive(packet);
        } catch (IOException ex) {
            ex=null;
        }

        byte[] dataReceived = packet.getData(); // copia del buffer dichiarato sopra
        String messaggioRicevuto = new String(dataReceived, 0, packet.getLength());
        bufferMessaggi.add(messaggioRicevuto);

        return messaggioRicevuto;
    }

    public void chiudiServer() {
//        server.disconnect();
        puoRicevere=false;
        server.close();
    }

    public InetAddress getPacketAddress() {
        return packet.getAddress();
    }

    public int getPacketPort() {
        return packet.getPort();
    }

    public void run() {
        while (true) {
            if (puoRicevere) {
                ascolta();
            }

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
