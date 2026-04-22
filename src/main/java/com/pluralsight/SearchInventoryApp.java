package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SearchInventoryApp {
    static void main(String[] args) {

        ArrayList<Product> inventory = getInventory();
        System.out.println("");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("ID: %d | %s - Price: $%.2f%n",
                    p.getID(), p.getName(), p.getPrice());
        }
    }
    public static ArrayList<Product> getInventory() {
        //try and catch statement
        try {
            //filereader and bufferedreader to read inventory.csv
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader buffReader = new BufferedReader(fileReader);

            //create ArrayList
            ArrayList<Product> inventory = getInventory();

            //initialize String line to assign it the lines that buff reader
            String line;
            while((line = buffReader.readLine()) != null) {

                //parsing the information being read and splitting by |
                //3 parts, ID, product name, and price
                String[] productParts = line.split("\\|");
                int ID = Integer.parseInt(productParts[0]);
                String pName = productParts[1];
                double price = Double.parseDouble(productParts[2]);

                //creating new object to store the parts into them
                Product product = new Product(ID, pName, price);
            }
            //closing the file reader
            fileReader.close();

            //prints file could not be found if error
        }catch (Exception e) {
            System.out.println("File could not be found.");
    }

}
