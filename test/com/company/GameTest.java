package com.company;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static com.sun.javafx.fxml.expression.Expression.greaterThanOrEqualTo;
import static com.sun.javafx.fxml.expression.Expression.lessThanOrEqualTo;
import static org.assertj.core.api.Assertions.*;

import static org.junit.Assert.*;

public class GameTest {

    private Game lowDealer;
    private Game lowMedDealer;
    private Game medDealer;
    private Game medHighDealer;
    private Game highDealer;

    private Game lowPlayer;
    private Game lowMedPlayer;
    private Game medPlayer;
    private Game medHighPlayer;
    private Game highPlayer;


    //initializam obiectele pentru testare
    @Before
    public void CardTestSetup() {

        highDealer = new Game();
        medHighDealer = new Game();
        medDealer = new Game();
        lowMedDealer = new Game();
        lowDealer = new Game();

        highPlayer = new Game();
        medHighPlayer = new Game();
        medPlayer = new Game();
        lowMedPlayer = new Game();
        lowPlayer = new Game();

    }

    //testam daca initializarea unui dealer cu strategia specificata este corecta
    @Test
    public void dealer() {

        //setam fiecare strategie pentru un dealer
        highDealer.dealer("high risk");
        medHighDealer.dealer("med-high risk");
        medDealer.dealer("med risk");
        lowMedDealer.dealer("low-med risk");
        lowDealer.dealer("low risk");

        //folosind metoda isGreaterThanOrEqualTo pentru a verifica daca valoarea este <= 17
        //stategia dealerului la risk mare este de a avea valoarea 17 in mana
        //astfel acesta nu poate avea o valoarea mai mica de 17, cea ce putem testa
        //aceasta tehnica este aplicata si pentru restul strategiilor
        int resHighDealer = highDealer.dealer("high risk");
        assertThat(resHighDealer).isGreaterThanOrEqualTo(17);

        int resMedHighDealer = medHighDealer.dealer("med-high risk");
        assertThat(resMedHighDealer).isGreaterThanOrEqualTo(14);

        int resMedDealer = medDealer.dealer("med risk");
        assertThat(resMedDealer).isGreaterThanOrEqualTo(12);

        int resLowMedDealer =lowMedDealer.dealer("low-med risk");
        assertThat(resLowMedDealer).isGreaterThanOrEqualTo(10);

        int resLowDealer = lowDealer.dealer("low risk");
        assertThat(resLowDealer).isGreaterThanOrEqualTo(8);

    }

    //testam daca initializarea unui player cu strategia specificata este corecta
    @Test
    public void player() {

        //setam fiecare strategie pentru un player
        highPlayer.player("high risk");
        medHighPlayer.player("med-high risk");
        medPlayer.player("med risk");
        lowMedPlayer.player("low-med risk");
        lowPlayer.player("low risk");

        //folosind metoda isGreaterThanOrEqualTo pentru a verifica daca valoarea este <= 21
        //stategia playerului la risk mare este de a avea valoarea 21 in mana
        //astfel acesta nu poate avea o valoarea mai mica de 21, cea ce putem testa
        //aceasta tehnica este aplicata si pentru restul strategiilor
        int resHighPlayer = highPlayer.player("high risk");
        assertThat(resHighPlayer).isGreaterThanOrEqualTo(21);

        int resMedHighPlayer = medHighPlayer.player("med-high risk");
        assertThat(resMedHighPlayer).isGreaterThanOrEqualTo(18);

        int resMedPLayer = medPlayer.player("med risk");
        assertThat(resMedPLayer).isGreaterThanOrEqualTo(16);

        int resLowMedPlayer =lowMedPlayer.player("low-med risk");
        assertThat(resLowMedPlayer).isGreaterThanOrEqualTo(14);

        int resLowPlayer = lowPlayer.player("low risk");
        assertThat(resLowPlayer).isGreaterThanOrEqualTo(12);

    }

