package Assignment3;

import java.util.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ShoppingCartDriver {

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
				
				for (String s = reader.readLine(); s != null; s = reader.readLine()) 
				{
					// Error case???
					//String[] parsed = readString(s);
					//Actual functions here
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
}