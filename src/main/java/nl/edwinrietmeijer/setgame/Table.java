package nl.edwinrietmeijer.setgame;

import java.util.ArrayList;
import java.util.List;

public class Table {
    List<Card> cardsOnTable = new ArrayList<>();

    DeckOfCards deck;

    int tableSizeX;
    int tableSizeY;
    int cardSizeX;
    int cardSizeY;
    int margin;

    public Table(int cardSizeX, int cardSizeY, int margin, DeckOfCards deck) {
        this.deck = deck;
        this.cardSizeX = cardSizeX;
        this.cardSizeY = cardSizeY;
        this.margin = margin;
        tableSizeX=(cardSizeX * 6 ) + (int)(margin * 8);
        tableSizeY=(cardSizeY * 3 ) + (int)(margin * 6);

        this.initTable();
    }

    public void initTable() {
        cardsOnTable.clear();
        for(int i=0; i<12; i++) {
            addCard(deck.getCard());
        }
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