    //calculam rezultatul atunci cand avem 2 asi in mana
    //daca avem 2 Asi rezultatul este 22 cea cea inseamna ca depasim
    //astfel se va alege valoarea de 1 pentru cei 2 Asi daca se depaseste
    //Ambii Asi trebuie sa aiba aceasi valoare 1 sau 11
    @Test
    public void calculateResultForTwoAces() {
        //initializam 2 carti si le verificam
        Card Ace1 = new Card(0,13,0);
        Card Ace2 = new Card(0,13,1);
        assertEquals("Ace", Ace1.getName());
        assertEquals("Ace", Ace2.getName());

        //fortam 2 Asi in pachet
        ArrayList<Card> Cards = new ArrayList<Card>();
        Cards.add(Ace1);
        Cards.add(Ace2);

        Game calcTest = new Game();
        calcTest.acesInHand = 2;
        int resTwoAces = calcTest.calculateResult(Cards,21);

        //verificam
        assertEquals(2,resTwoAces);

    }

    //calcumlam rezultatul in cazul unui singur As
    @Test
    public void calculateResultForOneAces() {
        //initializam 2 carti si le verificam
        Card Ace = new Card(0,13,0);
        Card King = new Card(11,1);
        assertEquals("Ace", Ace.getName());
        assertEquals("Queen", King.getName());

        //fortam un As si un Rege
        ArrayList<Card> Cards = new ArrayList<Card>();
        Cards.add(King);
        Cards.add(Ace);

        //fortam un meci prestabilit
        Game calcTest = new Game();
        calcTest.acesInHand = 1;
        int resOneAce = calcTest.calculateResult(Cards,21);

        //verificam
        assertEquals(21,resOneAce);

    }


    //calcumlam rezultatul in cazul unui singur As in caz de Blackjack
    @Test
    public void calculateResultForOneAcesForBlackJack() {
        //initializam 2 carti si le verificam
        Card Ace = new Card(0,13,0);
        Card King = new Card(12,1);
        assertEquals("Ace", Ace.getName());
        assertEquals("King", King.getName());

        //fortam un As si un Rege
        ArrayList<Card> Cards = new ArrayList<Card>();
        Cards.add(King);
        Cards.add(Ace);

        //fortam un meci prestabilit
        Game calcTest = new Game();
        calcTest.acesInHand = 1;
        int resOneAce = calcTest.calculateResult(Cards,21);

        //verificam
        assertEquals(21,resOneAce);

    }

    //calculam rezultatul in cazul unui meci al playerului si al dealerului cu
    // risk mare, mediu-mare, mediu, mic-mediu, mic
    //prezentat un urmatoarele 10 teste
    @Test
    public void calculateResultForHighRisksPlayer() {

        //initializam cartile
        Card Four = new Card(3,0);
        Card King = new Card(12,1);
        Card Seven = new Card(6,1);
        assertEquals("4", Four.getName());
        assertEquals("King", King.getName());
        assertEquals("7", Seven.getName());

        //fortam cartile in pachet
        ArrayList<Card> Cards = new ArrayList<Card>();
        Cards.add(King);
        Cards.add(Seven);
        Cards.add(Four);

        //fortam un meci prestabilit
        Game calcTest = new Game();
        int resOneAce = calcTest.calculateResult(Cards,21);

        //verificam
        assertEquals(21,resOneAce);

    }

    @Test
    public void calculateResultForMedHighRisksPlayer() {

        Card Ace = new Card(0,13,0);
        Card King = new Card(12,1);
        Card Seven = new Card(6,1);
        assertEquals("Ace", Ace.getName());
        assertEquals("King", King.getName());
        assertEquals("7", Seven.getName());

        ArrayList<Card> Cards = new ArrayList<Card>();
        Cards.add(King);
        Cards.add(Seven);
        Cards.add(Ace);


        Game calcTest = new Game();
        calcTest.acesInHand = 1;
        int resOneAce = calcTest.calculateResult(Cards,18);

        assertEquals(18,resOneAce);

    }

