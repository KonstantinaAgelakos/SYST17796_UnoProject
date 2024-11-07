/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Konstantina
 */
public class UnoCard extends Card{
    
    public enum Colour {RED, YELLOW, GREEN, BLUE, WILD }
    public enum Type { NUMBER, SKIP, REVERSE, DRAW_TWO, WILD, WILD_DRAW_FOUR }
    public enum Value {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE}
    
    private final Colour colour;
    private final Type type;
    private final Value value;
    
    // constructor for number cards
    public UnoCard(Colour colour, Value value){
        this.colour = colour;
        this.type = Type.NUMBER;
        this.value = value;
    }
    
    // constructor for special cards
    public UnoCard(Colour colour, Type type) {
        this.colour = colour;
        this.type = type;
        this.value = null;
    }
    
    public Colour getColour(){
        return colour;
    }
    public Type getType(){
        return type;
    }
    public Value getValue(){
        return value;
    }

    @Override
    public String toString() {
        if (type == Type.NUMBER){
            return colour+" "+value; // will display num cards as colour and val
        } else{
            return colour+" "+type; // will display special cards as colour and type
        }
    }
    
}
