package movieRentalTransaction;

import java.util.Arrays;

public class CustomerInformation {

	private final int MAX_RENTALS = 3;
	
	private int numberOfItems;
	private String[] movieName;
	private int[] daysToRent;
	private double[] rentalCost;
	
	CustomerInformation() {
		numberOfItems = 0;
		movieName = new String[MAX_RENTALS]; // Initial capacities
		daysToRent = new int[MAX_RENTALS];
		rentalCost = new double[MAX_RENTALS];
	}

	public String[] getMovieName() {
		return movieName;
	}

	public int[] getDaysToRent() {
		return daysToRent;
	}

	public double[] getRentalCost() {
		return rentalCost;
	}
	
	public int getNumberOfItems() {
		return numberOfItems;
	}
	
	public int maxNumberOfRentals() {
		return MAX_RENTALS;
	}

	public void setCustomerTransaction(String movieName, int daysToRent, double rentalCost) {
		this.movieName[numberOfItems] = movieName;
		this.daysToRent[numberOfItems] = daysToRent;
		this.rentalCost[numberOfItems] = rentalCost;
		++numberOfItems;  // Increment the MAX_RENTALS
	}
	
	public void setMovieName(String name) {
		movieName[numberOfItems] = name;
	}
	
	public void setDaysToRent(int days) {
		daysToRent[numberOfItems] = days;
	}
	
	public void setRentalCost(double cost) {
		rentalCost[numberOfItems] = cost;
	}

	public void setNumberOfItems() {
		++numberOfItems;
	}
	
	public void displayCustomerReceipt() {
		
		final double TAX_RATE = 0.05;
		double subTotal = 0.0;
		
		System.out.printf("\n%-30s%-15s%-15s", "Titles", "Rental Days", "Rental Cost");
		System.out.printf("\n%-30s%-15s%-15s", "=========================", "===========", "===========");
		for(int x = 0; x < numberOfItems; ++x) {
			
			System.out.printf("\n%-26s%15s%15s", movieName[x], daysToRent[x], rentalCost[x]);
			subTotal += rentalCost[x];
		}
		System.out.printf("\n========================================================");
		System.out.printf("\n\nSub Total: %,.2f", subTotal);
		System.out.printf("\nTotal Tax: %,.2f", (subTotal * TAX_RATE));
		System.out.printf("\nTotal:     %,.2f", (subTotal + (subTotal * TAX_RATE)));
		System.out.println("\n\nThank you for using Cra Z G's DVD Megaplex!");
	}
	
	@Override
	public String toString() {
		return "CustomerInformation [MAX_RENTALS=" + MAX_RENTALS + ", numberOfItems=" + numberOfItems + ", movieName="
				+ Arrays.toString(movieName) + ", daysToRent=" + Arrays.toString(daysToRent) + ", rentalCost="
				+ Arrays.toString(rentalCost) + "]";
	}
}