    @Test
    public void calculateResultForMedRisksPlayer() {

        Card Ace = new Card(0,13,0);
        Card King = new Card(12,1);
        Card Five = new Card(4,1);
        assertEquals("Ace", Ace.getName());
        assertEquals("King", King.getName());
        assertEquals("5", Five.getName());

        ArrayList<Card> Cards = new ArrayList<Card>();
        Cards.add(King);
        Cards.add(Five);
        Cards.add(Ace);


        Game calcTest = new Game();
        calcTest.acesInHand = 1;
        int resOneAce = calcTest.calculateResult(Cards,16);

        assertEquals(16,resOneAce);

    }

    @Test
    public void calculateResultForLowMedRisksPlayer() {

        Card Ace = new Card(0,13,0);
        Card King = new Card(12,1);
        Card Three = new Card(2,1);
        assertEquals("Ace", Ace.getName());
        assertEquals("King", King.getName());
        assertEquals("3", Three.getName());

        ArrayList<Card> Cards = new ArrayList<Card>();
        Cards.add(King);
        Cards.add(Three);
        Cards.add(Ace);


        Game calcTest = new Game();
        calcTest.acesInHand = 1;
        int resOneAce = calcTest.calculateResult(Cards,14);

        assertEquals(14,resOneAce);

    }

    @Test
    public void calculateResultForLowRisksPlayer() {

        Card Ace = new Card(0,13,0);
        Card Eight = new Card(7,1);
        Card Three = new Card(2,1);
        assertEquals("Ace", Ace.getName());
        assertEquals("8", Eight.getName());
        assertEquals("3", Three.getName());

        ArrayList<Card> Cards = new ArrayList<Card>();
        Cards.add(Eight);
        Cards.add(Three);
        Cards.add(Ace);


        Game calcTest = new Game();
        calcTest.acesInHand = 1;
        int resOneAce = calcTest.calculateResult(Cards,12);

        assertEquals(12,resOneAce);

    }

    @Test
    public void calculateResultForHighRisksDealer() {

        Card King = new Card(12,1);
        Card Seven = new Card(6,1);
        assertEquals("King", King.getName());
        assertEquals("7", Seven.getName());

        ArrayList<Card> Cards = new ArrayList<Card>();
        Cards.add(King);
        Cards.add(Seven);


        Game calcTest = new Game();
        int resOneAce = calcTest.calculateResult(Cards,17);

        assertEquals(17,resOneAce);

    }

    @Test
    public void calculateResultForMedHighRisksDealer() {

        Card King = new Card(12,1);
        Card Four = new Card(3,1);
        assertEquals("King", King.getName());
        assertEquals("4", Four.getName());

        ArrayList<Card> Cards = new ArrayList<Card>();
        Cards.add(King);
        Cards.add(Four);


        Game calcTest = new Game();
        int resOneAce = calcTest.calculateResult(Cards,14);

        assertEquals(14,resOneAce);

    }


    @Test
    public void calculateResultForMedRisksDealer() {

        Card King = new Card(12,1);
        Card Two = new Card(1,1);
        assertEquals("King", King.getName());
        assertEquals("2", Two.getName());

        ArrayList<Card> Cards = new ArrayList<Card>();
        Cards.add(King);
        Cards.add(Two);


        Game calcTest = new Game();
        int resOneAce = calcTest.calculateResult(Cards,12);

        assertEquals(12,resOneAce);

    }

    @Test
    public void calculateResultForLowMedRisksDealer() {

        Card Five = new Card(4,1);
        assertEquals("5", Five.getName());

        ArrayList<Card> Cards = new ArrayList<Card>();
        Cards.add(Five);
        Cards.add(Five);


        Game calcTest = new Game();
        int resOneAce = calcTest.calculateResult(Cards,10);

        assertEquals(10,resOneAce);

    }

