import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {
    Table table;

    public TablePanel(Table table) {
        this.table = table;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0, table.tableSizeX, table.tableSizeY);
        int i = 0;
        int x;
        int y;
        for (Card card : table.getCardsOnTable()) {

            x = table.margin + ((i / 3) * table.cardSizeX) + ((i / 3) * table.margin);
            y = table.margin + ((i % 3) * (table.cardSizeY + table.margin)) + ((i % 3) * (table.margin));
            card.setLocationX(x);
            card.setLocationY(y);

            g.setColor(Color.WHITE);
            g.fillRect(x, y, table.cardSizeX, table.cardSizeY);
            if(card.isSelected()) {
                g.setColor(Color.BLACK);
            }
                g.drawRect(x, y, table.cardSizeX, table.cardSizeY);

            switch (card.getValues()[0]) {
                case 0:
                    g.setColor(Color.RED);
                    break;
                case 1:
                    g.setColor(Color.BLUE);
                    break;
                case 2:
                    g.setColor(Color.GREEN);
                    break;
            }
            switch (card.getValues()[1]) {
                case 0:
                    this.drawSquares(x, y, table.cardSizeX, table.cardSizeY, card.getValues()[2], g);
                    break;
                case 1:
                    this.drawCircles(x, y, table.cardSizeX, table.cardSizeY, card.getValues()[2], g);
                    break;
                case 2:
                    this.drawStripes(x, y, table.cardSizeX, table.cardSizeY, card.getValues()[2], g);
                    break;
            }

            i++;
        }


    }

    private void drawSquares(int x, int y, int surfaceX, int surfaceY, int numberOfShapes, Graphics g) {
        int dim = surfaceX / 3;
        int eachShape = surfaceY / (numberOfShapes + 2);
        for (int i = 0; i < numberOfShapes + 1; i++) {
            g.fillRect((x + (surfaceX / 2)) - (dim / 2), y + eachShape * (i + 1) - (dim/2), dim, dim);
        }

    }

    private void drawCircles(int x, int y, int surfaceX, int surfaceY, int numberOfShapes, Graphics g) {
        int dim = (int) (surfaceX / 2.3);
        int eachShape = surfaceY / (numberOfShapes + 2);
        for (int i = 0; i < numberOfShapes + 1; i++) {
            g.fillOval((x + (surfaceX / 2)) - (dim / 2), y + eachShape * (i + 1) - (dim / 2), dim, dim);
        }

    }

    private void drawStripes(int x, int y, int surfaceX, int surfaceY, int numberOfShapes, Graphics g) {
        int dimX = (int) (surfaceX / 1.5);
        int dimY = surfaceX / 6;

        int eachShape = surfaceY / (numberOfShapes + 2);
        for (int i = 0; i < numberOfShapes + 1; i++) {
            g.fillOval((x + (surfaceX / 2)) - (dimX / 2), y + eachShape * (i + 1) - (dimY / 2), dimX, dimY);
        }

    }
}

