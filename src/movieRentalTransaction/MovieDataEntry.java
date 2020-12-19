package movieRentalTransaction;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;

// Super-User class to load inventory into a database
public class MovieDataEntry {
	
	private MovieInventory head;
	
	public MovieDataEntry() {
		head = null;
	}
	
	// Manually enter movie inventory into database
	public void manuallyEnteredMovieData() throws IOException {
		
		// Append the new MovieInventory selections to the file
		FileWriter writeFile = new FileWriter("C:\\Users\\User\\Documents\\EclipseProjects\\Movie Rental\\src\\BackupMovieInventory.txt", true);
		PrintWriter outputFile = new PrintWriter(writeFile);
		
		Scanner keyboard = new Scanner(System.in);
		
		// Get the information about the movie
		System.out.print("\n\nEnter the 4-Digit Movie ID Number: ");
		int id = keyboard.nextInt();
		outputFile.print(id + ",");
		keyboard.nextLine(); // Consumes the newline character
		
		System.out.print("Enter the Movie Name: ");
		String name = keyboard.nextLine();
		outputFile.print(name + ",");
		
		System.out.print("Enter the Movie Genre: ");
		String genre = keyboard.nextLine();
		outputFile.print(genre + ",");
		
		System.out.print("Enter the Rental Charge: ");
		double charge = keyboard.nextDouble();	
		outputFile.print(charge + ",");
		keyboard.nextLine(); // Consumes the newLine character
		
		System.out.print("Enter the Movie Synopsis: ");
		String description = keyboard.nextLine();
		outputFile.print(description + '\n');
		outputFile.close();
		
	} // end manuallyEnteredMovieData()
	
	// Using a file to enter movie data into database
	public void fileEnteredMovieData() throws FileNotFoundException {
		
		Scanner inputFile = new Scanner(new File("C:\\Users\\User\\Documents\\EclipseProjects\\Movie Rental\\src\\BackupMovieInventory.txt"));
		inputFile.useDelimiter(",|\n");
		
		while(inputFile.hasNext()) {
			
			int id = inputFile.nextInt();
			String name = inputFile.next();
			String genre = inputFile.next();
			double charge = inputFile.nextDouble();
			String description = inputFile.next();
			
			// Pass the information to the linked list
			createMovieDatabase(id, name, genre, charge, description);
		}
	} // end fileEnteredMovieData
	
	// Used to enter store inventory in linked list; genres are alphabetized
	private void createMovieDatabase(int id, String name, String genre, double charge, String description) {
		
		MovieInventory newNode = new MovieInventory(id, name, genre, charge, description, null);
	
		if(head == null) {
			head = newNode;
			return;
		}
		else {
			MovieInventory currentPtr = head;
			MovieInventory previousPtr = null;
	
			// Organize the 'genres' in alphabetical order
			while((currentPtr != null) && (newNode.getMovieID() > currentPtr.getMovieID())) {
				previousPtr = currentPtr;
				currentPtr = currentPtr.getLink();
			}
			// Set the newNode as the head of the linked list
			if(currentPtr == head) {
				newNode.setLink(head);
				head = newNode; 	
			}
			// Insertion
			else if(currentPtr != null) {
				previousPtr.setLink(newNode);
				newNode.setLink(currentPtr);	
			}								
			// Add to end of list
			else {
				currentPtr = newNode;
				previousPtr.setLink(currentPtr);
			}	
		} // end Else
	} // end createMovieDatabase()
	
	// Display the movie inventory by categories
	public void displayMovieDatabase() {

		MovieInventory currentPtr = head;
		
		if(head == null)
			System.out.println("There is no inventory to display");
		else {
			while (currentPtr != null) {
			
				// Display the 'Action' movies in the store inventory
				System.out.println("\nAction");
				System.out.println("================================================================================================");			
				while (currentPtr.getMovieID() >= 1000 && currentPtr.getMovieID() < 2000) {
					System.out.printf("%-10s%-30s%-10s%-100s\n", currentPtr.getMovieID(), currentPtr.getMovieName(), currentPtr.getRentalCharge(), currentPtr.getSynopsis());
					currentPtr = currentPtr.getLink();
				}
					
				// Display the 'Horror' movies in the store inventory
				System.out.println("\nHorror");
				System.out.println("================================================================================================");
				while (currentPtr.getMovieID() >= 2000 && currentPtr.getMovieID() < 3000) {
					System.out.printf("%-10s%-30s%-10s%-100s\n", currentPtr.getMovieID(), currentPtr.getMovieName(), currentPtr.getRentalCharge(), currentPtr.getSynopsis());
					currentPtr = currentPtr.getLink();
				}
				
				// Display the 'Romantic Comedy' movies in the store inventory
				System.out.println("\nRomantic Comedies");
				System.out.println("================================================================================================");
				while (currentPtr.getMovieID() >= 3000 && currentPtr.getMovieID() < 4000) {
					System.out.printf("%-10s%-30s%-10s%-100s\n", currentPtr.getMovieID(), currentPtr.getMovieName(), currentPtr.getRentalCharge(), currentPtr.getSynopsis());
					currentPtr = currentPtr.getLink();
				}
				
				// Display the 'Western' movies in the store inventory
				System.out.println("\nWesterns");
				System.out.println("================================================================================================");
				while (currentPtr != null && (currentPtr.getMovieID() >= 4000 && currentPtr.getMovieID() < 5000)) {
					System.out.printf("%-10s%-30s%-10s%-100s\n", currentPtr.getMovieID(), currentPtr.getMovieName(), currentPtr.getRentalCharge(), currentPtr.getSynopsis());
					currentPtr = currentPtr.getLink();
				}
			} // end outer While Loop
		} // end Else
	} // end displayMovieList()
	
	// Find a selection in the linked list
	public MovieInventory findMovieID(int ID) {
		
		MovieInventory currentPtr = head;
		
		// If found, return the object
		if(head == null)
			return currentPtr;
		else {

			while(currentPtr != null) {
				if(currentPtr.getMovieID() == ID)
					return currentPtr;
				else
					currentPtr = currentPtr.getLink();
			}
		}			
		// Otherwise, ID was not found (Null)
		return currentPtr;
		
	} // end findMovieID()
} // end Class


