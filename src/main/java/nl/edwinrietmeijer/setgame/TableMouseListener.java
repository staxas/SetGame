package nl.edwinrietmeijer.setgame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class TableMouseListener extends MouseAdapter {

    private TablePanel tablePanel;

    private Table table;

    private DeckOfCards deck;

    private CardsComparer cardsComparer = new CardsComparer();

    private final int SELECTED_CARDS_NO = 3;

    private final int MIN_NO_FOR_NEW_COLUMN = 9;

    public TableMouseListener(TablePanel tablePanel, Table table, DeckOfCards deck) {
        this.tablePanel = tablePanel;
        this.table = table;
        this.deck = deck;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        // Restart game button
        if((e.getX() > (table.tableSizeX - (int)(table.margin * 2.3)) && e.getX() < (table.tableSizeX - (int)(table.margin * 2.3) + table.margin)) &&
        (e.getY() > table.tableSizeY - (int)(table.margin * 2.3) && e.getY() < table.tableSizeY - (int)(table.margin * 2.3) + table.margin)) {
            deck.makeDeck();
            table.initTable();
            tablePanel.repaint();
        }

        // Next row of cards button
        if((e.getX() > table.margin && e.getX() < (table.margin * 2)) &&
        (e.getY() > table.tableSizeY - (int)(table.margin * 2.3) && e.getY() < table.tableSizeY - (int)(table.margin * 2.3) + table.margin)) {
                for(int i=0; i< 3; i++) {
                    if (!deck.isEmpty() && table.cardsOnTable.size() < 18) {
                        table.addCard(deck.getCard());
                    }
                }
                tablePanel.repaint();
        }

        // Select a card
        for(Card card : table.getCardsOnTable()) {
            if((e.getX() > card.getLocationX() && e.getX() < card.getLocationX() + table.cardSizeX ) &&
            (e.getY() > card.getLocationY() && e.getY() < card.getLocationY() + table.cardSizeY )) {
                table.cardsOnTable.get(table.getCardIndex(card)).toggleSelected();
                tablePanel.repaint();
            }
        }

        if(table.countSelectedCards() == SELECTED_CARDS_NO) {
            List<Card> selectedCards = new ArrayList<>();
            for(Card card : table.getCardsOnTable()) {
                if(card.isSelected()) {
                    selectedCards.add(card);
                }
            }

            if (cardsComparer.isSet(selectedCards)) {
                boolean enoughSpaceOnTable=false;
                
                if(table.cardsOnTable.size() <= MIN_NO_FOR_NEW_COLUMN + SELECTED_CARDS_NO){
                    enoughSpaceOnTable=true;
                }

                for (Card card : selectedCards) {
                    int indexToAddTo = table.removeCard(card);
                    if (!deck.isEmpty() && enoughSpaceOnTable) {
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
