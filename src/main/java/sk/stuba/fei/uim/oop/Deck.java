package sk.stuba.fei.uim.oop;
import java.util.Random;

public class Deck {
    protected int size;
    protected Card[] deck = new Card[size];

    void shuffle (){
        Random rd = new Random();
        for (int i = size - 1; i > 0; i--) {
            int j = rd.nextInt(i + 1);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }
}
