public class Card {
    private int value;  
    private int rank;    
    private String suit; 
    private String color; 


    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;


        if (suit.equals("Diamonds") || suit.equals("Hearts")) {
            color = "Red";
        } else {
            color = "Black";
        }

        if (rank == 1) { 
            value = 11;
        } else if (rank >= 11) { 
            value = 10;
        } else { 
            value = rank;
        }
    }


    public int getValue() {
        return value;
    }


	public int changePlayerAceValue(int handValue) {
		if (value == 11 && handValue > 10) { 
			return 1; 
		}
		return value; 
	}
	
	public int changeDealerAceValue(int handValue) {
		if (value == 11 && handValue > 10) { 
			return 1; 
		}
		return value; 
	}

    public String getSuit() {
        return suit;
    }

    public String getColor() {
        return color;
    }


    public String toString() {
        if (rank == 1) {
            return "Ace of " + suit;
        } else if (rank == 11) {
            return "Jack of " + suit;
        } else if (rank == 12) {
            return "Queen of " + suit;
        } else if (rank == 13) {
            return "King of " + suit;
        } else {
            return rank + " of " + suit;
        }
    }
}
