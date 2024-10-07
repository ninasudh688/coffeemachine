/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/05/2024
 * File Name: TestDeliveryNotificationSystem.java
 * Description: This class is responsible for testing methods/classes for delivery notify system.
 */

package edu.bu.met.cs665;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.bu.met.cs665.deliverydriversystem.Shop;
import edu.bu.met.cs665.deliverydriversystem.DeliveryRequest;
import edu.bu.met.cs665.deliverydriversystem.Driver;

import java.util.Arrays;
import java.util.List;

/**
 * Some Unit tests for the Delivery Notification System.
 */
public class TestDeliveryNotificationSystem {

    @Test
    public void testDriverNotification() {
        // Given: A Shop instance
        Shop shop = new Shop("Cafe Delight", "123 Coffee St");
        // Given: Five Driver instances local freelance van, taxi, and scooter drivers
        Driver driver1 = new Driver("Allen", "Van",
            "456 Main St");
        Driver driver2 = new Driver("Sarah", "Scooter",
            "789 Elm St");
        Driver driver3 = new Driver("Taylor", "Taxi",
            "321 Oak St");
        Driver driver4 = new Driver("Jack", "Moped",
            "654 Pine St");
        Driver driver5 = new Driver("Eve", "Scooter",
            "987 Birch St");
        // Register drivers to the shop's delivery system
        shop.addObserver(driver1);
        shop.addObserver(driver2);
        shop.addObserver(driver3);
        shop.addObserver(driver4);
        shop.addObserver(driver5);

        // Given: Products to be delivered
        List<String> productsToDeliver = Arrays.asList("Latte", "Croissant", "Espresso",
            "Muffin", "Sandwich");
        String deliveryAddress = "456 Baker St";

        // When:  Broadcasting a Delivery Request
        shop.createDeliveryRequest(deliveryAddress, productsToDeliver);

        // Then: Confirm that each driver has received the notification
        assertTrue("Driver 1 should have received the notification",
            driver1.hasReceivedNotification());
        assertTrue("Driver 2 should have received the notification",
            driver2.hasReceivedNotification());
        assertTrue("Driver 3 should have received the notification",
            driver3.hasReceivedNotification());
        assertTrue("Driver 4 should have received the notification",
            driver4.hasReceivedNotification());
        assertTrue("Driver 5 should have received the notification",
            driver5.hasReceivedNotification());
    }

    @Test
    public void testMultipleDeliveryRequests() {
        // Given: A Shop and multiple Drivers
        Shop shop = new Shop("Grocery Store", "456 Grocery Rd");
        Driver driver1 = new Driver("Mia", "Scooter",
            "654 Bike St");
        Driver driver2 = new Driver("Noah", "Van",
            "987 Car St");
        shop.addObserver(driver1);
        shop.addObserver(driver2);

        // Given: Two different DeliveryRequests
        String[] products1 = {"Apples", "Bananas"};
        DeliveryRequest deliveryRequest1 = new DeliveryRequest("123 Fruit St",
            Arrays.asList(products1));

        String[] products2 = {"Tomatoes", "Potatoes"};
        DeliveryRequest deliveryRequest2 = new DeliveryRequest("321 Veggie St",
            Arrays.asList(products2));

        // When: Broadcasting both Delivery Requests
        shop.notifyObservers(deliveryRequest1);

        // Then: Confirm that each driver received notifications for both requests
        assertTrue("Driver 1 should have received the first notification",
            driver1.hasReceivedNotification());
        assertTrue("Driver 2 should have received the first notification",
            driver2.hasReceivedNotification());

        // When: Broadcasting both Delivery Requests
        shop.notifyObservers(deliveryRequest2);
        // Verify the notification for the second request
        assertTrue("Driver 1 should have received the second notification",
            driver1.hasReceivedNotification());
        assertTrue("Driver 2 should have received the second notification",
            driver2.hasReceivedNotification());
    }

    @Test
    public void testDeliveryStatusUpdate() {
        // Given: A Shop and a Driver
        Shop shop = new Shop("Book Store", "789 Book Rd");
        Driver driver = new Driver("Anna", "Car", "654 Page St");
        shop.addObserver(driver);

        // Given: A DeliveryRequest
        String[] productsToDeliver = {"Novel", "Magazine"};
        DeliveryRequest deliveryRequest = new DeliveryRequest("101 Read St",
            Arrays.asList(productsToDeliver));

        // When: Broadcasting the Delivery Request
        shop.notifyObservers(deliveryRequest);


        // Then: Verify the delivery status has been updated
        assertEquals("The delivery status should be 'pending driver'",
            "pending driver", deliveryRequest.getDeliveryStatus());
        driver.handleProductsDelivered(deliveryRequest);
        assertEquals("The delivery status should be 'delivered'",
            "delivered", deliveryRequest.getDeliveryStatus());
    }
    @Test
    public void testAddObserver() {
        // Given: A Shop and a Driver
        Shop shop = new Shop("Bakery", "123 Bread St");
        Driver driver = new Driver("Lucy", "Scooter",
            "456 Cake Ave");

        // When: Adding the Driver as an Observer
        shop.addObserver(driver);

        // Then: Verify that the driver has been added
        assertTrue("Driver should be added as an observer",
            shop.getObservers().contains(driver));
    }
    @Test
    public void testRemoveObserver() {
        // Given: A Shop and a Driver
        Shop shop = new Shop("Flower Shop", "789 Blossom Rd");
        Driver driver = new Driver("Alex", "Van",
            "654 Petal St");
        Driver driver2 = new Driver("Tim", "Bicycle",
            "56 Petal St");
        // Add the Driver as an Observer
        shop.addObserver(driver);
        shop.addObserver(driver2);

        assertTrue("Driver should be added as an observer",
            shop.getObservers().contains(driver));

        // When: Removing the Driver from the Observers
        shop.removeObserver(driver);

        // Then: Verify that the driver has been removed
        assertFalse("Driver should be removed as an observer",
            shop.getObservers().contains(driver));
    }


}
