import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetGame {
    public static void main(String args[]) {
        DeckOfCards deckOfCards = new DeckOfCards();
        boolean foundSet=false;
        while(!foundSet) {
            if(deckOfCards.isEmpty()) {
                deckOfCards = new DeckOfCards();
            }
            Integer[][] cards = new Integer[3][3];
            cards[0] = deckOfCards.getCard();
            cards[1] = deckOfCards.getCard();
            cards[2] = deckOfCards.getCard();
            System.out.println("Cards:");
            for (Integer[] card : cards) {
                System.out.print("[ ");
                Arrays.stream(card).forEach(x -> System.out.print(x + " "));
                System.out.print("] ");
            }

            Integer[][] valueCounts = new Integer[3][3];
            Arrays.fill(valueCounts[0], 0);
            Arrays.fill(valueCounts[1], 0);
            Arrays.fill(valueCounts[2], 0);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        valueCounts[i][j] += (cards[k][i] == j ? 1 : 0);
                    }
                }
            }
            System.out.println();
            System.out.println("Values:");
            boolean isSet = true;
            for (Integer[] valueCount : valueCounts) {
                System.out.print("[ ");
                Arrays.stream(valueCount).forEach(x -> System.out.print(x + " "));
                System.out.print("] ");
                List<Integer> valueCountList = Arrays.asList(valueCount);
                if ((valueCountList.contains(1) && valueCountList.contains(2)) && !valueCountList.contains(3)) {
                    isSet = false;
                }
            }
            System.out.println();

            if (isSet) {
                System.out.println("SET!");
                foundSet=true;
            } 
        }
    }
}
