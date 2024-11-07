/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Konstantina
 */
public class SystemUnoPlayer extends Player {
    public SystemUnoPlayer(String name) {
        super(name);
    }

    @Override
    public void play(UnoDeck deck, UnoCard topCard) {
        // AI selects a card to play automatically based on the top card
        UnoCard selectedCard = null;

        // Choose a card to play from the player's hand (just selecting the first valid card)
        for (UnoCard card : getPlayerHand()) {
            if (isValidCard(card, topCard)) {
                selectedCard = card;
                break;
            }
        }

        // If no valid card, draw a card
        if (selectedCard == null) {
            drawCard(deck);
            System.out.println(getName() + " draws a card.");
        } else {
            getPlayerHand().remove(selectedCard);
            System.out.println(getName() + " plays: " + selectedCard);
        }
    }

    private boolean isValidCard(UnoCard card, UnoCard topCard) {
        // Cards are valid if their color or type matches the top card's color or type
        return card.getColour().equals(topCard.getColour()) ||
               card.getType().equals(topCard.getType()) ||
               (card.getType() == UnoCard.Type.NUMBER && card.getValue() == topCard.getValue());
    }
}
