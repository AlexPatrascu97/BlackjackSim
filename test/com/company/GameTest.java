package com.company;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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

    @Test
    public void dealer() {

        highDealer.dealer("high risk");
        medHighDealer.dealer("med-high risk");
        medDealer.dealer("med risk");
        lowMedDealer.dealer("low-med risk");
        lowDealer.dealer("low risk");

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

    @Test
    public void player() {

        highPlayer.player("high risk");
        medHighPlayer.player("med-high risk");
        medPlayer.player("med risk");
        lowMedPlayer.player("low-med risk");
        lowPlayer.player("low risk");

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

    @Test
    public void calculateResultForTwoAces() {
        Card Ace1 = new Card(0,13,0);
        Card Ace2 = new Card(0,13,1);
        assertEquals("Ace", Ace1.getName());
        assertEquals("Ace", Ace2.getName());

        ArrayList<Card> Cards = new ArrayList<Card>();
        Cards.add(Ace1);
        Cards.add(Ace2);

        Game calcTest = new Game();
        calcTest.acesInHand = 2;
        int resTwoAces = calcTest.calculateResult(Cards,21);

        assertEquals(2,resTwoAces);

    }

    @Test
    public void calculateResultForOneAces() {
        Card Ace = new Card(0,13,0);
        Card King = new Card(11,1);
        assertEquals("Ace", Ace.getName());
        assertEquals("Queen", King.getName());

        ArrayList<Card> Cards = new ArrayList<Card>();
        Cards.add(King);
        Cards.add(Ace);


        Game calcTest = new Game();
        calcTest.acesInHand = 1;
        int resOneAce = calcTest.calculateResult(Cards,21);

        assertEquals(21,resOneAce);

    }

    @Test
    public void calculateResultForOneAcesForBlackJack() {
        Card Ace = new Card(0,13,0);
        Card King = new Card(12,1);
        assertEquals("Ace", Ace.getName());
        assertEquals("King", King.getName());

        ArrayList<Card> Cards = new ArrayList<Card>();
        Cards.add(King);
        Cards.add(Ace);

        Game calcTest = new Game();
        calcTest.acesInHand = 1;
        int resOneAce = calcTest.calculateResult(Cards,21);

        assertEquals(21,resOneAce);

    }

    @Test
    public void calculateResultForHighRisksPlayer() {

        Card Four = new Card(3,0);
        Card King = new Card(12,1);
        Card Seven = new Card(6,1);
        assertEquals("4", Four.getName());
        assertEquals("King", King.getName());
        assertEquals("7", Seven.getName());

        ArrayList<Card> Cards = new ArrayList<Card>();
        Cards.add(King);
        Cards.add(Seven);
        Cards.add(Four);


        Game calcTest = new Game();
        int resOneAce = calcTest.calculateResult(Cards,21);

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

}