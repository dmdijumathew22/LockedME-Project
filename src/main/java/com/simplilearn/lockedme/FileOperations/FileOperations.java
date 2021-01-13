package com.simplilearn.lockedme.FileOperations;

import java.io.File;

import java.util.Set;
import java.util.TreeSet;

import com.simplilearn.lockedme.Controller.OperationsController;

public class FileOperations {
	final static String FOLDER = "src/main/resources/FileStorage";
	private static Set<String> sorted = new TreeSet<>();
	//private static Scanner scanner;

	public static void initialize() {
		File[] files = new File(FOLDER).listFiles();

		for (File file: files) {
			if (!file.isFile()) {
				continue;
			}
			sorted.add(file.getName());
		}
	}
	public static void showFilesInAscendingOrder() {
		initialize();
		System.out.println("------------------");
		System.out.println("Showing files in ascending order");
		sorted.forEach(System.out::println);
		System.out.println("------------------");

	}
	public static void showFileOperations() {
		System.out.println("--------------");
		System.out.println("1.) Add a file");
		System.out.println("2.) Delete a file");
		System.out.println("3.) Search for a file");
		System.out.println("4.) Back to main menu");
		System.out.println("--------------");
		OperationsController.collectFileOperation();
	}



	public static void addAFile() {
		// TODO Auto-generated method stub

	}
}
