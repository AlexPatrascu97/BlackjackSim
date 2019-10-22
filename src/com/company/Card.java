package com.company;

public class Card
{
    int secondCount = -1;
    int count;
    String name;
    int[] counts = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
    String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    public Card(int num) {
        this.name = names[num];
        this.count = counts[num];
    }

    public Card(int num1, int num2) {
        this.name = names[num1];
        this.count = counts[num1];
        this.secondCount = counts[num2];
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
}
