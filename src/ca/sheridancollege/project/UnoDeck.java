/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * Represents a deck of UNO cards.
 * Initializes the deck with all standard UNO cards, including number and special cards.
 * 
 * @author Konstantina
 */
public class UnoDeck extends GroupOfCards {
    
    public UnoDeck(int size) {
        super(size);
        initializeDeck();
        shuffle();
    }
    
    /**
     * Initializes the UNO deck with all number cards, special cards, and wild cards.
     */
    private void initializeDeck() {
        for (UnoCard.Colour colour : UnoCard.Colour.values()) {
            if (colour != UnoCard.Colour.WILD) {
                // Adding number cards (using the Value enum for numbers)
                for (UnoCard.Value value : UnoCard.Value.values()) {
                    cards.add(new UnoCard(colour, value.ordinal())); // Added correct initialization
                    if (value.ordinal() != 0) { // Add a second copy for numbers 1 to 9
                        cards.add(new UnoCard(colour, value.ordinal()));
                    }
                }
                // Adding the special cards (Skip, Reverse, Draw Two)
                cards.add(new UnoCard(colour, UnoCard.Type.SKIP));
                cards.add(new UnoCard(colour, UnoCard.Type.SKIP));
                cards.add(new UnoCard(colour, UnoCard.Type.REVERSE));
                cards.add(new UnoCard(colour, UnoCard.Type.REVERSE));
                cards.add(new UnoCard(colour, UnoCard.Type.DRAW_TWO));
                cards.add(new UnoCard(colour, UnoCard.Type.DRAW_TWO));
            }
        }
        // Adding the wild cards (Wild and Wild Draw Four)
        for (int i = 0; i < 4; i++) {
            cards.add(new UnoCard(UnoCard.Colour.WILD, UnoCard.Type.WILD));
            cards.add(new UnoCard(UnoCard.Colour.WILD, UnoCard.Type.WILD_DRAW_FOUR));
        }
    }
    
}
