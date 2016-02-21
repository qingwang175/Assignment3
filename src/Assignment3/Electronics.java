package Assignment3;

public class Electronics extends Item 
{
	String state;
	
	
	// Variables, constructors etc. here.
	public Electronics(String name, float price, int quantity, int weight, String premium, String state) {
		this.name = name;
		this.price = price;
		if(premium == "NF") {
			this.premium = "NF";
		} else {
			this.premium = "N";
		}
		this.weight= weight;
		this.quantity = quantity;
		this.state = state;
	}
	
	//Implement calculate price/print methods as necessary
	public float calculatePrice () 
	{
		//regular sales tax, standard shipping
		float finalprice = 0;
		
		if(premium == "F") {
			finalprice += 12*weight*quantity;
		} else if (premium == "NF"){
			finalprice += 10*weight*quantity;
		} 
		
		if(state == "TX" || state == "NM" || state == "VA" || state == "AZ" || state == "AK") {
			finalprice += price;
		} else {
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
