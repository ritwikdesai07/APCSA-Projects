import java.util.ArrayList;

public class Dealer {
    private ArrayList<Card> hand;
    private int value;

    public Dealer() {
        hand = new ArrayList<Card>();
        value = 0;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getValue() {
        // Work on this
        // Only show one card but system should see both
        return value;
    }

    public void hit(Deck d) {
        Card newCard = d.deal();
        hand.add(newCard);
        value += newCard.getValue();
    }

    public String toString() {
        return "Dealer's shows: " +  hand.get(0) ;
    }
}
