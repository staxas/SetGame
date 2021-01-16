import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class CardMouseListener extends MouseAdapter {

    private TablePanel tablePanel;

    private Table table;

    private DeckOfCards deck;

    private CardsComparer cardsComparer = new CardsComparer();

    public CardMouseListener(TablePanel tablePanel, Table table, DeckOfCards deck) {
        this.tablePanel = tablePanel;
        this.table = table;
        this.deck = deck;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(Card card : table.getCardsOnTable()) {
            if((e.getX() > card.getLocationX() && e.getX() < card.getLocationX() + table.cardSizeX ) &&
            (e.getY() > card.getLocationY() && e.getY() < card.getLocationY() + table.cardSizeY )) {
                table.cardsOnTable.get(table.getCardIndex(card)).toggleSelected();
                tablePanel.repaint();
            }
        }
        if(table.countSelectedCards() == 3) {
            List<Card> cardsToCheckForSet = new ArrayList<>();
            for(Card card : table.getCardsOnTable()) {
                if(card.isSelected()) {
                    cardsToCheckForSet.add(card);
                }
            }
            if (cardsComparer.isSet(cardsToCheckForSet)) {
                List<Card> cardsToRemove = new ArrayList<>();
                for(Card card : table.getCardsOnTable()) {
                    if(card.isSelected()) {
                        cardsToRemove.add(card);

                    }
                }
                for(Card card : cardsToRemove) {
                    int indexToAddTo = table.removeCard(card);
                    if (!deck.isEmpty()) {
                        table.addCardAt(indexToAddTo, deck.getCard());
                    }
                }
            } else {
                table.unselectAllCards();
            }
            tablePanel.repaint();

        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
