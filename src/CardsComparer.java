import java.util.Arrays;
import java.util.List;

public class CardsComparer {
    public boolean isSet(List<Card> cardList) {

        Integer[][] cards = new Integer[3][3];
        cards[0] = cardList.get(0).getValues();
        cards[1] = cardList.get(1).getValues();
        cards[2] = cardList.get(2).getValues();


        Integer[][] valueCounts = new Integer[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(valueCounts[i], 0);
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    valueCounts[i][j] += (cards[k][i] == j ? 1 : 0);
                }
            }
        }
        boolean isSet = true;
        for (Integer[] valueCount : valueCounts) {
            List<Integer> valueCountList = Arrays.asList(valueCount);
            if ((valueCountList.contains(1) && valueCountList.contains(2)) && !valueCountList.contains(3)) {
                isSet = false;
            }
        }
        return isSet;
    }
}
