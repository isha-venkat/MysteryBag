import java.util.Random;
import java.util.Scanner;
public class CoinItem extends BagItemSuperclass
{
	Scanner input = new Scanner(System.in);
	Random rand = new Random();
	int coinSide = rand.nextInt(2);
	int currBustvalue;
	
	//We are defining class BlankItem()
	public CoinItem() {
		
	}
	
	public int ItemDrawn() {
		System.out.println("Oh no! You drew a coin and need to flip it. Call...");
		System.out.println("[H]eads");
		System.out.println("[T]ails");
		String choice = input.next();
		if (coinSide == 1 && choice.equalsIgnoreCase("H")) {
			System.out.println("Phew! You guessed right! Nothing happens...");		
		}
		else if (coinSide == 0 && choice.equalsIgnoreCase("T")) {
			System.out.println("Phew! You guessed right! Nothing happens...");
		}
		else {
			currBustvalue=+2;
			System.out.println("Oh no, you guessed wrong. Your bust total is increased by " + currBustvalue + "...");
		}
		return currBustvalue;	
	}
}
