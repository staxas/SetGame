package nl.edwinrietmeijer.setgame;

import java.util.Arrays;
import java.util.List;

public class CardsComparer {
    // Number of card patterns
    private final int PATTS_NO = 4;
    // Number of dimensions per card pattern
    private final int DIMS_NO = 3;
    // Number of cards to compare
    private final int CARDS_NO = 3;
    
    public boolean isSet(List<Card> cardList) {

        Integer[][] cards = new Integer[CARDS_NO][PATTS_NO];

        for (int cardIndex = 0; cardIndex < CARDS_NO; cardIndex++) { 
            cards[cardIndex] = cardList.get(cardIndex).getValues();
        }


        Integer[][] valueCounts = new Integer[PATTS_NO][DIMS_NO];

        for (int patternIndex = 0; patternIndex < PATTS_NO; patternIndex++) {
            Arrays.fill(valueCounts[patternIndex], 0);

            for (int dimensionIndex = 0; dimensionIndex < DIMS_NO; dimensionIndex++) {
                for (int cardIndex = 0; cardIndex < CARDS_NO; cardIndex++) {
                    if (cards[cardIndex][patternIndex] == dimensionIndex) {
                        valueCounts[patternIndex][dimensionIndex] ++;
                    }
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
