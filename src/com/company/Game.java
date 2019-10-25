package com.company;

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
    public int dealer(String strat) {

        acesInHand = 0;
        deck.shuffle();
        int cardNumber = 0;
        result = deck.getCard(cardNumber).getCount();
        hand = new ArrayList<>();

        switch(strat) {

            //high risk 16
            case "high risk":
            while (result < 16) {
                result = 0;
                cardNumber++;
                if (deck.getCards().get(cardNumber).getSecondCount() > 0) {

                    acesInHand++;
                }
                hand.add(deck.getCards().get(cardNumber));
                System.out.println("Dealer Draw: " + deck.getCards().get(cardNumber).getName());
                result = calculateResult(hand);

            }
                //hidden card

                System.out.println("Hidden card: " + deck.getCards().get(cardNumber + 1).getName());
                result= calculateResult(hand) + deck.getCards().get(cardNumber + 1).getCount() ;
                System.out.println("Dealer Result: " + result + "\n");
                break;

                //medium-high risk 14
            case "med-high risk":
                while (result < 14) {

                    result = 0;
                    cardNumber++;
                    if (deck.getCards().get(cardNumber).getSecondCount() > 0) {

                        acesInHand++;
                    }
                    hand.add(deck.getCards().get(cardNumber));
                    System.out.println("Dealer Draw: " + deck.getCards().get(cardNumber).getName());
                    result = calculateResult(hand);
                }
                //hidden card

                System.out.println("Hidden card: " + deck.getCards().get(cardNumber + 1).getName());
                result= calculateResult(hand) + deck.getCards().get(cardNumber + 1).getCount() ;
                System.out.println("Dealer Result: " + result + "\n");
                break;

                //medium risk 12
            case "med risk":
                result = 0;
                while (result < 12) {
                    result = 0;
                    cardNumber++;
                    if (deck.getCards().get(cardNumber).getSecondCount() > 0) {

                        acesInHand++;
                    }
                    hand.add(deck.getCards().get(cardNumber));
                    System.out.println("Dealer Draw: " + deck.getCards().get(cardNumber).getName());
                    result = calculateResult(hand);
                }
                //hidden card

                System.out.println("Hidden card: " + deck.getCards().get(cardNumber + 1).getName());
                result= calculateResult(hand) + deck.getCards().get(cardNumber + 1).getCount() ;
                System.out.println("Dealer Result: " + result + "\n");
                break;

                //low-medium risk 10
            case "low-med risk":
                while (result < 10) {
                    result = 0;
                    cardNumber++;
                    if (deck.getCards().get(cardNumber).getSecondCount() > 0) {

                        acesInHand++;
                    }
                    hand.add(deck.getCards().get(cardNumber));
                    System.out.println("Dealer Draw: " + deck.getCards().get(cardNumber).getName());
                    result = calculateResult(hand);
                }
                //hidden card

                System.out.println("Hidden card: " + deck.getCards().get(cardNumber + 1).getName());
                result= calculateResult(hand) + deck.getCards().get(cardNumber + 1).getCount() ;
                System.out.println("Dealer Result: " + result + "\n");
                break;


                //low risk 8
            case "low risk":
                result = 0;
                while (result < 8) {
                    cardNumber++;
                    if (deck.getCards().get(cardNumber).getSecondCount() > 0) {

                        acesInHand++;
                    }
                    hand.add(deck.getCards().get(cardNumber));
                    System.out.println("Dealer Draw: " + deck.getCards().get(cardNumber).getName());
                    result = calculateResult(hand);
                }
                //hidden card

                System.out.println("Hidden card: " + deck.getCards().get(cardNumber + 1).getName());
                result= calculateResult(hand) + deck.getCards().get(cardNumber + 1).getCount() ;
                System.out.println("Dealer Result: " + result + "\n");
                break;

        }

        if (result == 21) {

            System.out.println("BLACKJACK");
        }
        return result;
    }

    //strategie player
    public int player(String strat) {

        acesInHand = 0;
        deck.shuffle();
        int cardNumber = 0;
        result = deck.getCard(cardNumber).getCount();
        hand = new ArrayList<>();

        switch(strat) {

            //high risk 21
            case "high risk":
                while (result < 21) {
                    cardNumber++;
                    if (deck.getCards().get(cardNumber).getSecondCount() > 0) {

                        acesInHand++;
                    }
                    hand.add(deck.getCards().get(cardNumber));
                    System.out.println("Player Draw: " + deck.getCards().get(cardNumber).getName());
                    result = calculateResult(hand);
                }
                System.out.println("Rezultat: " + result + "\n");
                break;

                //medium-high risk 18
            case "med-high risk":
                while (result < 18) {
                    cardNumber++;
                    if (deck.getCards().get(cardNumber).getSecondCount() > 0) {

                        acesInHand++;
                    }
                    hand.add(deck.getCards().get(cardNumber));
                    System.out.println("Player Draw: " + deck.getCards().get(cardNumber).getName());
                    result = calculateResult(hand);
                }
                System.out.println("Rezultat: " + result + "\n");
                break;

                //medium risk 16
            case "med risk":
                while (result < 16) {
                    cardNumber++;
                    if (deck.getCards().get(cardNumber).getSecondCount() > 0) {

                        acesInHand++;
                    }
                    hand.add(deck.getCards().get(cardNumber));
                    System.out.println("Player Draw: " + deck.getCards().get(cardNumber).getName());
                    result = calculateResult(hand);
                }
                System.out.println("Player Rezult: " + result + "\n");
                break;

                //low-medium risk 12
            case "low-med risk":
                while (result < 14) {
                    cardNumber++;
                    if (deck.getCards().get(cardNumber).getSecondCount() > 0) {

                        acesInHand++;
                    }
                    hand.add(deck.getCards().get(cardNumber));
                    System.out.println("Player Draw: " + deck.getCards().get(cardNumber).getName());
                    result = calculateResult(hand);
                }
                System.out.println("Rezultat: " + result + "\n");
                break;


                //low risk 10
            case "low risk":
                while (result < 12) {
                    cardNumber++;
                    if (deck.getCards().get(cardNumber).getSecondCount() > 0) {

                        acesInHand++;
                    }
                    hand.add(deck.getCards().get(cardNumber));
                    System.out.println("Player Draw: " + deck.getCards().get(cardNumber).getName());
                    result = calculateResult(hand);
                }
                System.out.println("Rezultat: " + result + "\n");
                break;


        }

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
