/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Konstantina
 */
public class UnoGame extends Game{
    private final UnoDeck deck;
    private UnoCard topCard;
    private int currentPI;

    public UnoGame(String name) {
        super(name);
        deck = new UnoDeck(180); // initialize deck
        currentPI = 0; // start w/ first player
    }
    
    

    @Override
    public void play() {
    // Give each player 7 cards
    for (Player player : getPlayers()) {
        for (int i = 0; i < 7; i++) {
            player.drawCard(deck);  // This works for both UnoPlayer and SystemUnoPlayer
        }
    }

    // Start the game with the first card at the top
    topCard = (UnoCard) deck.getCards().remove(deck.getCards().size() - 1);
    System.out.println("The starting card is: " + topCard);

    // Game loop
    boolean gameWon = false;
    Scanner scanner = new Scanner(System.in);

    while (!gameWon) {
        Player currentPlayer = getPlayers().get(currentPI);
        System.out.println(currentPlayer.getName() + "'s turn");
        System.out.println("Top Card: " + topCard);

        if (currentPlayer instanceof UnoPlayer) {
            // Human player's turn
            UnoPlayer unoPlayer = (UnoPlayer) currentPlayer;
            unoPlayer.play(deck, topCard);  // Ask human player to play a card
        } else if (currentPlayer instanceof SystemUnoPlayer) {
            // AI player's turn
            SystemUnoPlayer systemPlayer = (SystemUnoPlayer) currentPlayer;
            systemPlayer.play(deck, topCard);  // System plays automatically
        }

        // Check for winner and exit loop if there's a winner
        if (currentPlayer.getPlayerHand().isEmpty()) {
            gameWon = true;  // Game ends when player has no more cards
            System.out.println(currentPlayer.getName() + " wins!");
        }

        // Change players
        currentPI = (currentPI + 1) % getPlayers().size();
    }

        // call declareWinner method when a player finishes their cards
        declareWinner();
        
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
