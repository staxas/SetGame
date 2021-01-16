import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
    private List<Integer[]> deck = new ArrayList<>();
    Random rand = new Random();

    public DeckOfCards() {
        this.makeDeck();
    }

    public Integer[] getCard() {
        if(!deck.isEmpty()) {
            return deck.remove(rand.nextInt(deck.size()));
        } else {
            return null;
        }
    }

    public Integer[] getNextCard() {
        if(!deck.isEmpty()) {
            return deck.remove(0);
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }

    public void makeDeck() {
        Card card = new Card();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    card.setValues(i,j,k);
                    deck.add(card.clone());
                }
            }
        }
    }

    public class Card {
        private Integer[] card = new Integer[3];

        public Card() {
            Arrays.fill(card, 0);
        }

        public Integer[] getCard() {
            return card;
        }

        public void setCard(Integer[]card) {
            this.card=card;
        }

        public void setValues(int value1, int value2, int value3) {
            card[0] = value1;
            card[1] = value2;
            card[2] = value3;
        }

        public Integer[] clone() {
            return Arrays.copyOf(card, card.length);
        }
    }

}
