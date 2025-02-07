import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;

    public Player() {
        hand = new ArrayList<Card>();
        
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public Card drawCard() {
        return hand.remove(0); 
    }

    public void addCards(ArrayList<Card> cards) {
        hand.addAll(cards); 
    }

    public int getHandSize() {
        return hand.size();
    }

    public ArrayList<Card> war() {
        ArrayList<Card> warList = new ArrayList<Card>();
        for (int i = 0; i < 2 && !hand.isEmpty(); i++) {
            warList.add(hand.remove(0)); 
        }
        return warList;
    }
}

