package com.simplilearn.lockedme.fileoperations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FileOperations {
	 // static string FOLDER have the output directory path
	final static String FOLDER = "src/main/resources/FileStorage";
	private static Set<String> sorted = new TreeSet<>();
	private static Scanner scanner;

	/*
	 * initializes the the tree set sorted with file names from "FOLDER"
	 * directory . Sorts in ASCII standard.
	 */	
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
	public static void addAFile() {
		 System.out.println("Please provide a file path:");
		 scanner= new Scanner(System.in);
	        String filePath = scanner.nextLine();
	        Path path = Paths.get(filePath);

	        if (!Files.exists(path)) {
	            System.out.println("File does not exist");
	            return;
	        }

	        String newFilePath = FOLDER + "/" + path.getFileName();
	        int inc = 0;
	        while (Files.exists(Paths.get(newFilePath))) {
	            inc++;
	            newFilePath = FOLDER + "/" + inc + "_" + path.getFileName();
	        }
	        try {
	            Files.copy(path, Paths.get(newFilePath));
	        } catch(IOException e) {
	            System.out.println("Unable to copy file to " + newFilePath);
	        }


	}
	
	public static void deleteFile() {
		initialize();
		System.out.println("Please provide the file name:");
		 scanner= new Scanner(System.in);
	        String fileName = scanner.nextLine();
		if(sorted.contains(fileName)) {
			File delFile = new File(FOLDER+"/"+fileName); 
		    if (delFile.delete()) { 
		      System.out.println("Deleted the file: " + delFile.getName());
		      sorted.remove(fileName);
		    } else {
		      System.out.println("Failed to delete the file.");
		    } 
		}else
			System.out.println("File not Found.");
		
	}
	public static void searchFile() {
		initialize();
		System.out.println("Please provide the file name:");
		 scanner= new Scanner(System.in);
	        String fileName = scanner.nextLine();
		if(sorted.contains(fileName)) {
			System.out.println("File Found in Directory :"+ FOLDER);
		}else 
			System.out.println("File not Found in Directory. ");
		
		
	}
}
