package Assignment3;

import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;

public class A3Driver{

	  public static void main(String[] args) {

		ArrayList<Item> shoppingCart = new ArrayList<Item>(); 
		
		if (args.length != 1) {
			System.err.println ("Error: Incorrect number of command line arguments");
			System.exit(-1);
		}
		
		processLines (args[0], shoppingCart);
	  }		
	  
		public static void processLines (String filename, ArrayList<Item> shoppingCart) 
		{ 

			try 
			{
				FileReader freader = new FileReader(filename);
				BufferedReader reader = new BufferedReader(freader);
				Functions function = new Functions();
				for (String s = reader.readLine(); s != null; s = reader.readLine()) 
				{
					String[] command = s.split(" ");
					if(!hasError(command)){ //if there are no errors in command, proceed
						String temp = command[0].toLowerCase();
						if(temp.equals("insert")) {
							shoppingCart = function.insertItem(shoppingCart, command);
						} else if (temp.equals("delete")) {
							shoppingCart = function.deleteItem(shoppingCart, command[1]);
						} else if (temp.equals("search")) {
							function.searchItem(shoppingCart, command[1]);
						} else if (temp.equals("update")) {
							shoppingCart = function.updateItem(shoppingCart, command[1], Double.parseDouble(command[2]));
						} else if (temp.equals("print")) {
							function.printAll(shoppingCart);
						}
					}
					else //if so, go to next line in text file
						continue;
				}
			} 
			catch (FileNotFoundException e) 
			{
				System.err.println ("Error: File not found. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			} catch (IOException e) 
			{
				System.err.println ("Error: IO exception. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			}
		}
		
		//checks length and type of each element in command returns true if there's an error
		public static boolean hasError(String[] command){
			if(command.length < 1){
				JOptionPane.showMessageDialog(null, "No command typed. Moving on.");
			}
			String s = command[0].toLowerCase();
			if (!(s.equals("insert") || s.equals("search") || s.equals("delete") || s.equals("update") || s.equals("print"))){
				JOptionPane.showMessageDialog(null, "Not a proper command. Moving on.");
			}
			else if((s.equals("search") || s.equals("delete")) && command.length != 2){
				JOptionPane.showMessageDialog(null, "Not a proper command. Moving on.");
			}
			else if((s.equals("update"))){
				if(command.length != 3)
					JOptionPane.showMessageDialog(null, "Not a proper command. Moving on.");
				else if (!isInteger(command[2]))
					JOptionPane.showMessageDialog(null, "Not a proper quantity. Moving on.");
				else
					return false;
			} else if(s.equals("print") && command.length != 1){
				JOptionPane.showMessageDialog(null, "Could not print. Only type 'print'. Moving on.");
			} else if(s.equals("insert")){
				if(command.length < 6 || command.length > 8)
					JOptionPane.showMessageDialog(null, "Not a proper command. Moving on.");
				else{
					String item = command[1].toLowerCase();
					if(!(item.equals("electronics") || item.equals("groceries") || item.equals("clothing")))
						JOptionPane.showMessageDialog(null, "Not a proper item type. Moving on.");
					else if(!isDouble(command[3])) //check price
						JOptionPane.showMessageDialog(null, "Not a proper price. Moving on.");
					else if(!isInteger(command[4])) //check quantity
						JOptionPane.showMessageDialog(null, "Not a proper quantity. Moving on.");
					else if(!isInteger(command[5])) //check weight
						JOptionPane.showMessageDialog(null, "Not a proper weight. Moving on.");
					else if(item.equals("groceries")){
						if(command.length != 7)
							JOptionPane.showMessageDialog(null, "Need to indicate perishability. Moving on.");
						else{
							String upper = command[6].toUpperCase();
							if(!(upper.equals("P") || upper.equals("NP")))
								JOptionPane.showMessageDialog(null, "Must input 'P' or 'NP' for 5th field. Moving on");
							else
								return false;
						}
					}
					else if(item.equals("electronics")){
						if(command.length != 8)
							JOptionPane.showMessageDialog(null, "Need to indicate fragility and shipping state. Moving on.");
						else{
							String upper = command[6].toUpperCase();
							String state = command[7].toUpperCase();
							if(!(upper.equals("F") || upper.equals("NF")))
								JOptionPane.showMessageDialog(null, "Must input 'F' or 'NF' for 5th field. Moving on");
							else if(!checkState(state))
								JOptionPane.showMessageDialog(null, "Must input valid US State. Moving on");
							else
								return false;
						}
					} else if(item.equals("clothing")){
						if(command.length != 6) 
							JOptionPane.showMessageDialog(null, "Not a proper command. Moving on.");
						else
							return false;
					}
					
				}
			} 
			else 
				return false;
			return true;
		}
		

		//checks if String is an integer
		public static boolean isInteger(String str){
			try{
				double number = Double.parseDouble(str);
				return (number % 1 == 0 && number > 0);
			} catch(NumberFormatException nfe) {
		        return false;
		    }
		}
		
		//checks if String is a double
		public static boolean isDouble(String str) {
		    try {
		        double number = Double.parseDouble(str);
		        return (number > 0);
		    } catch (NumberFormatException nfe) {
		        return false;
		    }
		}
		
		//check if String is a valid US state code
		public static boolean checkState(String str){
			if(str.matches("AL|AK|AR|AZ|CA|CO|CT|DE|DC|FL|GA|HI|ID|IL|IN|IA|KS|KY|LA") ||
			str.matches("ME|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|OH|OK|OR") ||
			str.matches("PA|RI|SC|SD|TN|TX|UT|VT|VA|WA|WI|WY")){
				return true;
			}
			return false;
		}
			
			
			
				
			
		
}