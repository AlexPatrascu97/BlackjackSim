package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class BlackjackTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void main() throws FileNotFoundException {
        System.out.println("main");
        String[] args = null;
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File("C:\\Users\\Frosch\\Documents\\GitHub\\BlackjackSim\\src\\com\\company\\inputMain.txt"));
        System.setIn(fips);
        Blackjack.main(args);
        System.setIn(original);
    }


    @Test
    public void over21() throws FileNotFoundException {
        System.out.println("main");
        String[] args = null;
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File("C:\\Users\\Frosch\\Documents\\GitHub\\BlackjackSim\\src\\com\\company\\inputMainConditions.txt"));
        System.setIn(fips);

        Card King = new Card(12,1);
        for (int i = 0; i < 52; i++) {
            Blackjack.player.deck.setCard(King, i);
        }

        Blackjack.main(args);
        assertEquals(30,Blackjack.player.result);

        System.setIn(original);
    }

}