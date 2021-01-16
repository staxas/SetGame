import javax.swing.*;
import java.awt.*;

public class SetGame extends JPanel{

    public static void main(String args[]) {
        DeckOfCards deckOfCards = new DeckOfCards();
        Table table = new Table();
        CardsComparer compareCards = new CardsComparer();
        for(int i=0; i<12; i++) {
            table.addCard(deckOfCards.getCard());
        }

        JFrame frame = new JFrame("SetTable");
        TablePanel panel = new TablePanel(table);
        frame.setContentPane(panel);
        panel.addMouseListener(new CardMouseListener(panel, table));

        frame.add(new TablePanel(table));
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);



    }
}
