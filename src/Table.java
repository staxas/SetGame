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
        tableSizeX=(cardSizeX * 4 ) + (int)(margin * 5.2);
        tableSizeY=(cardSizeY * 3 ) + (int)(margin * 4.5);
    }

    public List<Card> getCardsOnTable() {
        return cardsOnTable;
    }

    public void addCard(Card card) {
        cardsOnTable.add(card);
    }
    public void addCardAt(int index, Card card) {
        cardsOnTable.add(index, card);
    }

    public int removeCard(Card card) {
        int index = cardsOnTable.indexOf(card);
        cardsOnTable.remove(card);
        return index;
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
