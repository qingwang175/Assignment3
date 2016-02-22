package Assignment3;

public class Item {
//Declare variables for this class. Think about its type: public, protected or private?
	protected String name;
	protected float price;
	protected String premium;  
	protected float weight;
	protected int quantity;


// You will need a constructor (Why?). Create it here.
	public Item(String name, float price, int quantity, int weight, String premium){
		this.name = name;
		this.price = price;
		this.premium = premium;
		this.weight = weight;
		this.quantity = quantity;
	}
	
	float calculatePrice () 
	{
		float final_price = 0;
		float ship_price;
		// Insert price calculation here
		float tax_price = (float) (1.10*quantity*price);
		if(premium.equals("NP")) //if not premium shipping
			ship_price =  (float) ((20*weight)*quantity);
		else //if it is premium shipping
			ship_price =  (float) ((20*weight)*quantity*1.20);
		final_price = final_price + tax_price + ship_price; //compute final price with tax and shipping
		return final_price;
	}
	

	void printItemAttributes () 	//Print all applicable attributes of this class
	{
		System.out.println("Item type: Item");
		System.out.println("Item name: " + name);
		System.out.printf("Item price: $%.2f%n",price);
		System.out.println("Item quantity: " + quantity);
		System.out.println("Item weight: " +  weight + " lbs");
		System.out.println("Premium (P or NP): " + premium);
	}

}

