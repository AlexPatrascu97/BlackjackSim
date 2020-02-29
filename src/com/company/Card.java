package com.company;
/*
JUnit4 test cases with expected exceptions are shown as not covered even
though they were executed. The reason for this is that underlying JaCoCo
code coverage library only considers code as executed when certain probes
are executed. For successful test cases marked with @Test{expected=...}
this is not the case.
 */

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
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        if((suit <= 0 ) && (suit >= 3)){
            throw new IndexOutOfBoundsException();
        }
        this.name = names[num];
        this.count = counts[num];
        this.suit = suits[suit];
    }

    public Card(int num1, int num2, int suit) {
        if((num1 != 0) || (num2 != 13)){
            throw new IllegalArgumentException();
        }
        if((suit <= 0 ) && (suit >= 3)){
            throw new IndexOutOfBoundsException();
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
