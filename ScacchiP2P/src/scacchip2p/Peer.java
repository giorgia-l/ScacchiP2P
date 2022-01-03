/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchip2p;

import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Alber
 */
public class Peer {

    Server server;
    Client client;
    DatiCondivisi dati;
    Player giocatore;

    public Peer(String nome, String ipDestinatario, int portDestinatario) throws SocketException, UnknownHostException {
        server = new Server(42069);
        this.client = new Client(ipDestinatario, portDestinatario);
        dati = new DatiCondivisi();
        giocatore = new Player(nome);
    }

    public Peer(String nome, int port, String ipDestinatario, int portDestinatario) throws SocketException, UnknownHostException {
        this.server = new Server(port);
        this.client = new Client(ipDestinatario, portDestinatario);
        this.dati = new DatiCondivisi();
        giocatore = new Player(nome);
    }

    public Server getServer() {
        return server;
    }

    public Client getClient() {
        return client;
    }

    public DatiCondivisi getDati() {
        return dati;
    }

    public Player getGiocatore() {
        return giocatore;
    }

}