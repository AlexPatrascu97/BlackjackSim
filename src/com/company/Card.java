package com.company;

public class Card
{
    int secondCount = -1;
    int count;
    String name;
    String suit;
    int[] counts = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1};
    String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    String[] suits = {"diamonds", "clubs", "hearts", "spades"};

    public Card(int num, int suit) {
        if((num <= 0 ) && (num >= 12)){
            throw new IndexOutOfBoundsException();
        }
        if((suit <= 0 ) && (suit >= 3)){
            throw new IndexOutOfBoundsException();
        }
        this.name = names[num];
        this.count = counts[num];
        this.suit = suits[suit];
    }

    public Card(int num1, int num2, int suit) {
        if((num1 <= 0 ) && (num1 >= 12)){
            throw new IndexOutOfBoundsException();
        }
        if((suit <= 0 ) && (suit >= 3)){
            throw new IndexOutOfBoundsException();
        }
        if ((num2 != 13) || (num1 != 0)){
            throw new IllegalArgumentException();
        }
        this.name = names[num1];
        this.count = counts[num1];
        this.secondCount = counts[num2];
        this.suit = suits[suit];

    }

    public String getName() {
        return name;
    }


    public int getCount() {
        return count;
    }

    public int getSecondCount() {
        return secondCount;
    }


    public String getSuit() {
        return suit;
    }

}
