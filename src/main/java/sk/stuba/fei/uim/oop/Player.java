package sk.stuba.fei.uim.oop;
import java.util.Scanner;

public class Player {
    final int COUNT_OF_CARDS = 3;
    String name;
    int lives = 5;
    Card[] players_cards = new Card[COUNT_OF_CARDS];

    public Player(String name){
        this.name = name;
    }

    public void playCard(Card[] pond_spaces, boolean[] crosshairs, Player[] players,
                         Deck action_cards_deck, Deck ducks_deck){
        System.out.println("---------------------------------");
        System.out.println( "Select the card you want to play:");
        for (int i = 0; i < COUNT_OF_CARDS; i++){
            System.out.println((i + 1) + ". " + players_cards[i].name);
        }

        try {
            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
            if (num > 0 && num <= COUNT_OF_CARDS){
                players_cards[num-1].play(pond_spaces, crosshairs, players, action_cards_deck, ducks_deck);
                replaceCard(num-1, action_cards_deck);
            }
            else{
                System.out.println("Please, input correct number");
                playCard(pond_spaces, crosshairs, players, action_cards_deck, ducks_deck);
                return;
            }
        }
        catch (java.util.InputMismatchException e){
            System.out.println("!!! invalid input !!!");
            playCard(pond_spaces, crosshairs, players, action_cards_deck, ducks_deck);
            return;
        }
    }
    void replaceCard(int n, Deck action_cards_deck){
        boolean check = false;
        for (int i = 1; i < action_cards_deck.deck.length - 1; i++) {
            if(action_cards_deck.deck[i-1] != null && action_cards_deck.deck[i] == null) {
                action_cards_deck.deck[i] = players_cards[n];
                check = true;
                break;
            }
        }
        if (!check){
            action_cards_deck.deck[0] = players_cards[n];
        }
        check = false;
        for (int i = 1; i < action_cards_deck.deck.length - 1; i++) {
            if(action_cards_deck.deck[i-1] == null && action_cards_deck.deck[i] != null) {
                players_cards[n] = action_cards_deck.deck[i];
                check = true;
                break;
            }
        }
        if (!check){
            players_cards[n] = action_cards_deck.deck[0];
        }
    }
}
