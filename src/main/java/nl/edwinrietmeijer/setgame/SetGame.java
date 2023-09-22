package nl.edwinrietmeijer.setgame;

import javax.swing.*;

public class SetGame extends JPanel{

    public static void main(String args[]) {
        DeckOfCards deckOfCards = new DeckOfCards();
        Table table = new Table(80, 150, 50, deckOfCards);
 

        JFrame frame = new JFrame("SetTable");
        TablePanel panel = new TablePanel(table);
        frame.setContentPane(panel);
        panel.addMouseListener(new CardMouseListener(panel, table, deckOfCards));

        frame.add(new TablePanel(table));
        frame.setSize(table.tableSizeX, table.tableSizeY);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
