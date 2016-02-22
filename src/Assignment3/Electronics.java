package Assignment3;

public class Electronics extends Item 
{
	protected String state;
	
	// Variables, constructors etc. here.
	public Electronics(String name, float price, int quantity, int weight, String premium, String state) {
		super(name,price,quantity,weight,premium);
		this.state = state;
	}
	
	//Implement calculate price/print methods as necessary
	public float calculatePrice () 
	{
		float finalprice = 0;
		
		if(premium == "F") {    //premium shipping is 20% more
			finalprice += 24*weight*quantity;
		} else if (premium == "NF"){   //standard shipping
			finalprice += 20*weight*quantity;
		} 
		
		if(state == "TX" || state == "NM" || state == "VA" || state == "AZ" || state == "AK") {
			finalprice += price;
		} else {  //all other states have sales tax (but not on shipping)
			finalprice += 1.1*price;
		}
		
		return finalprice;
	}
	
	void printItemAttributes () 
	{	
		String notWord = "";    //simple word to put in the item attribute string
		if(premium == "N") {
			notWord = "not ";
		}
		//Print all applicable attributes of this sub-class
		System.out.println(name + ": $" + price + ", for " + quantity + ", " + 
				weight + " lbs, and is from " + state + 
				" and is " + notWord + "fragile.");
		
	}
	
}
