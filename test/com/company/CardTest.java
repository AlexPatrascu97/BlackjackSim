package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    private Card Ace;
    private Card King;
    private Card Quenn;
    private Card Jack;
    private Card Ace2ndConstructor;

    @Before
    public void CardTestSetup() {

       Ace = new Card( 0, 0);
       King = new Card(12,1);
       Quenn = new Card(11,2);
       Jack = new Card(10,3);
       Ace2ndConstructor = new Card(0,13,0);
    }

    @Test
    public void getName() {
        assertEquals("King", King.getName());
        assertEquals("Queen", Quenn.getName());
        assertEquals("Jack", Jack.getName());
    }

    @Test
    public void getCount() {
        assertEquals(11, Ace.getCount());
        assertEquals(11, Ace2ndConstructor.getCount());
        assertEquals(10, King.getCount());
        assertEquals(10, Quenn.getCount());
        assertEquals(10, Jack.getCount());
    }

    @Test
    public void getSecondCount() {
        assertEquals(-1, King.getSecondCount());
        assertEquals(-1, Quenn.getSecondCount());
        assertEquals(-1, Jack.getSecondCount());
        assertEquals(1, Ace2ndConstructor.getSecondCount());
    }

    @Test
    public void getSuit() {
        assertEquals("diamonds", Ace.getSuit());
        assertEquals("clubs", King.getSuit());
        assertEquals("hearts", Quenn.getSuit());
        assertEquals("spades", Jack.getSuit());
    }

    @Test(expected = IndexOutOfBoundsException.class )
    public void invalidCardNumber() {
      new Card(13,1);
      new Card(-1,1);
    }

    @Test(expected = IndexOutOfBoundsException.class )
    public void invalidCardSuit() {
        new Card(7,6);
    }

    @Test(expected = IllegalArgumentException.class )
    public void invalidAceSecondValue() {
        Card Ace = new Card(0,7,0);
    }

    @Test(expected = IllegalArgumentException.class )
    public void notAnAceCard() {
        Card Ace = new Card(3,13,0);
    }
}