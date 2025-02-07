import java.util.Scanner;
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
		do{
			runner(d);
			}
		while ((player.getValue() < 21) && (runner() != 2 ));
	}

	public static int runner(Deck d){
		Scanner s = new Scanner(System.in);
		System.out.print("Tap(1) or Pass(2)");
		int pInput = s.nextInt();
		if(pInput == 1){
			System.out.println("You drew a "+ player.hit(d));
			System.out.println(player);
			return 1;
			}
		else{
			return 2;
		}
		return null;

	}
}
