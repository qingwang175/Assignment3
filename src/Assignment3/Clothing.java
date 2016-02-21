package Assignment3;

public class Clothing extends Item 
{

	// variables, constructors as necessary
	public Clothing(String name, float price, int quantity, int weight, String premium) {
		this.name = name;
		this.price = price;
		this.premium = "N";
		this.weight= weight;
		this.quantity = quantity;
	}
	
	public float calculatePrice () 
	{
		//regular sales tax, standard shipping
		return (float) (1.1*price + 20*weight*quantity);   
	}
	
	void printItemAttributes () 
	{
		//Print all applicable attributes of this sub-class
		System.out.println(name + ": $" + price + ", for " + quantity + ", " + 
				weight + " lbs.");
		
	}
	

}
