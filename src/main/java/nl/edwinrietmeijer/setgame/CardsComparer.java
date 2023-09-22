package nl.edwinrietmeijer.setgame;

import java.util.Arrays;
import java.util.List;

public class CardsComparer {
    // Number of card pattern dimensions
    private final int DIMS_NO = 4;
    // Number of cards to compare
    private final int CARDS_NO = 3;

    public boolean isSet(List<Card> cardList) {

        Integer[][] cards = new Integer[CARDS_NO][DIMS_NO];

        for (int i = 0; i < CARDS_NO; i++) { 
            cards[i] = cardList.get(i).getValues();
        }


        Integer[][] valueCounts = new Integer[DIMS_NO][CARDS_NO];

        for (int i = 0; i < DIMS_NO; i++) {
            Arrays.fill(valueCounts[i], 0);

            for (int j = 0; j < CARDS_NO; j++) {
                for (int k = 0; k < CARDS_NO; k++) {
                    valueCounts[i][j] += (cards[k][i] == j ? 1 : 0);
                }
            }
        }

        boolean isSet = true;

        for (Integer[] valueCount : valueCounts) {
            List<Integer> valueCountList = Arrays.asList(valueCount);
            if ((valueCountList.contains(1) && valueCountList.contains(2)) && !valueCountList.contains(3)) {
                isSet = false;
                break;
            }
        }
        return isSet;
    }
}
