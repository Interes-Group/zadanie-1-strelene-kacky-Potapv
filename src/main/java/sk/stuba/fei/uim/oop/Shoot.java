package sk.stuba.fei.uim.oop;

import java.util.Objects;
import java.util.Scanner;

public class Shoot extends Card {
    public Shoot(){
        name = "Shoot";
    }
    @Override
    public void play(Card[] pond_spaces, boolean[] crosshairs, Player[] players,
                     Deck action_cards_deck,  Deck ducks_deck) {
        super.play(pond_spaces, crosshairs, players, action_cards_deck, ducks_deck);
        System.out.println("---------------------------------");
        System.out.println("Choose target:");
        try {
            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
            if (num > 0 && num <= crosshairs.length)
                if (crosshairs[num - 1]) {
                    if (!Objects.equals(pond_spaces[num - 1].name, "Water")) {
                        int player_ind = pond_spaces[num - 1].name.charAt(6) - 49;
                        players[player_ind].lives--;
                        pond_spaces[num-1] = null;
                        for (int i = num - 1; i < pond_spaces.length - 1; i++){
                            pond_spaces[i] = pond_spaces[i+1];
                        }
                        boolean check = false;
                        for (int i = 1; i < ducks_deck.deck.length - 1; i++) {
                            if(ducks_deck.deck[i-1] == null && ducks_deck.deck[i] != null) {
                                pond_spaces[pond_spaces.length - 1] = ducks_deck.deck[i];
                                ducks_deck.deck[i] = null;
                                check = true;
                                break;
                            }
                        }
                        if (!check){
                            pond_spaces[pond_spaces.length - 1] = ducks_deck.deck[0];
                            ducks_deck.deck[0] = null;
                        }
                    }
                    crosshairs[num - 1] = false;
                }
                else{
                    System.out.println("You can shoot only at a targeted space.");
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
