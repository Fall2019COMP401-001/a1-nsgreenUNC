package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCustomers = scan.nextInt();
		String[] names = new String[numCustomers];
		double[] totals = new double[numCustomers];
		for (int i = 0; i < numCustomers; i++) {
			//Get names and number of items
			String firstName = scan.next();
			String lastName = scan.next();
			names[i] = firstName.substring(0,1) + ". " + lastName;
			int numberOfItems = scan.nextInt();
			double total = 0;
			for(int j = 0; j < numberOfItems; j++) {
				//Figure out what items the customer is buying
				int count = scan.nextInt();
				String name = scan.next();
				double price = scan.nextDouble();
				total += price*count;
			}
			totals[i] = total;
		}
		scan.close();
		//Print results
		for (int i = 0; i < numCustomers; i++) {
			System.out.println(names[i] + ": " + String.format("%.2f", totals[i]));
		}
		
	}
}
