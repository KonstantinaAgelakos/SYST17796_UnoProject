/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Konstantina
 */
public class Main {
    public static void main(String[] args) {
        // create new game
        UnoGame game = new UnoGame("UNO Game!");
        
        // create players
        UnoPlayer user = new UnoPlayer("Konstantina"); // user player
        SystemUnoPlayer systemPlayer = new SystemUnoPlayer("Alizeh") {}; // system player

        
        // add players to game
        game.setPlayers(new ArrayList<>(Arrays.asList(user, systemPlayer)));
        
        // start game
        game.play();
    }
}
