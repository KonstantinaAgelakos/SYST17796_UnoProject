/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A class that represents a human player in the UNO game.
 * The player interacts with the game by choosing cards or drawing from the deck.
 * 
 * @author Konstantina
 */
public class UnoPlayer extends Player {

    public UnoPlayer(String name) {
        super(name);
    }

    @Override
    public void play(UnoDeck deck, UnoCard topCard) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Your hand:");
            for (int i = 0; i < getPlayerHand().size(); i++) {
                System.out.println((i + 1) + ": " + getPlayerHand().get(i));
            }
            System.out.println("Top Card: " + topCard);

            System.out.print("Type the number of the card you want to play, or enter 0 to pick up a card: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                UnoCard drawnCard = drawCard(deck);
                System.out.println(getName() + " drew: " + drawnCard);

                if (isValidCard(drawnCard, topCard)) {
                    System.out.println("You can play the card you just drew. Playing: " + drawnCard);
                    getPlayerHand().remove(drawnCard);
                    setLastPlayedCard(drawnCard); // Update last played card
                } else {
                    System.out.println("You cannot play the drawn card. Moving to the next player's turn.");
                    setLastPlayedCard(null);
                }
            } else if (choice > 0 && choice <= getPlayerHand().size()) {
                UnoCard chosenCard = getPlayerHand().get(choice - 1);
                if (isValidCard(chosenCard, topCard)) {
                    getPlayerHand().remove(chosenCard);
                    System.out.println(getName() + " plays: " + chosenCard);
                    setLastPlayedCard(chosenCard); // Update last played card

                    if (chosenCard.isWild()) {
                        System.out.print("Choose a color (RED, YELLOW, GREEN, BLUE): ");
                        String color = scanner.next().toUpperCase();
                        chosenCard.setColour(UnoCard.Colour.valueOf(color));
                        System.out.println(getName() + " sets the Wild card color to: " + color);
                    }
                } else {
                    System.out.println("Invalid card! Try again.");
                    play(deck, topCard);
                }
            } else {
                System.out.println("Invalid choice! Please choose a valid card or press 0 to draw a card.");
                play(deck, topCard);
            }
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Please enter a valid number or color!");
            scanner.nextLine();
            play(deck, topCard);
        }
    }

    private boolean isValidCard(UnoCard card, UnoCard topCard) {
        return card.getColour().equals(topCard.getColour()) ||
               card.getType().equals(topCard.getType()) ||
               card.isWild();
    }
    
}
