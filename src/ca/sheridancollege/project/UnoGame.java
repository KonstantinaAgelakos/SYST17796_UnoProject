/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * The class that models the UNO game.
 * Extends the Game class to provide specific functionality for UNO.
 * 
 * @author Konstantina
 */
public class UnoGame extends Game {
    private final UnoDeck deck; // The deck of UNO cards
    private UnoCard topCard;   // The top card on the discard pile
    private int currentPI;     // The index of the current player

    public UnoGame(String name) {
        super(name);
        deck = new UnoDeck(180); // Initialize the deck with 180 cards
        currentPI = 0; // Start with the first player
    }

    @Override
    public void play() {
        // Distribute 7 cards to each player at the start of the game
        for (Player player : getPlayers()) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(deck);
            }
        }

        // Start the game by placing the first card on the discard pile
        topCard = (UnoCard) deck.getCards().remove(deck.getCards().size() - 1);
        System.out.println("The starting card is: " + topCard);

        // Main game loop
        boolean gameWon = false;

        while (!gameWon) {
            Player currentPlayer = getPlayers().get(currentPI); // Get the current player
            System.out.println("\n" + currentPlayer.getName() + "'s turn");
            System.out.println("Top Card: " + topCard);

            // The player takes their turn
            currentPlayer.play(deck, topCard);

            // Update the top card if a card is played
            UnoCard playedCard = currentPlayer.getLastPlayedCard();
            if (playedCard != null) {
                topCard = playedCard;
                System.out.println("Top card updated to: " + topCard);
            } else {
                System.out.println(currentPlayer.getName() + " did not play a card.");
            }

            // Check if the current player has won the game
            if (currentPlayer.getPlayerHand().isEmpty()) {
                gameWon = true;
                System.out.println(currentPlayer.getName() + " wins!");
            }

            // Check if the deck is empty
            if (deck.getCards().isEmpty()) {
                System.out.println("The deck is empty! The game ends in a draw.");
                break;
            }

            // Move to the next player
            currentPI = (currentPI + 1) % getPlayers().size();
        }
    }

    @Override
    public void declareWinner() {
        for (Player player : getPlayers()) {
            if (player.getPlayerHand().isEmpty()) {
                System.out.println(player.getName() + " wins!");
                break;
            }
        }
    }
    
}
