package a1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//Enter in prices
		int numPrices = scan.nextInt();
		Map<String, Double> prices = new HashMap<String, Double>(); 
		for (int i = 0; i < numPrices; i++) {
			String nameProduct = scan.next();
			Double price = scan.nextDouble();
			prices.put(nameProduct, price);
		}
		int numCustomers = scan.nextInt();
		String[] names = new String[numCustomers];
		double[] totals = new double[numCustomers];
		for (int i = 0; i < numCustomers; i++) {
			//Get names and number of items
			String firstName = scan.next();
			String lastName = scan.next();
			names[i] = firstName + " " + lastName;
			int numberOfItems = scan.nextInt();
			double total = 0;
			for(int j = 0; j < numberOfItems; j++) {
				//Figure out what items the customer is buying
				int count = scan.nextInt();
				String name = scan.next();
				double price = prices.get(name);
				total += price*count;
			}
			totals[i] = total;
		}
		scan.close();
		//Print results
		int max = maxLoc(totals);
		int min = minLoc(totals);
		System.out.println("Biggest: " + names[max] + 
				" (" + String.format("%.2f", totals[max]) + ")");
		System.out.println("Smallest: " + names[min] 
				+ " (" + String.format("%.2f", totals[min]) + ")");
		System.out.println("Average: " 
				+ String.format("%.2f", average(totals)));
		
		
	}
	//Finds the average value of an array
	//Input: Array of doubles
	//Output: Average
	public static double average(double[] nums) {
		double sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum/nums.length;
	}
	//Finds the index of the highest value in the array
	//Input: Array of doubles
	//Output: Index of max
	public static int maxLoc(double[] nums) {
		double max = nums[0];
		int maxIndex = 0;
		for(int i = 0; i < nums.length; i++) {
			if (nums[i] > max){
				max = nums[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	//Finds the index of the lowest value in the array
	//Input: Array of doubles
	//Output: Index as an int
	public static int minLoc(double[] nums) {
		double min = nums[0];
		int minIndex = 0;
		for(int i = 0; i < nums.length; i++) {
			if (nums[i] < min){
				min = nums[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}
