package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class DeckTest {

    private Deck deck;
    private Deck deck2;
    private String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private String[] suits = {"diamonds", "clubs", "hearts", "spades"};
    private ArrayList<Card> cards = new ArrayList<Card>();

    @Before
    public void setUp() throws Exception {
        deck = new Deck();
        deck2 = new Deck();
    }

    @Test
    public void shuffle() {

       int j = 0;

        for(int i=0;i<deck.getCards().size();i++){
            assertEquals(deck.getCards().get(i).getName().concat(deck.getCards().get(i).getSuit()),deck2.getCards().get(i).getName().concat(deck2.getCards().get(i).getSuit()));
        }

        deck.shuffle();
        deck2.shuffle();
        for(int i=0;i<deck.getCards().size();i++){
            if( deck.getCards().get(i).getName().concat(deck.getCards().get(i).getSuit()) == deck2.getCards().get(i).getName().concat(deck2.getCards().get(i).getSuit()))
            {
                j++;
            }
        }
        assertNotEquals(52,j);

    }

    @Test
    public void getCards() {

        for(int i=0; i<deck.getCards().size(); i++){
            assertEquals(deck.getCards().get(i).getName(), names[i%13]);
        }

        for(int i=0; i<deck.getCards().size()/4; i++){
            assertEquals(deck.getCards().get(i).getSuit(), suits[0]);
        }

        for(int i=deck.getCards().size()/4; i<deck.getCards().size()/4*2; i++){
            assertEquals(deck.getCards().get(i).getSuit(), suits[1]);
        }

        for(int i=deck.getCards().size()/4*2; i<deck.getCards().size()/4*3; i++){
            assertEquals(deck.getCards().get(i).getSuit(), suits[2]);
        }

        for(int i=deck.getCards().size()/4*3; i<deck.getCards().size(); i++){
            assertEquals(deck.getCards().get(i).getSuit(), suits[3]);
        }

        //test that the number of cards is 52
        assertEquals(52, deck.getCards().size());
        //test if it returns an ArrayList
        assertEquals(cards.getClass(),deck.getCards().getClass());
        //test if the ArrayList given by getCards() is of Type Card.class
        assertTrue(cards.getClass().equals(deck.getCards().getClass()));
    }

    @Test
    public void getCard() {
        assertEquals("Ace",deck.getCard(0).getName());
        assertEquals("diamonds",deck.getCard(0).getSuit());
        assertEquals("King",deck.getCard(51).getName());
        assertEquals("spades",deck.getCard(51).getSuit());

        for(int i=0; i<deck.getCards().size(); i++){
            assertEquals(deck.getCards().get(i).getName(), names[i%13]);
        }

        for(int i=0; i<deck.getCards().size()/4; i++){
            assertEquals(deck.getCards().get(i).getSuit(), suits[0]);
        }

        for(int i=deck.getCards().size()/4; i<deck.getCards().size()/4*2; i++){
            assertEquals(deck.getCards().get(i).getSuit(), suits[1]);
        }

        for(int i=deck.getCards().size()/4*2; i<deck.getCards().size()/4*3; i++){
            assertEquals(deck.getCards().get(i).getSuit(), suits[2]);
        }

        for(int i=deck.getCards().size()/4*3; i<deck.getCards().size(); i++){
            assertEquals(deck.getCards().get(i).getSuit(), suits[3]);
        }

    }


}