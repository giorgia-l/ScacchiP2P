/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchip2p;

/**
 *
 * @author Alber
 */
public class DatiCondivisi {
    
    Server server;
    Client client;
    Player player;
    
    String messaggioRicevuto;

    public  DatiCondivisi() {
        server=new Server(this);
        client=new Client();
        player=new Player();
    }

    public Server getServer() {
        return server;
    }

    public Client getClient() {
        return client;
    }

    public Player getPlayer() {
        return player;
    }
    
}
