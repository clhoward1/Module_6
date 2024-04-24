/**
 * @author Cory Howard - clhoward1
 * CIS175 - Spring 2024
 * Feb 1, 2024
 */

import java.util.List;
import java.util.Scanner;

import controller.ListTanksHelper;
import model.ListTanks;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListTanksHelper lth = new ListTanksHelper();
				
		public static void main(String[] args) {
			runMenu();
		}

		/**
		 * Menu of Program
		 */
		public static void runMenu() {
			boolean goAgain = true;
			
			System.out.println("--- Welcome to my tank database. ---");
			
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add a Tank");
				System.out.println("*  2 -- Edit a Tank");
				System.out.println("*  3 -- Delete a Tank");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addTank();
				} else if (selection == 2) {
					editTank();
				} else if (selection == 3) {
					deleteTank();
				} else if (selection == 4) {
					viewTheList();
				} else if (selection == 5) {
					lth.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				} else {
					System.out.println("Please Select an option from 1 through 5");
					
				}

			}

		}

		/**
		 * Adds a tank with all info
		 */
		private static void addTank() {
			System.out.print("Enter a country: ");
			String country = in.nextLine();
			System.out.print("Enter a model: ");
			String model = in.nextLine();
			System.out.print("Enter a gun caliber: ");
			String gunCaliber = in.nextLine();
			
			ListTanks toAdd = new ListTanks(country, model, gunCaliber);
			lth.insertTank(toAdd);

		}

		/**
		 * Deletes a Tank if exact info is given
		 */
		private static void deleteTank() {
			System.out.print("Enter the country to delete: ");
			String country = in.nextLine();
			System.out.print("Enter the model to delete: ");
			String model = in.nextLine();
			System.out.print("Enter the gun caliber to delete: ");
			String gunCaliber = in.nextLine();
			
			ListTanks toDelete = new ListTanks(country, model, gunCaliber);
			lth.deleteTank(toDelete);

		}

		/**
		 * Searches and Edits a Tank
		 */
		private static void editTank() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Country");
			System.out.println("2 : Search by Model");
			System.out.println("3 : Search by Gun Caliber");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListTanks> foundTanks;
			
			/**
			 * Decides which way to search using the user input from above
			 */
			if (searchBy == 1) {
				System.out.print("Enter the country name: ");
				String country = in.nextLine();
				foundTanks = lth.searchForTankByCountry(country);
			} else if (searchBy == 2) {
				System.out.print("Enter the model name: ");
				String model = in.nextLine();
				foundTanks = lth.searchForTankByModel(model);
			} else {
				System.out.print("Enter the gun caliber: ");
				String gunCaliber = in.nextLine();
				foundTanks = lth.searchForTankByGunCaliber(gunCaliber);
			}

			/**
			 * If it finds records it will print them out
			 * and then ask what which record to update
			 */
			if (!foundTanks.isEmpty()) {
				System.out.println("Found Results.");
				for (ListTanks l : foundTanks) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				/**
				 * Asks for what part of record to update
				 */
				ListTanks toEdit = lth.searchForTankById(idToEdit);
				System.out.println("Retrieved " + toEdit.getModel() + " from " + toEdit.getCountry());
				System.out.println("1 : Update Country");
				System.out.println("2 : Update Model");
				System.out.println("3 : Update Gun Caliber");
				int update = in.nextInt();
				in.nextLine();

				/**
				 * Updates selected part of record
				 */
				if (update == 1) {
					System.out.print("New Country: ");
					String country = in.nextLine();
					toEdit.setCountry(country);
				} else if (update == 2) {
					System.out.print("New Model: ");
					String model = in.nextLine();
					toEdit.setModel(model);
				} else if (update == 3) {
					System.out.print("New Gun Caliber: ");
					String gunCaliber = in.nextLine();
					toEdit.setGunCaliber(gunCaliber);
				}

				lth.updateTank(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		/**
		 * prints out every record in table
		 */
		private static void viewTheList() {
			List<ListTanks> allTanks = lth.showAllTanks();
			
			for(ListTanks singleTank : allTanks){
				System.out.println(singleTank.returnTankDetails());
				}

		}

	}