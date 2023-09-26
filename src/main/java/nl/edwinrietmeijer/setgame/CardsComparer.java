package nl.edwinrietmeijer.setgame;

import java.util.Arrays;
import java.util.List;

public class CardsComparer {
    // Number of card patterns
    private final int PATTERNS_NO = 4;
    // Number of states per card pattern
    private final int STATES_NO = 3;
    // Number of cards to compare
    private final int CARDS_NO = 3;
    
    public boolean isSet(List<Card> cardList) {

        Integer[][] cards = new Integer[CARDS_NO][PATTERNS_NO];

        for (int cardIndex = 0; cardIndex < CARDS_NO; cardIndex++) { 
            cards[cardIndex] = cardList.get(cardIndex).getValues();
        }


        Integer[][] valueCounts = new Integer[PATTERNS_NO][STATES_NO];

        for (int patternIndex = 0; patternIndex < PATTERNS_NO; patternIndex++) {
            Arrays.fill(valueCounts[patternIndex], 0);

            for (int stateIndex = 0; stateIndex < STATES_NO; stateIndex++) {
                for (int cardIndex = 0; cardIndex < CARDS_NO; cardIndex++) {
                    if (cards[cardIndex][patternIndex] == stateIndex) {
                        valueCounts[patternIndex][stateIndex] ++;
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
