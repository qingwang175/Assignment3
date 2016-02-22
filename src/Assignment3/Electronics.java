package Assignment3;

public class Electronics extends Item 
{
	protected String fragile;
	protected String state;
	// Variables, constructors etc. here.
	public Electronics(String name, float price, String premium, int weight, int quantity, String fragile, String state){
		super(name,price,premium,weight,quantity);
		this.fragile = fragile;
		this.state = state;
		if(fragile.equals("F"))
			this.premium = "P";
	}
	
	//Implement calculate price/print methods as necessary
	float calculatePrice(){
		float final_price;
		if(fragile.equals("F")){//Fragile, Premium Shipping
			if(state.equals("TX") || state.equals("NM") || state.equals("VA") || state.equals("AZ") || state.equals("AK")) //premium shipping, NO sales tax
				final_price = (float) (quantity*price + 20*weight*quantity*1.20); //final price = quantity*price + premium shipping price
			else //Other States (premium shipping, sales tax)
				final_price = (float) (1.10*quantity*price + 20*weight*quantity*1.20); //final price = taxed price + premium shipping price
		}
		else{ //Non-fragile, regular
			//TX, NM, VA, AZ, AK (regular shipping, NO sales tax)
			if(state.equals("TX") || state.equals("NM") || state.equals("VA") || state.equals("AZ") || state.equals("AK")) //regular shipping, NO sales tax
				final_price = (float) (quantity*price + 20*weight*quantity); //final price = quantity*price + regular shipping price
			else //Other States (regular shipping, sales tax)
				final_price = (float) (1.10*quantity*price + 20*weight*quantity); //final price = taxed price + regular shipping price
		}
		return final_price;
		
	
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
