package Assignment3;

public class Clothing extends Item 
{

	// variables, constructors as necessary
	public Clothing(String name, float price, int quantity, int weight, String premium) {
		super(name,price,quantity,weight,premium);
	}
	
	public float calculatePrice () 
	{
		//regular sales tax, standard shipping
		return (float) (1.10*price*quantity + 20*weight*quantity);   
	}
	
	void printItemAttributes () 
	{
		//Print all applicable attributes of this sub-class
		System.out.println("Item type: Clothing");
		super.printItemAttributes();
	}
	

}
