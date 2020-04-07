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

    //initializam pachetele pentru testare
    @Before
    public void setUp() throws Exception {
        deck = new Deck();
        deck2 = new Deck();
    }

    //
    @Test
    public void shuffle() {

       int j = 0;

       //verificam daca cele 2 pachete sunte egale
        for(int i=0;i<deck.getCards().size();i++){
            assertEquals(deck.getCards().get(i).getName().concat(deck.getCards().get(i).getSuit()),deck2.getCards().get(i).getName().concat(deck2.getCards().get(i).getSuit()));
        }

        //amestecam pachetele
        deck.shuffle();
        deck2.shuffle();

        //contorizam aparitia cartilor pe pozitii identice in cele 2 pachete
        //daca este mai mica decat 52 inseamna ca pachetele sunt diferite
        for(int i=0;i<deck.getCards().size();i++){
            if( deck.getCards().get(i).getName().concat(deck.getCards().get(i).getSuit()) == deck2.getCards().get(i).getName().concat(deck2.getCards().get(i).getSuit()))
            {
                j++;
            }
        }
        assertNotEquals(52,j);

    }

    //testam metoda getCards din clasa Deck
    @Test
    public void getCards() {

        //iteram pachetul si verificam ordinea initializarii unui pachet
        for(int i=0; i<deck.getCards().size(); i++){
            assertEquals(deck.getCards().get(i).getName(), names[i%13]);
        }

        //iteram pachetul si verificam daca sunt initializare corect formele de diamond
        for(int i=0; i<deck.getCards().size()/4; i++){
            assertEquals(deck.getCards().get(i).getSuit(), suits[0]);
        }

        //iteram pachetul si verificam daca sunt initializare corect formele de club
        for(int i=deck.getCards().size()/4; i<deck.getCards().size()/4*2; i++){
            assertEquals(deck.getCards().get(i).getSuit(), suits[1]);
        }

        //iteram pachetul si verificam daca sunt initializare corect formele de hearth
        for(int i=deck.getCards().size()/4*2; i<deck.getCards().size()/4*3; i++){
            assertEquals(deck.getCards().get(i).getSuit(), suits[2]);
        }

        //iteram pachetul si verificam daca sunt initializare corect formele de spades
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


    //testam metoda getCard a clasei deck care intoarce un obiect card
    @Test
    public void getCard() {
        //verificam suita pentru un set de 4 carti
        assertEquals("Ace",deck.getCard(0).getName());
        assertEquals("diamonds",deck.getCard(0).getSuit());
        assertEquals("King",deck.getCard(51).getName());
        assertEquals("spades",deck.getCard(51).getSuit());

    }


    //initializam un pachet numai cu Asi testand metoda set din clasa deck
    @Test
    public void setCard() {
        Card Ace = new Card(0,13,0);
        Deck TestDeck = new Deck();
        for(int i = 0; i<52; i++){
            TestDeck.setCard(Ace,i);
        }
        TestDeck.getCards().forEach((card) -> assertEquals("Ace",card.getName()));

    }

}