package sk.stuba.fei.uim.oop;

import java.util.Scanner;

public class Aim extends Card {
    public Aim (){
        name = "Aim";
    }

    @Override
    public void play(Card[] pond_spaces, boolean[] crosshairs, Player[] players,
                     Deck action_cards_deck,  Deck ducks_deck) {
        super.play(pond_spaces, crosshairs, players, action_cards_deck, ducks_deck);
        System.out.println("---------------------------------");
        System.out.println("Choose crosshair:");

        try {
            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
            if (num > 0 && num <= crosshairs.length)
                if (!crosshairs[num - 1])
                    crosshairs[num-1] = true;
                else{
                    System.out.println("You can only target a place that is not yet targeted.");
                    play(pond_spaces, crosshairs, players, action_cards_deck, ducks_deck);
                    return;
                }
            else{
                System.out.println("Please, input correct number");
                play(pond_spaces, crosshairs, players, action_cards_deck, ducks_deck);
                return;
            }
        }
        catch (java.util.InputMismatchException e){
            System.out.println("!!! invalid input !!!");
            play(pond_spaces, crosshairs, players, action_cards_deck, ducks_deck);
            return;
        }

    }
}
