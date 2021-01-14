package com.simplilearn.lockedme.controller;

import java.util.Scanner;

import com.simplilearn.lockedme.fileoperations.FileOperations;

public class OperationsController {
	private static Scanner scanner;
	public static void startApp() {
		showWelcomeScreen();
		mainMenu();
	}

	private static void mainMenu() {
		System.out.println("-- MAIN MENU --");
		System.out.println("1.) Show files in ascending order");
		System.out.println("2.) Perform file operations");
		System.out.println("3.) Close the application");
		System.out.println("---------------");
		getMainMenuOption();

	}
	private static void showWelcomeScreen() {
		System.out.println("-------------------------");
		System.out.println("Application: LockedMe.com");
		System.out.println(" Developer: Diju Mathew");
		System.out.println("-------------------------");
	}
	private static void getMainMenuOption() {
		System.out.println("Please choose 1, 2 or 3:");
		scanner= new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
		case "1":
			FileOperations.showFilesInAscendingOrder();
			break;
		case "2":
			FileOperations.showFileOperations();
		case "3":
			System.out.println("Thanks for using lockedme.com. Closing application.");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid input provided, please choose 1, 2 or 3.");
		}
		mainMenu();

	}
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
		}
		FileOperations.showFileOperations();
	}
}