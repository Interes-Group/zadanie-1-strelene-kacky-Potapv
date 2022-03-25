package sk.stuba.fei.uim.oop;

public class DeckOfActionCards extends Deck {
    final int AIM = 10;
    final int SHOOT = 12;
    final int WILD_BILL = 2;
    final int DUCK_MARCH = 6;
    final int TURBODUCK = 1;
    final int SCATTER = 2;
    final int DUCK_DANCE = 1;

    public DeckOfActionCards(){
        size = AIM + SHOOT + WILD_BILL + DUCK_MARCH + TURBODUCK + SCATTER + DUCK_DANCE;
        generateDeck();
        shuffle();
    }

    void generateDeck(){
        deck = new Card[size];
        for (int i = 0; i < size; i++){
            if (i < AIM)
                deck[i] = new Aim();
            else if (i < SHOOT + AIM)
                deck[i] = new Shoot();
            else if (i < WILD_BILL + SHOOT + AIM)
                deck[i] = new WildBill();
            else if (i < DUCK_MARCH + WILD_BILL + SHOOT + AIM)
                deck[i] = new DuckMarch();
            else if (i < TURBODUCK + DUCK_MARCH + WILD_BILL + SHOOT + AIM)
                deck[i] = new Turboduck();
            else if (i < SCATTER + TURBODUCK + DUCK_MARCH + WILD_BILL + SHOOT + AIM)
                deck[i] = new Scatter();
            else if (i < size)
                deck[i] = new DuckDance();
        }
    }
}
