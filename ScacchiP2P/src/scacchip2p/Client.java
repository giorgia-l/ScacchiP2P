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
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lini_giorgia
 */
public class Client {

    //DatiCondivisi dati = new DatiCondivisi();
    DatagramSocket client;
    int porta;
    InetAddress IP;

    public Client() throws SocketException {
        try {
            client = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Client(String ip,int porta) throws SocketException, UnknownHostException {
        client = new DatagramSocket();
        this.IP=InetAddress.getByName(ip);
        this.porta=porta;
    }
    
        public Client(String ip) throws SocketException, UnknownHostException {
        client = new DatagramSocket();
        this.IP=InetAddress.getByName(ip);
        this.porta=0;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public void setIP(InetAddress IP) {
        this.IP = IP;
    }

    public void send(String risposta) {
        byte[] responseBuffer = risposta.getBytes();
        DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
        byte[] buffer = new byte[1500];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        responsePacket.setAddress(IP);
        responsePacket.setPort(porta);
        try {
            client.send(responsePacket);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void chiudiClient(){
//        client.disconnect();
        client.close();
    }
}
