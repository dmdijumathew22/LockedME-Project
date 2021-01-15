package com.simplilearn.lockedme.controller;

import java.util.Scanner;

import com.simplilearn.lockedme.fileoperations.FileOperations;

public class OperationsController {
	private static Scanner scanner;
	
	//static function startapp() starts the program
	
	public static void startApp() {
		//Shows the developer details and project name
		showWelcomeScreen();
		//Shows main menu
		mainMenu();
	}
	private static void showWelcomeScreen() {
		System.out.println("-------------------------");
		System.out.println("Application: LockedMe.com");
		System.out.println(" Developer: Diju Mathew");
		System.out.println("-------------------------");
	}
	
	private static void mainMenu() {
		System.out.println("-- MAIN MENU --");
		System.out.println("1.) Show files in ascending order");
		System.out.println("2.) Perform file operations");
		System.out.println("3.) Close the application");
		System.out.println("---------------");
		//gets main menu option from user
		getMainMenuOption();

	}

	/* getMainMenuOption() considers the user input and calls the appropriate function
	 * 1 ---showFilesInAscendingOrder()
	 * 2 ---showFileOperations()
	 * 3 --- closing the application using System.exit(0) 
	 * and a default output showing invalid output. */
	private static void getMainMenuOption() {
		System.out.println("Please choose 1, 2 or 3:");
		scanner= new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
		case "1":
			FileOperations.showFilesInAscendingOrder();
			break;
		case "2":
			// shows the available file operations, add, delete and search
			showFileOperations();
		case "3":
			System.out.println("Thanks for using lockedme.com. Closing application.");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid input provided, please choose 1, 2 or 3.");
		}
		mainMenu();

	}
	public static void showFileOperations() {
		System.out.println("--------------");
		System.out.println("1.) Add a file");
		System.out.println("2.) Delete a file");
		System.out.println("3.) Search for a file");
		System.out.println("4.) Back to main menu");
		System.out.println("--------------");
		collectFileOperation();
	}

	/* collectFileOperation() considers the user input and calls the appropriate function
	 * 1 --- addAFile()
	 * 2 --- deleteFile
	 * 3 --- searchFile()
	 * 4 --- return to main menu mainMenu() 
	 * and a default output showing invalid output */
	
	public static void collectFileOperation() {
		System.out.println("Please choose 1, 2, 3 or 4:");
		String option = scanner.nextLine();
		switch (option) {
		case "1":
			FileOperations.addAFile();
			break;
		case "2":
			FileOperations.deleteFile();
			break;
		case "3":
			FileOperations.searchFile();
			break;
		case "4":
			mainMenu();
			break;
		default:
			System.out.println("Invalid input provided, please choose 1, 2, 3 or 4");
		}
		showFileOperations();
	}
	
}