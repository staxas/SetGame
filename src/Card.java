import java.util.Arrays;

public class Card {
    private Integer[] cardVals;

    private int locationX=0;
    private int locationY=0;

    private boolean isSelected=false;

    public Card(Integer[] cardArr) {
        this.cardVals = Arrays.copyOf(cardArr, cardArr.length);
    }

    public Integer[] getValues() {
        return cardVals;
    }

    public Integer[] clone() {
        return Arrays.copyOf(cardVals, cardVals.length);
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void toggleSelected() {
        isSelected = !isSelected;
    }
}
