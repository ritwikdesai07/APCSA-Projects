import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private int value;

    public Player() {
        hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getValue() {
        return value;
    }

    public void hit(Deck d) {
        Card newCard = d.deal();
        hand.add(newCard);
        value += newCard.getValue();
    }

    public String toString(){
        return "You have: " + hand + " Value: " + value;
    }
}
