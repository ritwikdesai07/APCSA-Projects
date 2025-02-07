public class CardRunner{
	public static void main(String[]args){
		Deck d = new Deck();
		Player player = new Player();
		Dealer dealer = new Dealer();
		d.shuffle();

		for (int i = 0; i < 2; i++) {
   			player.hit(d);
    		dealer.hit(d);
		}
		System.out.println(player);
		System.out.println(dealer);
	}
}