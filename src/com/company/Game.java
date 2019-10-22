package com.company;

import com.company.Card;
import com.company.Deck;

import java.util.ArrayList;

public class Game
{
    Deck deck = new Deck();
    int size = 52;
    int result;
    Card card;
    ArrayList<Card> hand;
    int acesInHand;


    //strategie dealer
    public int dealer() {

        acesInHand = 0;
        deck.shuffle();
        int cardNumber = 0;
        result = deck.getCard(cardNumber).getCount();
        hand = new ArrayList<>();

        //high risk 21
        while (result < 21) {
            cardNumber++;
            if (deck.getCards().get(cardNumber).getSecondCount() > 0) {

                acesInHand++;
            }
            hand.add(deck.getCards().get(cardNumber));
            System.out.println(deck.getCards().get(cardNumber).getName());
            result = calculateResult(hand);
        }
        System.out.println("Rezultat: " + result +"\n");

        //medium risk 18
        while (result < 18) {
            cardNumber++;
            if (deck.getCards().get(cardNumber).getSecondCount() > 0) {

                acesInHand++;
            }
            hand.add(deck.getCards().get(cardNumber));
            System.out.println(deck.getCards().get(cardNumber).getName());
            result = calculateResult(hand);
        }
        System.out.println("Rezultat: " + result +"\n");

        //medium risk 18
        while (result < 18) {
            cardNumber++;
            if (deck.getCards().get(cardNumber).getSecondCount() > 0) {

                acesInHand++;
            }
            hand.add(deck.getCards().get(cardNumber));
            System.out.println(deck.getCards().get(cardNumber).getName());
            result = calculateResult(hand);
        }
        System.out.println("Rezultat: " + result +"\n");
        if (result == 21) {

            System.out.println("BLACKJACK");
        }
        return result;
    }


    //strategie player
    public int player() {

        acesInHand = 0;
        deck.shuffle();
        int cardNumber = 0;
        result = deck.getCard(cardNumber).getCount();
        hand = new ArrayList<>();

        //high risk
        while (result < 21) {
            cardNumber++;
            if (deck.getCards().get(cardNumber).getSecondCount() > 0) {

                acesInHand++;
            }
            hand.add(deck.getCards().get(cardNumber));
            System.out.println(deck.getCards().get(cardNumber).getName());
            result = calculateResult(hand);
        }
        System.out.println("Rezultat: " + result +"\n");

        //low risk 18
        while (result < 18) {
            cardNumber++;
            if (deck.getCards().get(cardNumber).getSecondCount() > 0) {

                acesInHand++;
            }
            hand.add(deck.getCards().get(cardNumber));
            System.out.println(deck.getCards().get(cardNumber).getName());
            result = calculateResult(hand);
        }
        System.out.println("Rezultat: " + result +"\n");

        if (result == 21) {

            System.out.println("BLACKJACK");
        }
        return result;
    }

    public int calculateResult(ArrayList<Card> cards) {
        int sum = 0;
        for (int j = acesInHand; j >= 0; j--) {
            sum = 0;
            for (int i = 0; i < cards.size(); i++) {
                int smallAcesInHand = acesInHand;
                if (cards.get(i).getSecondCount() > 0 && smallAcesInHand > 0) {
                    sum = sum + cards.get(i).getSecondCount();
                    smallAcesInHand--;
                } else {
                    sum = sum + cards.get(i).getCount();
                }
            }
            if (sum == 21) {
                return sum;
            }
        }
        return sum;
    }
}
