public class Card{
    private int value;
    private String suit;
    private String color;

    public Card(int v, String s){
        value=v;
        suit =s;
        if (suit.equals("Diamonds")||suit.equals("Hearts")){
            color="Red";
        }
        else{
            color="Black";
        }
        if (value==1) value = 14;
    }
    public int getValue(){
        return value;
    }
    public String getSuit(){
        return suit;
    }
    public String getColor(){
        return color;
    }

    public String toString(){
        if (value==14)return "Ace of "+suit;
        else if(value ==11)return "Jack of "+suit;
        else if(value ==12)return "Queen of "+suit;
        else if(value ==13)return "King of "+suit;
        else return value+" of "+suit;
    }
}