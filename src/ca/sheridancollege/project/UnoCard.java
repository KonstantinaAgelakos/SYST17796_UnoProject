/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * Represents a single UNO card with a color and type.
 * Can represent number cards or special cards like Skip, Reverse, Draw Two, and Wild.
 * 
 * @author Konstantina
 */
public class UnoCard extends Card {

    public enum Colour { RED, YELLOW, GREEN, BLUE, WILD }
    public enum Type { NUMBER, SKIP, REVERSE, DRAW_TWO, WILD, WILD_DRAW_FOUR }
    public enum Value {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE}

    private Colour colour;
    private final Type type;
    private final Integer value; // Integer for number cards, null for special cards

    public UnoCard(Colour colour, Integer value) {
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

    public Colour getColour() {
        return colour;
    }

    public Type getType() {
        return type;
    }

    public Integer getValue() {
        return value;
    }

    public void setColour(Colour colour) {
        if (type == Type.WILD || type == Type.WILD_DRAW_FOUR) {
            this.colour = colour;
        }
    }

    /**
     * Checks if the card is a wild card.
     * 
     * @return true if the card is a wild card, false otherwise
     */
    public boolean isWild() {
        return type == Type.WILD || type == Type.WILD_DRAW_FOUR;
    }

    @Override
    public String toString() {
        return type == Type.NUMBER ? colour + " " + value : colour + " " + type;
    }
}
