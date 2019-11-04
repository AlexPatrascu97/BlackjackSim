package com.company;

import java.util.Scanner;

public class Blackjack
{
    public static void main(String[] args)
    {
        int dealerwins = 0;
        int playerwins = 0;
        int drawresult = 0;

        Game player = new Game();
        Game dealer = new Game();

        Scanner in = new Scanner(System.in);
        System.out.println("Legend for dealer: \n" +
            "low risk means he wil stop after reaching a number greater than 8\n"+
            "low-med riskmeans he wil stop after reaching a number greater than 10\n"+
            "med risk means he wil stop after reaching a number greater than 12\n"+
            "med-high risk means he wil stop after reaching a number greater than 14\n"+
            "high risk means he wil stop after reaching a number greater than 16\n");
        System.out.println("Legend for Player: \n" +
                "low risk means he wil stop after reaching a number greater than 12\n"+
                "low-med riskmeans he wil stop after reaching a number greater than 14\n"+
                "med risk means he wil stop after reaching a number greater than 16\n"+
                "med-high risk means he wil stop after reaching a number greater than 18\n"+
                "high risk means he wil aim for 21\n");

        System.out.println("Insert the number of deals");
        String counts = in.nextLine();
        System.out.println("Insert Dealer risk (low risk, low-med risk, med risk, med-high risk, high risk)");
        String riskdealer = in.nextLine();
        System.out.println("Insert Player risk (low risk, low-med risk, med risk, med-high risk, high risk)");
        String riskpayer = in.nextLine();




        for (int i=0; i <= Integer.parseInt(counts) - 1 ; i++) {

            //initializare player si dealer
            player.player(riskpayer);
            dealer.dealer(riskdealer);


            if(player.result > 21){
                dealerwins++;
                System.out.println("!!!!!!Dealer Wins!!!!!!\n");
            }
            //verificare blackjack pentru dealer si player
           else if ((dealer.result == 21 && player.result < 21) || (dealer.result == 21 && player.result > 21)) {
                dealerwins++;
                System.out.println("!!!!!!Dealer Wins!!!!!!\n");
            } else if ((player.result == 21 && dealer.result < 21) || (player.result == 21 && dealer.result > 21)) {
                playerwins++;
                System.out.println("!!!!!!Player Wins!!!!!!\n");
            }
            //verifica daca au sub 21
            else if (dealer.result < 21) {
                if ((player.result < 21) && (dealer.result > player.result)) {

                    //sub 21 , dar Dealerul are mai mult
                    dealerwins++;
                    System.out.println("!!!!!!Dealer Wins!!!!!!\n");

                } else if ((player.result < 21) && (dealer.result < player.result)) {
                    //sub 21 , dar Playerul are mai mult
                    playerwins++;
                    System.out.println("!!!!!!Player Wins!!!!!!\n");

                } else if (player.result > 21) {
                    //Dealerul sub 21, dar Playerul a trecut peste 21
                    dealerwins++;
                    System.out.println("!!!!!!Dealer Wins!!!!!!\n");
                }

            } else if (dealer.result > 21 && player.result < 21) {
                //Playerul sub 21, dar Dealerul a trecut peste 21
                playerwins++;
                System.out.println("!!!!!!Player Wins!!!!!!\n");

            } else if ((player.result == 21 && dealer.result == 21) || (player.result > 21 && dealer.result > 21)) {
                //situatia de blackjack egal sau ambele valori peste 21
                drawresult++;
                System.out.println("??????No winner, Next Deal??????\n");
            }

        }

        float playerpercent = ((float)(playerwins)/(float)(Integer.parseInt(counts)))*100;
        float dealerpercent = ((float)(dealerwins)/(float)(Integer.parseInt(counts)))*100;
        float kda = ((float)(playerwins)/(float)(dealerwins));

        System.out.println("Player Total wins: " + playerwins);
        System.out.println("Dealer Total wins: " + dealerwins);
        System.out.println("No winner results: " + drawresult);

        System.out.println("Player's win percent in " + riskpayer + " versus " + riskdealer +" is : " + playerpercent + "%");
        System.out.println("Dealers's win percent in " + riskdealer + " versus " + riskpayer +" is : " + dealerpercent + "%" );
        System.out.println("Players win/lose ratio in " + riskpayer + " versus " + riskdealer +" is : " + kda);
    }
}