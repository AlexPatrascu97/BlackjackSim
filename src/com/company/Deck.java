package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        //forma
        for (short a = 0; a <= 3; a++) {
            //numar
            for (short b = 0; b <= 12; b++) {
                if (b == 0) {
                    //constructor as
                    cards.add(new Card(b, 13, a));
                } else {
                    //constructor carte normala
                    cards.add(new Card(b,a));
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card getCard(int i) {
        return cards.get(i);
    }

    public void  setCard(Card card,int poz) {
        cards.set(poz, card);
    }


}
