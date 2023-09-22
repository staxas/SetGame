package nl.edwinrietmeijer.setgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
    private List<Card> deck = new ArrayList<>();
    Random rand = new Random();

    public DeckOfCards() {
        this.makeDeck();
    }

    public Card getCard() {
        if (!deck.isEmpty()) {
            return deck.remove(rand.nextInt((deck.size())));
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }

    public int size() {
        return deck.size();
    }

    public void makeDeck() {
        deck.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        deck.add(new Card(new Integer[]{i, j, k,l}));
                    }
                }
            }
        }
    }

}
