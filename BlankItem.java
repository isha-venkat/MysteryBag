public class BlankItem extends BagItemSuperclass
{
	int numDraws =0;
	int currBustValue = 0;
	
	//We are defining class BlankItem()
	public BlankItem() {
	}
	
	public int ItemDrawn() {
		System.out.println("Phew! You drew a blank token! Nothing happens...");
		return currBustValue;
	}

}