package Assignment3;

import java.util.*;

import javax.swing.JOptionPane;

public class Functions {

	public void printAll(ArrayList<Item> shoppingCart) {
		if(shoppingCart.size() == 0) {
			errorMessage("Empty cart");
			return;
		}
		float sum = 0;
		Iterator<Item> i = shoppingCart.iterator();
		while (i.hasNext()) {
			Item temp = i.next();
			temp.printItemAttributes();
			float eachprice = temp.calculatePrice();
			sum += (float) (eachprice - eachprice%100);
			System.out.println();
		}
		System.out.println("Total price: $" + sum + ".");
		
	}
	
	public ArrayList<Item> insertItem(ArrayList<Item> shoppingCart, String[] inputString) {
		/*
		 * if(shoppingCart.size() == 0) {
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
			Iterator<Item> i = shoppingCart.iterator();
			while (i.hasNext()) {
				Item temp = i.next();
				if(name == temp.name) {
					matches++;
				}
			}
		}
		System.out.println("Total " + name + "'s found: " + matches);
		return;
	}
	
	public ArrayList<Item> updateItem(ArrayList<Item> shoppingCart, String name, int quantity) {
		if(shoppingCart.size() == 0) {
			errorMessage("Empty cart");
		} else {
			for(int i = 0; i < shoppingCart.size(); i++) {
				if(name == shoppingCart.get(i).name) {
					shoppingCart.get(i).quantity = quantity;
					System.out.println(name + " quantity updated to " + quantity + ".");
					return shoppingCart;
				}
			}
		}
		System.out.println(name + " not found.");
		return shoppingCart;
	}
	
	private void errorMessage(String error) {
		if(error == "Empty cart") {
			JOptionPane.showMessageDialog(null,
					"Empty Cart.",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
}
