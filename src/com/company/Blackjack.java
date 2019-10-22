package com.company;


import java.util.ArrayList;
import java.util.Collections;

public class Blackjack
{
    public static void main(String[] args)
    {
        // number of games
        int playCount = 100;

        int dealerwins = 0;
        int playerwins = 0;

        Game player = new Game();
        Game dealer = new Game();


        for (int i=0; i<=playCount; i++) {

            dealer.dealer();
            player.player();


            //verificare blackjack pentru dealer si player
            if ((dealer.result == 21 && player.result < 21) || (dealer.result == 21 && player.result > 21)) {
                dealerwins++;
                System.out.println("Dealer Wins");
            } else if ((player.result == 21 && dealer.result < 21) || (player.result == 21 && dealer.result > 21)) {
                playerwins++;
                System.out.println("Player Wins");
            }
            //verifica daca au sub 21
            else if (dealer.result < 21) {
                if ((player.result < 21) && (dealer.result > player.result)) {

                    //sub 21 , dar Dealerul are mai mult
                    dealerwins++;
                    System.out.println("Dealer Wins");

                } else if ((player.result < 21) && (dealer.result < player.result)) {
                    //sub 21 , dar Playerul are mai mult
                    playerwins++;
                    System.out.println("Player Wins");

                } else if (player.result > 21) {
                    //Dealerul sub 21, dar Playerul a trecut peste 21
                    dealerwins++;
                    System.out.println("Dealer Wins");
                }

            } else if (dealer.result > 21 && player.result < 21) {
                //Playerul sub 21, dar Dealerul a trecut peste 21
                playerwins++;
                System.out.println("Player Wins");

            } else if ((player.result == 21 && dealer.result == 21) || (player.result > 21 && dealer.result > 21)) {
                //situatia de blackjack egal sau ambele valori peste 21
                System.out.println("No winner, Next Deal");
            }

        }

        System.out.println("Player Total wins: " + playerwins);
        System.out.println("Dealer Total wins: " + dealerwins);
    }
}