package Assignment3;

import java.util.*;

import javax.swing.JOptionPane;

public class Functions {
	
	public Functions() { //empty constructor to use in main
	}

	public void printAll(ArrayList<Item> shoppingCart) {
		if(shoppingCart.size() == 0) {        //Don't bother going through an empty cart
			errorMessage("Empty cart");
			return;
		}
		float sum = 0;   //Keep track of the sum while iterating
		for(int i = 0; i < shoppingCart.size(); i++) {  
			Item temp = shoppingCart.get(i);
			temp.printItemAttributes();
			float eachprice = temp.calculatePrice();
			sum += (float) (eachprice);
			System.out.println();
		}
		System.out.println("Total price: $" + sum + ".\n");  //Output total price
		
	}
	
	public ArrayList<Item> insertItem(ArrayList<Item> shoppingCart, String[] command) {
		String temp = command[1].toLowerCase();
		int offset = 0;
		
		if(shoppingCart.size() != 0) {     //If empty shopping cart, offput automatically puts it in slot 0 
			if(shoppingCart.get(shoppingCart.size() - 1).name.compareTo(command[2]) < 0) {           //Check last case first
				offset = shoppingCart.size();
			} else {
				while(shoppingCart.get(offset).name.compareTo(command[2]) < 0 && (offset + 1) < shoppingCart.size()) {    //Check every other case to see where to put item in alphebetically
					offset++;
				}
			}
		}
		System.out.println(temp);
			
		if(temp.equals("groceries")) {     //Make new item and put it in your cart with your command inputs
			Grocery newItem = new Grocery(command[2], Float.parseFloat(command[3]),
					Double.valueOf(command[4]).intValue(), Double.valueOf(command[5]).intValue(), command[6]);
			shoppingCart.add(offset, newItem);
			System.out.println("New " + command[2] + " grocery item in cart costing $" 
					+ command[3] + " with " + command[4] + " items, total weight: "
					+ command[5] + " lbs.");
		} else if(temp.equals("electronics")) {
			Electronics newItem = new Electronics(command[2], Float.parseFloat(command[3]),
				Double.valueOf(command[4]).intValue(), Double.valueOf(command[5]).intValue(), command[6], command[7]);
			shoppingCart.add(offset, newItem);
			System.out.println("New " + command[2] + " electronic item in cart costing $" 
					+ command[3] + " with " + command[4] + " items from " + command[7] + ", total weight: "
					+ command[5] + " lbs, fragility: " + command[6] + ".");
		} else if(temp.equals("clothing")) {
			Clothing newItem = new Clothing(command[2], Float.parseFloat(command[3]),
					Double.valueOf(command[4]).intValue(), Double.valueOf(command[5]).intValue(), "N");
			shoppingCart.add(offset, newItem);
			System.out.println("New " + command[2] + " clothing item in cart costing $" 
					+ command[3] + " with " + command[4] + " items, total weight: "
					+ command[5] + " lbs, fragility: " + command[6] + ".");
		}
		return shoppingCart;
	}
	
	public ArrayList<Item> deleteItem(ArrayList<Item> shoppingCart, String name) {
		int deletes = 0;  //number of deleted items
		if(shoppingCart.size() == 0) {
			errorMessage("Empty cart");
		} else {
			for(int i = 0; i < shoppingCart.size(); i++) {
				if(name.equals(shoppingCart.get(i).name)) {
					shoppingCart.remove(i);     //Remove all versions of this item, remove the ones taken out through the index
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
				Item temp = shoppingCart.get(i);
				if(name.equals(temp.name)) {
					matches++;      //Track all matches and keep track of the number (not just one)
				}
			}
		}
		System.out.println("Total " + name + "s found: " + matches);
		return;
	}
	
	public ArrayList<Item> updateItem(ArrayList<Item> shoppingCart, String name, int quantity) {
		if(shoppingCart.size() == 0) {     //Don't bother checking empty cart
			errorMessage("Empty cart");
		} else {
			for(int i = 0; i < shoppingCart.size(); i++) {    //Check through the arraylist
				Item temp = shoppingCart.get(i);
				if(name.equals(temp.name)) {
					shoppingCart.get(i).quantity = quantity;
					System.out.println(name + " quantity updated to " + quantity + ".");   //Only change the first item of this name and then leave
					return shoppingCart;
				}
			}
		}
		System.out.println(name + " not found.");
		return shoppingCart;
	}
	
	private void errorMessage(String error) {     //One error message for an empty cart
		if(error == "Empty cart") {
			JOptionPane.showMessageDialog(null,
					"Empty Cart.",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
}
