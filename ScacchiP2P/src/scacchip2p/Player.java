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
    String colore;

    public Player(String nome, String colore) {
        this.nome = nome;
        this.colore = colore;
    }

    public Player() {
        nome="";
        colore="";
    }
    
    public Player(String nome){
        this.nome=nome;
        colore="";
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

}
