package a1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//Enter in prices
		int numPrices = scan.nextInt();
		Map<String, Double> prices = new HashMap<String, Double>(); 
		//Number of items bought
		Map<String, Integer> itemsBought = new HashMap<String, Integer>();
		//Number of customers that bought each item
		Map<String, Integer> customersBought = new HashMap<String, Integer>();
		String[] productNames = new String[numPrices];
		for (int i = 0; i < numPrices; i++) {
			String nameProduct = scan.next();
			Double price = scan.nextDouble();
			prices.put(nameProduct, price);
			itemsBought.put(nameProduct, 0);
			customersBought.put(nameProduct, 0);
			productNames[i] = nameProduct;
		}
		int numCustomers = scan.nextInt();
		String[] names = new String[numCustomers];
		double[] totals = new double[numCustomers];

		for (int i = 0; i < numCustomers; i++) { //Loop for each customer
			//Get names and number of items
			String firstName = scan.next();
			String lastName = scan.next();
			names[i] = firstName + " " + lastName;
			int numberOfItems = scan.nextInt();
			double total = 0;
			//Get list of old numbers
			int[] oldCounts = new int[productNames.length];
			for(int j = 0; j < productNames.length; j++) {
				oldCounts[j] = itemsBought.get(productNames[j]);
			}
			for(int j = 0; j < numberOfItems; j++) { //Loop for each product
				//Figure out what items the customer is buying, add to count in array
				int count = scan.nextInt();
				String name = scan.next();
				double price = prices.get(name);
				total += price*count;
				itemsBought.put(name, itemsBought.get(name) + count);
				
			}
			//Compare number bought with before to change number of customers
			for(int j = 0; j < productNames.length; j++) {
				String productName = productNames[j];
				if (oldCounts[j] != itemsBought.get(productName)) {
					customersBought.put(productName, customersBought.get(productName) + 1);
				}
			}
			totals[i] = total;
		}
		scan.close();
		//Print results
		for (int i = 0; i < productNames.length; i++) {
			int numCustBought = customersBought.get(productNames[i]);
			int numItemBought = itemsBought.get(productNames[i]);
			System.out.println((numCustBought != 0 ? numCustBought : "No")
					+ " customers bought " 
					+ (numItemBought > 0 ? numItemBought + " " : "")
					+ productNames[i]);
		}
		
		
	}
}
