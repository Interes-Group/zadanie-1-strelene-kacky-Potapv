package sk.stuba.fei.uim.oop;

public class DeckOfDucks extends Deck {
    final int WATER = 5;
    final int DUCKS_PER_PLAYER = 5;

    int players_count;


    public DeckOfDucks(int players_count){
        this.players_count = players_count;
        size = WATER + players_count * DUCKS_PER_PLAYER;

        generateDeck();
        shuffle();
    }

    public void generateDeck(){
        deck = new Card[size];
        int card_ind = 0;

        for (int i = 0; i < players_count; i++) {
            String name = "player" + (i + 1);
            for (int j = 0; j < DUCKS_PER_PLAYER; j++, card_ind++)
                deck[card_ind] = new Duck(name);
        }

        for (int i = 0; i < WATER; i++, card_ind++)
            deck[card_ind] = new Water();
    }

}
