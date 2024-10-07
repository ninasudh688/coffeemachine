/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/03/2024
 * File Name: Main.java
 * Description: THis main class to help with testing outside JUnits.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.deliverydriversystem.DeliveryRequest;
import edu.bu.met.cs665.deliverydriversystem.Driver;
import edu.bu.met.cs665.deliverydriversystem.Shop;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * This is the Main class.
 */
public class Main {

  /**
   * A main method to run examples.
   * You may use this method for development purposes as you start building your
   * assignments/final project.  This could prove convenient to test as you are developing.
   * However, please note that every assignment/final projects requires JUnit tests.
   */
  public static void main(String[] args) {
    System.out.println("This is a test message from the Main class (Main.java file)\n");

    Shop shop = new Shop("Grocery Store", "456 Grocery Rd");

    // Create driver instances
    Driver driver1 = new Driver("Allen", "Van", "456 Main St");
    Driver driver2 = new Driver("Sarah",
        "Scooter", "789 Elm St");
    Driver driver3 = new Driver("Taylor", "Taxi",
        "321 Oak St");
    Driver driver5 = new Driver("Eve", "Scooter",
        "987 Birch St");

    // Register drivers with the shop
    shop.addObserver(driver1);
    shop.addObserver(driver2);
    shop.addObserver(driver3);
    shop.addObserver(driver5);
    shop.removeObserver(driver2);

    // Create a delivery request & notify
    String[] productsToDeliver2 = {"cereal", "bacon", "waffles"};
    DeliveryRequest deliveryRequest2 = new DeliveryRequest("345 red St",
        Arrays.asList(productsToDeliver2));
    shop.notifyObservers(deliveryRequest2);
    driver2.handleProductsDelivered(deliveryRequest2);

  }


}
