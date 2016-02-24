package Assignment3;

public class Grocery extends Item {
	//variables, constructor here
	
	public Grocery(String name, float price, int weight, int quantity, String premium){  
		//for premium, user will input "P" or "NP" for PERISHABLE or NON-PERISHABLE
		super(name,price,weight,quantity,premium);
	}
	//override calculatePrice() if necessary; Implement print methods as necessary	
	// Only re-implement stuff you cannot get from the superclass (Item)
	float calculatePrice(){
		float final_price = 0;
		if(premium.equals("P")) {    //premium shipping is 20% more
			final_price = final_price + 24*weight*quantity;
		} else if (premium.equals("NP")){   //standard shipping
			final_price = final_price + 20*weight*quantity;
		} 
		final_price = final_price + price*quantity;
		return final_price;
	}
	
	void printItemAttributes(){
		System.out.println("Item type: Grocery");
		super.printItemAttributes();
		System.out.println("Perishable (P or NP): " + premium);	
	}
}
