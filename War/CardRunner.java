import java.util.ArrayList;
import java.util.Scanner;
public class CardRunner {
    public static void main(String[] args) {
        Player p1 = new Player();
        Player p2 = new Player();
        Deck deck = new Deck();
        Scanner s = new Scanner(System.in);

        deck.shuffle();

        
        for (int i = 0; i < 26; i++) {
            p1.addCard(deck.deal());
            p2.addCard(deck.deal());
        }

      
        while (p1.getHandSize() > 0 && p2.getHandSize() > 0) {
            Card card1 = p1.drawCard();
            Card card2 = p2.drawCard();
            System.out.println("Player 1 plays: " + card1);
            System.out.println("Player 2 plays: " + card2);

            ArrayList<Card> pot = new ArrayList<>();
            pot.add(card1);
            pot.add(card2);

            if (card1.getValue() > card2.getValue()) {
                System.out.println("Player 1 wins this round!");
                p1.addCards(pot);
            } else if (card2.getValue() > card1.getValue()) {
                System.out.println("Player 2 wins this round!");
                p2.addCards(pot);
            } else {
                System.out.println("War!");

                ArrayList<Card> p1WarCards = p1.war();
                ArrayList<Card> p2WarCards = p2.war();

                pot.addAll(p1WarCards);
                pot.addAll(p2WarCards);

                boolean warResolved = false;
                while (!warResolved && !p1WarCards.isEmpty() && !p2WarCards.isEmpty()) {
                    Card p1WarCard = p1WarCards.get(p1WarCards.size() - 1);
                    Card p2WarCard = p2WarCards.get(p2WarCards.size() - 1);

                    System.out.println("Player 1 war card: " + p1WarCard);
                    System.out.println("Player 2 war card: " + p2WarCard);

                    if (p1WarCard.getValue() > p2WarCard.getValue()) {
                        System.out.println("Player 1 wins the war!");
                        p1.addCards(pot);
                        warResolved = true;
                    } else if (p2WarCard.getValue() > p1WarCard.getValue()) {
                        System.out.println("Player 2 wins the war!");
                        p2.addCards(pot);
                        warResolved = true;
                    } else {
                        System.out.println("War continues! Drawing additional cards for the war.");
                        p1WarCards = p1.war();
                        p2WarCards = p2.war();
                        pot.addAll(p1WarCards);
                        pot.addAll(p2WarCards);
                    }
                }

                
            }

            System.out.println("Player 1 hand size: " + p1.getHandSize());
            System.out.println("Player 2 hand size: " + p2.getHandSize());

            if (p1.getHandSize() == 0 || p2.getHandSize() == 0) {
                break;
            }

            //System.out.println("Press Enter to continue...");
            //s.nextLine();
        }


        if (p1.getHandSize() > 0) {
            System.out.println("Player 1 wins the game!");
        } else {
            System.out.println("Player 2 wins the game!");
        }

    }
}
