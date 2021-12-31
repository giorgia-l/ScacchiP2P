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
    Player player1;
    Player player2;
    

    public  DatiCondivisi() {
        server=new Server();
        client=new Client();
        player1=new Player();
        player2=new Player();
    }

    public Server getServer() {
        return server;
    }

    public Client getClient() {
        return client;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
    
}
