import java.util.ArrayList;
import java.util.List;

public class Table {
    List<Card> cardsOnTable = new ArrayList<>();

    int tableSizeX=100;
    int tableSizeY=800;
    int cardSizeX=50;
    int cardSizeY=100;
    int margin = 20;

    public List<Card> getCardsOnTable() {
        return cardsOnTable;
    }

    public void addCard(Card card) {
        cardsOnTable.add(card);
    }

    public int getCardIndex(Card card) {
        return cardsOnTable.indexOf(card);
    }

    public int countSelectedCards() {
        int i=0;
        for(Card card : cardsOnTable) {
            if(card.isSelected()) {
                i++;
            }
        }
        return i;
    }

    public void unselectAllCards() {
        for(Card card : cardsOnTable) {
            card.setSelected(false);
        }
    }
}
