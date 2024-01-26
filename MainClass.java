import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainClass
{
	private static ArrayList<BagItemSuperclass> items = new ArrayList<BagItemSuperclass>();
	
	public static void main(String[] args)
	{
		//STEP 0:
		//Creating variables
		int numDraws = 1;
		int currBustValue = 0;
		int bustAmount = 6;
		int maxRounds =0;
		Scanner input =new Scanner(System.in);
		System.out.println("Welcome to the Mystery Bag Game! Your aim is to draw all the items in the bag without going bust!");
		System.out.println("[E]asy");
		System.out.println("[M]edium");
		System.out.println("[D]ifficult");	
		System.out.println("Please choose the difficulty: ");
		String choice = input.next();
		
		//STEP 1:
		//Filling the bag with specified amount of elements
		//EASY
		if (choice.equalsIgnoreCase("E")) {
			System.out.println("Easy! Adding five items...");
			System.out.println("Done!");
			
			GenerateNewBagItem();
			maxRounds = 5;
		}
		//MEDIUM
		else if (choice.equalsIgnoreCase("M")){
			System.out.println("Medium! Adding seven items...");
			System.out.println("Done!");
			
			GenerateNewBagItem(0.7,0.3);
			maxRounds = 7;
		}
		//DIFFICULT
		else if (choice.equalsIgnoreCase("D")) {
			System.out.println("Difficult! Adding nine items...");
			System.out.println("Done!");
			
			GenerateNewBagItem(0.4,0.2,0.4);
			maxRounds = 9;
		}
		else {
			System.out.println("Invalid option!");
		}
		
		//STEP 2:
		//Creating loop for the items to be drawn according to the difficulty 
		while(currBustValue < bustAmount && !items.isEmpty()){
			System.out.println("Time to draw! You are on draw " + numDraws + " of " + maxRounds);
			System.out.println("Your current bust value is " + currBustValue + " of 6");
			System.out.println("Type anything to draw...");
			String choice1 = input.next();
			BagItemSuperclass itemDrawn = items.remove(0);
			currBustValue += itemDrawn.ItemDrawn();
			numDraws+=1;
		}
		
		//STEP 3:
		//Printing the total bust value and Message for the user once they have finished with their game.
		System.out.println("Your total bust value is " + currBustValue);
		if (currBustValue<6) {
			System.out.println("Game Over! You drew all the items! Well done!");
		}
		else {
			System.out.println("Game Over! You went bust on draw " + (numDraws-1) + " of " +  maxRounds);
		}
	}
	// These are 3 GenerateNewBagItem() for the different difficulties. We pass different chance value to them.
	//EASY
	public static BagItemSuperclass GenerateNewBagItem()
	{
		for(int i=0;i<5;i++) {
			items.add(new BlankItem());
		}
		return null;
	}
	
	//MEDIUM
	public static BagItemSuperclass GenerateNewBagItem(double blankItem,double diceChance)
	{
		for(int i=0;i<7;i++) {
			double val = Math.random(); 
			if (val <=0.3) {
				items.add(new DiceItem());
			}
			else {
				items.add(new BlankItem());				
			}
		}
		return null;
	}
	
	//DIFFICULT
	public static BagItemSuperclass GenerateNewBagItem(double blankItem,double diceChance, double coinChance)
	{
		for(int i=0;i<9;i++) {
			double val = Math.random(); 
			if (val <=0.2) {
				items.add(new DiceItem());
			}
			else if (val <=0.6) {
				items.add(new CoinItem());
			}
			else {
				items.add(new BlankItem());				
			}
		}
		return null;
	}
}
