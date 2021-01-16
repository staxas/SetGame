import java.util.ArrayList;
import java.util.List;

public class Table {
    List<Card> cardsOnTable = new ArrayList<>();

    int tableSizeX;
    int tableSizeY;
    int cardSizeX;
    int cardSizeY;
    int margin;

    public Table(int cardSizeX, int cardSizeY, int margin) {
        this.cardSizeX = cardSizeX;
        this.cardSizeY = cardSizeY;
        this.margin = margin;
        tableSizeX=(cardSizeX * 4 ) + (margin * 5);
        tableSizeY=(cardSizeY * 3 ) + (margin * 4);
    }

    public List<Card> getCardsOnTable() {
        return cardsOnTable;
    }

    public void addCard(Card card) {
        cardsOnTable.add(card);
    }

    public void removeCard(Card card) {
        cardsOnTable.remove(card);
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
