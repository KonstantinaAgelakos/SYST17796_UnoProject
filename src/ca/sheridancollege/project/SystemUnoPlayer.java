/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that represents the system player in the UNO game.
 * The system player plays cards automatically based on the top card.
 * 
 * @author Konstantina
 */
public class SystemUnoPlayer extends Player {

    public SystemUnoPlayer(String name) {
        super(name);
    }

    /**
     * The system automatically plays a card or draws a card if no valid card is available.
     * 
     * @param deck    the deck of UNO cards
     * @param topCard the current top card on the discard pile
     */
    @Override
    public void play(UnoDeck deck, UnoCard topCard) {
        UnoCard selectedCard = null;

        // Choose a valid card to play
        for (UnoCard card : getPlayerHand()) {
            if (isValidCard(card, topCard)) {
                selectedCard = card;
                break;
            }
        }

        if (selectedCard != null) {
            getPlayerHand().remove(selectedCard); // Remove the card from the system player's hand
            setLastPlayedCard(selectedCard); // Update the last played card (Added this line)
            System.out.println(getName() + " plays: " + selectedCard);

            // Handle wild card logic
            if (selectedCard.isWild()) {
                selectedCard.setColour(UnoCard.Colour.RED); // Example: Always sets RED (modify as needed)
                System.out.println(getName() + " sets the Wild card color to RED.");
            }
        } else {
            UnoCard drawnCard = drawCard(deck); // Draw a card if no valid card is available
            setLastPlayedCard(null); // No card was played
            System.out.println(getName() + " draws a card.");
        }
    }

    private boolean isValidCard(UnoCard card, UnoCard topCard) {
        // Cards are valid if their color or type matches the top cards color or type
        return card.getColour().equals(topCard.getColour()) ||
               card.getType().equals(topCard.getType()) ||
               card.isWild();
    }
}
