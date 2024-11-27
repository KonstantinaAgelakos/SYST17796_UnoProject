/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game.
 * Players have an identifier, which should be unique.
 * 
 * @author Konstantina
 * @author Alizeh Oct 2024
 */
public abstract class Player {

    private String name; // The unique name for this player
    private ArrayList<UnoCard> playerHand;
    private UnoCard lastPlayedCard; // Tracks the last card played by the player

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
        this.playerHand = new ArrayList<>();
        this.lastPlayedCard = null;
    }

    public String getName() {
        return name;
    }

    public ArrayList<UnoCard> getPlayerHand() {
        return playerHand;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Abstract method for a player to take their turn.
     * 
     * @param deck    the deck of UNO cards
     * @param topCard the current top card
     */
    public abstract void play(UnoDeck deck, UnoCard topCard);

    /**
     * Draws a card from the deck and adds it to the player's hand.
     * 
     * @param deck the deck of cards
     * @return the drawn card
     */
    public UnoCard drawCard(UnoDeck deck) {
        if (!deck.getCards().isEmpty()) {
            UnoCard drawnCard = (UnoCard) deck.getCards().remove(deck.getCards().size() - 1);
            playerHand.add(drawnCard);
            System.out.println(getName() + " draws a card: " + drawnCard);
            return drawnCard;
        }
        return null; // If the deck is empty, return null
    }

    /**
     * Sets the last played card.
     * 
     * @param card the card played by the player
     */
    public void setLastPlayedCard(UnoCard card) {
        this.lastPlayedCard = card;
    }

    /**
     * Gets the last played card.
     * 
     * @return the last played card
     */
    public UnoCard getLastPlayedCard() {
        return lastPlayedCard;
    }
}
