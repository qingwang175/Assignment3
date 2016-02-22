package Assignment3;

import java.util.*;

public class Functions {

	public void printAll(ArrayList<Item> shoppingCart) {
		if(shoppingCart.size() == 0) {
			errorMessage("Empty cart");
			return;
		}
		float sum = 0;
		for(int i = 0; i < shoppingCart.size(); i++) {
			shoppingCart.get(i).printItemAttributes();
			float eachprice = shoppingCart.get(i).calculatePrice();
			sum += (float) (eachprice - eachprice%100);
			System.out.println();
		}
		System.out.println("Total price: $" + sum + ".");
		
	}
	
	public ArrayList<Item> insertItem(ArrayList<Item> shoppingCart, String[] inputString) {
		/* if(shoppingCart.size() == 0) {
			shoppingCart.add()
		}
		int offset = 0;
		
		*/
		return shoppingCart;
	}
	
	public ArrayList<Item> deleteItem(ArrayList<Item> shoppingCart, String name) {
		int deletes = 0;  //number of deleted items
		if(shoppingCart.size() == 0) {
			errorMessage("Empty cart");
		} else {
			for(int i = 0; i < shoppingCart.size(); i++) {
				if(name == shoppingCart.get(i).name) {
					shoppingCart.remove(i);
					i--;
					deletes++;
				}
			}
		}
		System.out.println("Total " + name + "'s deleted: " + deletes);
		return shoppingCart;
	}
	
	public void searchItem(ArrayList<Item> shoppingCart, String name) {
		int matches = 0;  //number of that item
		if(shoppingCart.size() == 0) {
			errorMessage("Empty cart");
		} else {
			for(int i = 0; i < shoppingCart.size(); i++) {
				if(name == shoppingCart.get(i).name) {
					matches++;
				}
			}
		}
		System.out.println("Total " + name + "'s found: " + matches);
		return;
	}
	
	private void errorMessage(String error) {
		return;
	}
}
