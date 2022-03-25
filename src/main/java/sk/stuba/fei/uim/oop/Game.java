package sk.stuba.fei.uim.oop;

import java.util.Scanner;

public class Game {
    final int POND_SIZE = 5;

    int players_count;
    DeckOfActionCards action_cards_deck;
    DeckOfDucks ducks_deck;

    Player[] players;
    Card[] pond_spaces = new Card[POND_SIZE];
    boolean[] crosshairs = new boolean[POND_SIZE];

    public Game(){
        System.out.println("Input number of players:");
        try {
            Scanner in = new Scanner(System.in);
            players_count = in.nextInt();
            if (players_count <= 6 && players_count > 1){
                start();
            }
            else System.out.println("wrong players count");
        }
        catch (java.util.InputMismatchException e){
            System.out.println("!!! invalid input !!!");
            return;
        }
    }

    void start(){
        create_players();
        action_cards_deck = new DeckOfActionCards();
        ducks_deck = new DeckOfDucks(players_count);
        hand_out_cards();
        hand_out_ducks();
        printPond();

        int player_ind = 0;
        while (!onePlayerLeft()) {
            players[player_ind].playCard(pond_spaces, crosshairs, players, action_cards_deck, ducks_deck);
            printPond();
            if (player_ind == players_count-1)
                player_ind = 0;
            else
                player_ind++;
        }
    }

    boolean onePlayerLeft(){
        int alives_count = 0, id = -1;
        for (int i = 0; i < players_count; i++){
            if (players[i].lives > 0) {
                alives_count++;
                id = i;
            }
        }
        if (alives_count == 1) {
            System.out.println("\n\n" + id + " player win!");
            return true;
        }
        else return false;
    }

    void create_players() {
        players = new Player[players_count];
        for (int i = 0; i < players_count; i++)
            players[i] = new Player("player" + (i + 1));
    }

    void hand_out_cards(){
        for (int i = 0, card = 0; i < players_count; i++){
            for (int j = 0; j < players[0].COUNT_OF_CARDS; j++, card++){
                players[i].players_cards[j] = action_cards_deck.deck[card];
                action_cards_deck.deck[card] = null;
            }
        }
    }

    void hand_out_ducks(){
        for (int i = 0; i < POND_SIZE; i++){
            pond_spaces[i] = ducks_deck.deck[i];
            ducks_deck.deck[i] = null;
        }
    }

    void printPond(){
        System.out.println("---------------------------------");
        for (int i = 0; i < POND_SIZE; i++){
            System.out.println((i + 1) + ". " + pond_spaces[i].name + " " + crosshairs[i]);
        }
    }
}