    @Test
    public void calculateResultForLowRisksDealer() {

        Card Five = new Card(4,1);
        Card Three = new Card(2,1);
        assertEquals("5", Five.getName());
        assertEquals("3", Three.getName());

        ArrayList<Card> Cards = new ArrayList<Card>();
        Cards.add(Five);
        Cards.add(Three);


        Game calcTest = new Game();
        int resOneAce = calcTest.calculateResult(Cards,8);

        assertEquals(8,resOneAce);

    }


    //testam daca un dealer si un player
    //realizeaza un blackjack
    @Test
    public void playerBlackJack() {
        Game BJDeck = new Game();
        Card Ace = new Card(0, 13, 1);
        Ace.count = 21;
        for (int i = 0; i < 52; i++) {
            BJDeck.deck.setCard(Ace, i);
        }

        BJDeck.player("high risk");
        assertEquals(21,BJDeck.result);
    }

    @Test
    public void dealerBlackJack() {
        Game BJDeck = new Game();
        Card Ace = new Card(0, 13, 1);
        Ace.count = 21;
        for (int i = 0; i < 52; i++) {
            BJDeck.deck.setCard(Ace, i);
        }

        BJDeck.dealer("high risk");
        assertEquals(21,BJDeck.result);
    }


    @Test
    public void allRisksGetsAnAcePlayer() {
        Game AllAces = new Game();
        Card Ace = new Card(0,13,1);
        for(int i = 0; i<52; i++){
            AllAces.deck.setCard(Ace,i);
        }

        Game AllAces2 = new Game();
        for(int i = 0; i<52; i++){
            AllAces2.deck.setCard(Ace,i);
        }

        Game AllAces3 = new Game();
        for(int i = 0; i<52; i++){
            AllAces3.deck.setCard(Ace,i);
        }

        Game AllAces4 = new Game();
        for(int i = 0; i<52; i++){
            AllAces4.deck.setCard(Ace,i);
        }

        Game AllAces5 = new Game();
        for(int i = 0; i<52; i++){
            AllAces5.deck.setCard(Ace,i);
        }

        AllAces.player("high risk");
        assertThat(AllAces.acesInHand).isGreaterThanOrEqualTo(1);

        AllAces2.player("med-high risk");
        assertThat(AllAces2.acesInHand).isGreaterThanOrEqualTo(1);

        AllAces3.player("med risk");
        assertThat(AllAces3.acesInHand).isGreaterThanOrEqualTo(1);

        AllAces4.player("low-med risk");
        assertThat(AllAces4.acesInHand).isGreaterThanOrEqualTo(1);

        AllAces5.player("low risk");
        assertThat(AllAces5.acesInHand).isGreaterThanOrEqualTo(1);

    }


    @Test
    public void allRisksGetsAnAceDealer() {
        Game AllAces = new Game();
        Card Ace = new Card(0,13,1);
        for(int i = 0; i<52; i++){
            AllAces.deck.setCard(Ace,i);
        }

        Game AllAces2 = new Game();
        for(int i = 0; i<52; i++){
            AllAces2.deck.setCard(Ace,i);
        }

        Game AllAces3 = new Game();
        for(int i = 0; i<52; i++){
            AllAces3.deck.setCard(Ace,i);
        }

        Game AllAces4 = new Game();
        for(int i = 0; i<52; i++){
            AllAces4.deck.setCard(Ace,i);
        }

        Game AllAces5 = new Game();
        for(int i = 0; i<52; i++){
            AllAces5.deck.setCard(Ace,i);
        }

        AllAces.dealer("high risk");
        assertThat(AllAces.acesInHand).isGreaterThanOrEqualTo(1);

        AllAces2.dealer("med-high risk");
        assertThat(AllAces2.acesInHand).isGreaterThanOrEqualTo(1);

        AllAces3.dealer("med risk");
        assertThat(AllAces3.acesInHand).isGreaterThanOrEqualTo(1);

        AllAces4.dealer("low-med risk");
        assertThat(AllAces4.acesInHand).isGreaterThanOrEqualTo(1);

        AllAces5.dealer("low risk");
        assertThat(AllAces5.acesInHand).isGreaterThanOrEqualTo(1);

    }
}