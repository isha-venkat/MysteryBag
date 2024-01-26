import java.util.Random;
public class DiceItem extends BagItemSuperclass
{
	int currBustvalue;
	Random rand = new Random();
	int drawn = rand.nextInt(4);
	
	//We are defining class DiceItem() 
	public DiceItem() {
	}
	@Override
	public int ItemDrawn() {
		System.out.println("Oh no! You drew a four-sided die and need to roll it...");
		System.out.println("You rolled a " + drawn + " so that will be added to your bust total!");
		currBustvalue += drawn;
		return currBustvalue;
	}

}
