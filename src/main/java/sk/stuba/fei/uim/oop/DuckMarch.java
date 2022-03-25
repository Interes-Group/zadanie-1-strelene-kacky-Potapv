package sk.stuba.fei.uim.oop;

public class DuckMarch extends Card {
    public DuckMarch(){
        name = "Duck March";
    }

    @Override
    public void play(Card[] pond_spaces, boolean[] crosshairs, Player[] players, Deck action_cards_deck, Deck ducks_deck) {
        super.play(pond_spaces, crosshairs, players, action_cards_deck, ducks_deck);

        boolean check = false;
        for (int i = 1; i < action_cards_deck.deck.length - 1; i++) {
            if(action_cards_deck.deck[i-1] != null && action_cards_deck.deck[i] == null) {
                action_cards_deck.deck[i] = ducks_deck.deck[0];
                check = true;
                break;
            }
        }
        if (!check){
            action_cards_deck.deck[0] = ducks_deck.deck[0];
        }
        for (int i = 0; i < pond_spaces.length - 1; i++){
            pond_spaces[i] = pond_spaces[i+1];
        }
        check = false;
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
}
