/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchip2p;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 *
 * @author Alber
 */
public class Peer {

    Server server;
    Client client;
    DatiCondivisi dati;
    Player giocatore;

    ElabortaT elabora;

    public Peer(String nome, String ipDestinatario, int portDestinatario) throws SocketException, UnknownHostException {
        server = new Server(42069);
        this.client = new Client(ipDestinatario, portDestinatario);
        dati = new DatiCondivisi();
        giocatore = new Player(nome);

        elabora = new ElabortaT(this);
    }

    public Peer(String nome, int port, String ipDestinatario, int portDestinatario) throws SocketException, UnknownHostException {
        this.server = new Server(port);
        this.client = new Client(ipDestinatario, portDestinatario);
        this.dati = new DatiCondivisi();
        giocatore = new Player(nome);

        elabora = new ElabortaT(this);
    }

    public Peer(String nome, int port, String ipDestinatario) throws SocketException, UnknownHostException {
        this.server = new Server();
        this.client = new Client(ipDestinatario,port);
        this.dati = new DatiCondivisi();
        giocatore = new Player(nome);

        elabora = new ElabortaT(this);
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

    public void avviaServer() {
        server.start();
    }

    public void avviaElabora() {
        elabora.start();
    }

    public synchronized ArrayList<String> leggoBuffer() {
        return server.bufferMessaggi;
    }

    public void chiudiTutto() {
//        elabora.interrupt();
        distruggiServer();
        distruggiClient();
        dati = new DatiCondivisi();
        Player giocatore;

    }

    public void stoppaServerTE() {
        server.puoRicevere=false;
        server.interrupt();
        elabora.interrupt();
    }

    public void distruggiServer() {
//        server.interrupt();
        server.chiudiServer();

    }

    public void distruggiClient() {
        client.chiudiClient();
    }
}
