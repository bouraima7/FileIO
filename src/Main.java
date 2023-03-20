import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {

    public static int o = 0; // used for looping in the demonstration for part 2
    public static int demonstration = 2; // used as the number to stop looping the reading method in part 2
    public static void main(String[] args) {
        // using Pet constructor to create objects
        // Pet is the class
        Pet pet1 = new Pet("Sunny", 3, "bird");
        Pet pet2 = new Pet("Thor", 3, "dog");
        Pet pet3 = new Pet("Max", 15, "cat");
        Pet pet4 = new Pet("Ace", 3, "dog");
        Pet pet5 = new Pet("Grady", 2, "cat");

        int overall = Pet.getCount();

        System.out.println("This is Part 1. " +overall + " objects have been created.");
        System.out.println();

        // This method is to write objects to the file named 'pets'
        try {
            writer Writer = new writer("pets.txt");
            Writer.writePet(pet1);
            Writer.writePet(pet2);
            Writer.writePet(pet3);
            Writer.writePet(pet4);
            Writer.writePet(pet5);
            Writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }

        System.out.println(overall +" pets have been created and have been saved as 'pets.txt'. Check the folder containing this code to verify");
        System.out.println();
        System.out.println();

        System.out.println("This is part two where you can read from a file and sort it into an array list");


        while (o < demonstration){
            //using a loop so that arraylist objects may be reset or overwritten. Not creating new object every loop
            Scanner in = new Scanner(System.in);
            System.out.println();
            String fileName ;
            if (o == 0){
                //first loop will suggest user to input 'pets' which is the arraylist I made
                System.out.println("Enter the filename : (pets.txt)");
                o++;
            }
            else {
                //second loop will suggest user to input 'mypet' which is the arraylist given in directions
                System.out.println("Enter the filename : (mypet.txt)");
                o++;
            }
            fileName = in.nextLine();
            File inputFile = new File(fileName);
            Scanner scanner;


            // try to open specific input file user has inputed
            try {
                scanner = new Scanner(inputFile);
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + fileName);
                return;
            }

            ArrayList<Pet> pets = new ArrayList<Pet>(); //Makes an arraylist
            int goodRecords = 0; //integer to keep track of good records
            int skippedRecords = 0;// integer to keep track of bad records

            //loops through each line in the input file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                try {
                    // parses the scanned file by spaces and creates an object in arraylist
                    String[] parts = line.split(" "); // parts array which is string type is equal to 'line' string when split
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]); //turns string into an integer
                    String type = parts[2];

                    Pet pet = new Pet(name, age, type); //'pet' is new reference for 'Pet' constructor
                    pets.add(pet); // add the pet object to the ArrayList with parameters of Pet which is in Pet class
                    goodRecords++;
                } catch (InputMismatchException e) {
                    System.out.println("Skipped record due to age format error: " + line);
                    skippedRecords++;
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Skipped record due to format error: " + line);
                    skippedRecords++;
                }
            }

            scanner.close();

            System.out.println("There were " + goodRecords + " good records in the file.");
            System.out.println("There were " + skippedRecords + " skipped records due to format errors.");
            int allRec = goodRecords + skippedRecords;
            System.out.println("There are a total of "+ allRec+" records.");
            System.out.println("The good records are:");

            for (int i = 0; i < pets.size(); i++) {
                Pet pet = pets.get(i);
                System.out.println("My pet " + (i + 1) + " is a " + pet.getType() + " " + pet.getName() + " age " + pet.getAge());
            }
        }
        }


}