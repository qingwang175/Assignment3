package Assignment3;

public class Electronics extends Item 
{
	protected String fragile;
	protected String state;
	// Variables, constructors etc. here.
	
	public Electronics(String name, float price, int quantity, int weight, String premium, String state) {
		super(name, price, quantity, weight, premium);
		this.name = name;
		this.price = price;
		if(premium == "NF") {
			this.premium = "NF";
		} else {
			this.premium = "F";
		}
		this.weight= weight;
		this.quantity = quantity;
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
			finalprice += price*quantity;
		} else {  //all other states have sales tax (but not on shipping)
			finalprice += 1.1*price*quantity;
		}
		
		return finalprice;
	}
	
	void printItemAttributes(){
		System.out.println("Item type: Electronics");
		System.out.println("Item name: " + name);
		System.out.printf("Item price: $%.2f%n",price);
		System.out.println("Item quantity: " + quantity);
		System.out.println("Item weight: " +  weight + " lbs");
		System.out.println("Premium (P or NP): " + premium);
		System.out.println("Fragile (F or NF): " + fragile);
		System.out.println("Shipping to: " + state);
	}

	
}
