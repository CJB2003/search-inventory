package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SearchInventoryApp {
    static void main(String[] args) {

        ArrayList<Product> inventory = getInventory();
        for(int i = 0; i < inventory.size(); i++){
            //storing the product information into objectP
            Product objectP = inventory.get(i);

            Collections.sort(inventory, Comparator.comparing(Product::getName));

            //using getters to get that information and printing it out
            System.out.println(objectP.getID() + " | " + objectP.getName() + " | " + objectP.getPrice());

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
}
