import java.util.ArrayList;
public class Deck{
	private ArrayList<Card> cards;

	public Deck()//every deck is the same so no param is needed. Only use param when it changes.
	{
		cards = new ArrayList<Card>();
		for (int s=1; s<=4; s++){
			for(int v=1 ; v<=13; v++){
				if(s==1)
					cards.add(new Card(v, "Clubs"));
				else if (s==2)
					cards.add(new Card(v, "Diamonds"));
				else if (s==3)
					cards.add(new Card(v, "Hearts"));
				else
					cards.add(new Card(v, "Spades"));
					}
				}
	}
	public String toString(){
		return cards.toString();
		}
	public void shuffle()
	{
		for(int i = 0; i<1000; i++){
			int r = (int)(Math.random()*cards.size());
			cards.add(cards.remove(r));
			}
		}
	public Card deal(){
		return cards.remove(0);
	}
}