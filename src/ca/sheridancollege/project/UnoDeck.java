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
public class UnoDeck extends GroupOfCards{
    
    public UnoDeck(int size) {
        super(size);
        initializeDeck();
        shuffle();
    }
    
    private void initializeDeck(){
        for(UnoCard.Colour colour : UnoCard.Colour.values()){
            if (colour != UnoCard.Colour.WILD){
                // adding num cards here
                for (UnoCard.Value value : UnoCard.Value.values()){
                    cards.add(new UnoCard(colour, value));
                    if (value != UnoCard.Value.ONE){
                        cards.add(new UnoCard(colour, value));
                    }
                }
                // adding the special cards
                cards.add(new UnoCard(colour, UnoCard.Type.SKIP));
                cards.add(new UnoCard(colour, UnoCard.Type.REVERSE));
                cards.add(new UnoCard(colour, UnoCard.Type.DRAW_TWO));
            }
        }
        // adding the wild and wild_draw_four
        for (int i = 0; i < 4; i++) {
            cards.add(new UnoCard(UnoCard.Colour.WILD, UnoCard.Type.WILD));
            cards.add(new UnoCard(UnoCard.Colour.WILD, UnoCard.Type.WILD_DRAW_FOUR));
        }
    }
    
}
