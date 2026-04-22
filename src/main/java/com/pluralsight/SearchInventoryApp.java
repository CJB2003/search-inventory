package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;

public class SearchInventoryApp {
    static Scanner myScanner = new Scanner(System.in);
    static void main(String[] args) {

        //menu asking user what they want to do
        System.out.print("What do you want to do?\n" +
                "1- List all products\n" +
                "2- Lookup a product by its id\n" +
                "3- Find all products within a price range\n" +
                "4- Add a new product\n" +
                "5- Quit the application\n" +
                "Enter command: "
        );
        //user input for command
        int command = myScanner.nextInt();
        myScanner.nextLine();
        //switch statement for the choices
        switch (command) {
            case 1:
                listAllProducts();
                break;
            case 2:
                listByProductID();
                break;
            case 3:
                listByPriceRange();
                break;
            case 4:
                addAProduct();
                break;
            case 5:
                //exits out of the program
                System.out.println("Exiting...");
                System.exit(0);
        }
    }

    public static ArrayList<Product> getInventory() {

        //create EMPTY ArrayList
        ArrayList<Product> inventory = new ArrayList<>();
        //try and catch statement
        try {
            //filereader and bufferedreader to read inventory.csv
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader buffReader = new BufferedReader(fileReader);

            //initialize String line to assign it the lines that buff reader
            String line;
            while ((line = buffReader.readLine()) != null) {

                //parsing the information being read and splitting by |
                //3 parts, ID, product name, and price
                String[] productParts = line.split("\\|");
                int ID = Integer.parseInt(productParts[0]);
                String pName = productParts[1];
                double price = Double.parseDouble(productParts[2]);

                //creating new object to store the parts into them
                Product product = new Product(ID, pName, price);

                //adding the object product to the Array List
                inventory.add(product);
            }
            //closing the file reader
            fileReader.close();

            //prints file could not be found if error
        } catch (Exception e) {
            System.out.println("File could not be found.");
        }
        return inventory;
    }
    public static void listAllProducts() {

        ArrayList<Product> inventory = getInventory();
        System.out.print("\n");

        for(int i = 0; i < inventory.size(); i++){
            //storing the product information into objectP
            Product objectP = inventory.get(i);

            inventory.sort(Comparator.comparing(Product::getName));

            //using getters to get that information and printing it out
            System.out.println(objectP.getID() + " | " + objectP.getName() + " | " + objectP.getPrice());
        }
    }
    public static void listByProductID() {


    }
    public static void listByPriceRange() {

    }
    public static void addAProduct() {


    }
}
