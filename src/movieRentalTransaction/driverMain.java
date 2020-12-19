package movieRentalTransaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class driverMain {

	public static void main(String[] args) throws IOException {
		
		Scanner keyboard = new Scanner(System.in);
		
		int numberOfRentals = 0;
		char anotherVideo = '\0';
		
		CustomerInformation customerInfo = new CustomerInformation();
		MovieInventory tempInventoryObj = new MovieInventory();
		MovieDataEntry entry = new MovieDataEntry();
		
		// Call the startup menu
		int menuOption = menuOptions();
		
		do {		
			switch(menuOption) {
			
			// Manually load the DVD database
			case 1:			
				char anotherFile = 'Y';						
				while(anotherFile == 'Y' || anotherFile == 'y') {				
					entry.manuallyEnteredMovieData();
					
					System.out.print("Add another file (Y / N); ");
					anotherFile =  keyboard.next().charAt(0);
				}
				break;
				
			// Use a file to load the DVD database and display
			case 2:			
				entry.fileEnteredMovieData();
				entry.displayMovieDatabase();
				break;
			
			// Online customer rental process
			case 3:		
				entry.fileEnteredMovieData();
				entry.displayMovieDatabase();
				
				do
				{
					System.out.print("\nEnter a movie ID choice ");
					int userIdChoice = keyboard.nextInt();				
		
					// Check inventory to verify selection
					tempInventoryObj = entry.findMovieID(userIdChoice);
					
					// If not null, carry through with the selection choice; else ask for another selection?
					if(tempInventoryObj != null) {
						// Determine how many days the user wants to keep
						System.out.print("\nHow many days would you like to keep the rental (7 Days Maximum) ");
						int daysRented = keyboard.nextInt();				
						
						while(daysRented < 1 || daysRented > 7) {
							System.out.print("You can rent each video for a MAXIMUM of 7 days. Please re-enter the number of days to rent '" + tempInventoryObj.getMovieName() + "' : ");
							daysRented = keyboard.nextInt();
						}
						// Set the information into the customerInfor class and increment the number of rentals
						customerInfo.setCustomerTransaction(tempInventoryObj.getMovieName(), daysRented, tempInventoryObj.getRentalCharge());
						++numberOfRentals;	
						
						if(numberOfRentals == customerInfo.maxNumberOfRentals() - 1)
							System.out.println("You can check out one more rental if you choose (Max of " + customerInfo.maxNumberOfRentals () + " rentals at a time...)");
					} 
					else
						System.out.print("We don't have this title in stock...");
							
					
					// Decide how to proceed with the customer's request
					if(numberOfRentals < customerInfo.maxNumberOfRentals()) {
						System.out.print("Would you like try another selection? (Y / N) ");
						anotherVideo = keyboard.next().charAt(0);
						
						if((anotherVideo == 'N' || anotherVideo == 'n') && numberOfRentals > 0) {	
							customerInfo.displayCustomerReceipt();
							anotherVideo = 'N';
							
						} else if((anotherVideo == 'N' || anotherVideo == 'n') && numberOfRentals == 0) {
							System.out.println("\n\nThank you for using Cra Z G's DVD Megaplex!");
							anotherVideo = 'N';
							
						} else
							anotherVideo = 'Y';
		
					} else {
						//Display the customer's receipt
						customerInfo.displayCustomerReceipt();
						anotherVideo = 'N';
					}			
				} while(anotherVideo == 'Y' || anotherVideo == 'y');
				break;
			
			// Quit the database program
			case 4:
				System.exit(0);
				break;
				
			// If the option chosen was not in the menu
			default:
				System.out.println("That was not an option from the menu... ");
				menuOption = menuOptions();
				break;
				
			} // end Switch	
			
			// Ask if user wants to return to the main menu?
			System.out.print("\nWould you like to continue from the menu? (Y/N): ");
			char continueMenu = keyboard.next().charAt(0);
			
			if(continueMenu == 'Y' || continueMenu == 'y')
				menuOption = menuOptions();
			else
				menuOption = 4;
				
		} while (menuOption != 4);		
	} // end main()
		
	
	// Menu options for the administrator
	public static int menuOptions() {
		
		Scanner keyboard = new Scanner(System.in);
		int adminChoice = 0;
		
		System.out.println("\nPlease choose from one of choices below:");
		System.out.println("1. Manually Enter Movies into Database");
		System.out.println("2. Display Movie Selection");
		System.out.println("3. Customer Rental Inquiry");
		System.out.println("4. Quit the Program");
		System.out.print("Enter your Selection: ");
		adminChoice = keyboard.nextInt();
		
		return adminChoice;
		
	} // end menuOptions()
} // end Class
