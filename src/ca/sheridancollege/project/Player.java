/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author Konstantina
 * @author Alizeh Oct 2024
 */
public abstract class Player {

    private String name; //the unique name for this player
    private ArrayList<UnoCard> playerHand;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
        this.playerHand = new ArrayList<>();
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }
    
    public ArrayList<UnoCard> getPlayerHand(){
        return playerHand;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */
    public abstract void play(UnoDeck deck, UnoCard topCard);
    
    // added nov 6
    public void drawCard(UnoDeck deck){
        if(!deck.getCards().isEmpty()){
            UnoCard drawnCard = (UnoCard)deck.getCards().remove(deck.getCards().size()-1);
            playerHand.add(drawnCard);
            System.out.println(getName() + " draws a card: " + drawnCard);
        }
    }

}
