/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Konstantina
 */
public class UnoPlayer extends Player{

    public UnoPlayer(String name) {
        super(name);
    }

    @Override
    public void play(UnoDeck deck, UnoCard topCard) {
        Scanner scanner = new Scanner(System.in);
        
        //show player deck
        System.out.println("Your hand: " + getPlayerHand());
        System.out.println("Top Card: " + topCard);
        
        // prompt player to play a card or pick up a card
        System.out.print("Choose a card to play, or enter 0 to pick up a card: ");
        int choice = scanner.nextInt();
        
        if(choice == 0){
            //player picks up a card
            drawCard(deck);
        } else if (choice > 0 && choice <= getPlayerHand().size()){
            // player chooses a card ffrom teir hand
            UnoCard chosenCard = getPlayerHand().get(choice - 1);
            if(isValidCard(chosenCard, topCard)){
                getPlayerHand().remove(chosenCard); // play thi scard
                System.out.println(getName() + " plays: " + chosenCard);
            } else{
                System.out.println("Invalid card! Pick another card.");
                play(deck, topCard);
            }
        }else {
            System.out.println("Invalid choice! Please choose a valid card or press 0 to draw a card.");
            play(deck, topCard); // ask fro another input if invalid
        }
    }
   
    private boolean isValidCard(UnoCard card, UnoCard topCard){
        return card.getColour().equals(topCard.getColour()) ||
               card.getType().equals(topCard.getType()) ||
               (card.getType() == UnoCard.Type.NUMBER && card.getValue() == topCard.getValue());
    }
    
}
