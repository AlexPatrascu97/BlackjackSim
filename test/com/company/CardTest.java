package com.company;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
//librarie extra
import static org.assertj.core.api.Assertions.*;

public class CardTest {

    private Card Ace;
    private Card King;
    private Card Quenn;
    private Card Jack;
    private Card Ace2ndConstructor;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    //initilizare obiecte pentru testare inaintea lor
    @Before
    public void CardTestSetup() {

       Ace = new Card( 0, 0);
       King = new Card(12,1);
       Quenn = new Card(11,2);
       Jack = new Card(10,3);
       Ace2ndConstructor = new Card(0,13,0);

    }

    //testam metoda getName din clasa Card
    @Test
    public void getName() {
        assertEquals("King", King.getName());
        assertEquals("Queen", Quenn.getName());
        assertEquals("Jack", Jack.getName());
    }

    //testam metoda getCount "valoarea cartii in jocul de blackjack" din clasa Card
    @Test
    public void getCount() {
        assertEquals(11, Ace.getCount());
        assertEquals(11, Ace2ndConstructor.getCount());
        assertEquals(10, King.getCount());
        assertEquals(10, Quenn.getCount());
        assertEquals(10, Jack.getCount());
    }

    //testam metoda getSecondCount "valoarea unui As in jocul de blackjack" din clasa Card
    @Test
    public void getSecondCount() {
        assertEquals(-1, King.getSecondCount());
        assertEquals(-1, Quenn.getSecondCount());
        assertEquals(-1, Jack.getSecondCount());
        assertEquals(1, Ace2ndConstructor.getSecondCount());
    }

    //testam metoda getSuit pentru a vedea simbolul unei carti
    @Test
    public void getSuit() {
        assertEquals("diamonds", Ace.getSuit());
        assertEquals("clubs", King.getSuit());
        assertEquals("hearts", Quenn.getSuit());
        assertEquals("spades", Jack.getSuit());
    }

    //testam cazul unei carti inavalide din punct de vedere al valorii
    @Test(expected = IndexOutOfBoundsException.class )
    public void invalidCardNumber() throws Exception {
      Card Invalid = new Card(13,1);
      Card Invalid2 = new Card(-1,1);
    }

    //fortam o carte cu valoare de simbol gresite
    @Test(expected = IndexOutOfBoundsException.class )
    public void invalidCardSuit()
    {
        new Card(7,6);
    }

    //fortam un As cu a doua valoare gresita
    @Test(expected = IllegalArgumentException.class )
    public void invalidAceSecondValue()
    {
        Card Ace = new Card(0,7,0);
    }

    //un As corect Card Ace = new Card(0,13,0);

    //fortam un As cu prima valoare gresita
    @Test(expected = IllegalArgumentException.class )
    public void notAnAceCard()
    {
        Card Ace = new Card(3,13,0);
    }

    //testam o carte invalida din punct de vedere al valorii folosind libraria assertJ
    @Test
    public void invalidCardNumberAssertJ() {

        assertThatThrownBy(() -> new Card(13,0))
                .isInstanceOf(IndexOutOfBoundsException.class);

        assertThatThrownBy(() -> new Card(-1,0))
                .isInstanceOf(IndexOutOfBoundsException.class);


    }

    //testam o carte invalida din punct de vedere al formei folosind libraria assertJ
    @Test
    public void invalidCardSuitAssertJ() {

        assertThatThrownBy(() -> new Card(4,6))
                .isInstanceOf(IndexOutOfBoundsException.class);

        assertThatThrownBy(() -> new Card(8,5))
                .isInstanceOf(IndexOutOfBoundsException.class);

        assertThatThrownBy(() -> new Card(0,13,5))
                .isInstanceOf(IndexOutOfBoundsException.class);


    }

    //testam o carte invalida din punct de vedere al formei folosind libraria assertJ
    @Test
    public void invalidAceSecondValueAssertJ() {

        assertThatThrownBy(() ->  new Card(0,7,0))
                .isInstanceOf(IllegalArgumentException.class);

    }

    //fortam un As cu prima valoare gresita folosind libraria assertJ
    @Test
    public void notAnAceCardAssertJ() {

        assertThatThrownBy(() ->  new Card(3,13,0))
                .isInstanceOf(IllegalArgumentException.class);

    }

    //testam o carte gresita din punct de vedere al valorii
    // folosind metoda expect a clasei exception
    @Test
    public void doStuffThrowsIndexOutOfBoundsException() {
        exception.expect(IndexOutOfBoundsException.class);
        new Card(13,1);
    }

    //fortam forma gresita si o testam cu ajutorul metodei assertEquals
    @Test
    public void forcingWrongSuit(){
        Card suitCard = new Card(0,0);
        suitCard.suit = "clubs";
        assertEquals("clubs",suitCard.getSuit());
    }

}