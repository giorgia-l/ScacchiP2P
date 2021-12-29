/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scacchip2p;

/**
 *
 * @author Giorgia
 */
public class Player {/*salva su file, punti e so
                     che ho giocatore 
                     con quel nome*/
    String nome;
    int porta;

    public Player(String nome, int IP, int porta) {
        this.nome = nome;
        this.porta = porta;
    }

    public Player() {
    }        

    public String getNome() {
        return nome;
    }

    public int getPorta() {
        return porta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }    
}
