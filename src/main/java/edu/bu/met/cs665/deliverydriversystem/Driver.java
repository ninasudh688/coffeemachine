/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2024
 * File Name: Driver.java
 * Description:This class is responsible for the methods/attributes of a Driver.
 */

package edu.bu.met.cs665.deliverydriversystem;

import java.time.format.DateTimeFormatter;

/**
 * This is Driver class which  is responsible for representing an Observer like Drivers.
 * Driver is type of concrete Observer class and implements method of DeliveryObserver.
 * It represents driver who can make deliveries by receiving delivery requests.
 */
public class Driver implements DeliveryObserver {
  private String driverName;
  private String vehicleType;
  private String startingAddress;
  private boolean hasReceivedNotification; // Track notification state

  /**
   * Create a Driver object using driverName,vehicleType,startingAddress parameters.
   *
   * @param driverName      The name of the driver.
   * @param vehicleType     The type of vehicle the driver uses (ex: van, scooter, taxi).
   * @param startingAddress The driver's starting/current location address before delivery starts.
   */
  public Driver(String driverName, String vehicleType, String startingAddress) {
    this.driverName = driverName;
    this.vehicleType = vehicleType;
    this.startingAddress = startingAddress;
    //this.hasReceivedNotification = false; // Initially set to false

  }

  /**
   * Update method to receive delivery requests from the Shop.
   *
   * @param storeName       The name of the store sending the delivery.
   * @param storeLocation   The location of the store.
   * @param deliveryRequest The DeliveryRequest that is being notified.
   */
  @Override
  public void receiveDeliveryNotification(String storeName, String storeLocation,
                                          DeliveryRequest deliveryRequest) {

    // Reset notification state to false at the beginning
    hasReceivedNotification = false;
    // for testing: System.out.println("InitialReceivedNotification: " + hasReceivedNotification );

    //Format timestamp to be readable.
    DateTimeFormatter humanReadableFormat = DateTimeFormatter.ofPattern("MMMM d, yyyy, h:mm a");
    String formattedDate = deliveryRequest.getDeliveryCreatedOn().format(humanReadableFormat);

    // Access delivery and shop details via the deliveryRequest
    System.out.println(vehicleType + " Driver " + driverName
        + " notified of a new delivery request from Shop: " + storeName
        + " located at " + storeLocation
        + " \t\nDelivery order created at: " + formattedDate
        + " \t\t\nProducts to deliver: " + deliveryRequest.getProductsToBeDelivered()
        + " \t\t\nCurrent Delivery Status: " + deliveryRequest.getDeliveryStatus()
        + "\t\n Driver starts from: " + startingAddress
        + " to Delivery Address: " + deliveryRequest.getDeliveryAddress());

    deliveryRequest.setDeliveryStatus("pending driver");
    // Updated the notification state to true when a notification is received
    hasReceivedNotification = true;

    System.out.println("\tDriverhasReceivedNotification: " + hasReceivedNotification);
    System.out.println("\tDelivery status updated to 'pending driver' for" + driverName
        + " for delivery request to: " + deliveryRequest.getDeliveryAddress() + "\n");

  }

  /**
   * Method to for products are delivered as part of notification.
   *
   * @param deliveryRequest The DeliveryRequest that contains the products delivered.
   */
  public void handleProductsDelivered(DeliveryRequest deliveryRequest) {
    // Change the delivery status
    System.out.println("Driver " + driverName
        + " has successfully delivered the following products to: "
        + deliveryRequest.getDeliveryAddress());
    for (String product : deliveryRequest.getProductsToBeDelivered()) {
      System.out.println("\t Product: " + product);
    }
    // Update the delivery status to 'delivered'
    deliveryRequest.setDeliveryStatus("delivered");
    System.out.println("Delivery status updated to 'delivered' for request to: "
        + deliveryRequest.getDeliveryAddress());
  }


  /**
   * Boolean method that checks if the driver has received a notification.
   *
   * @return boolean indicating whether a notification has been received.
   */
  public boolean hasReceivedNotification() {
    return hasReceivedNotification;
  }

  /**
   * Getter method for the driver's name.
   *
   * @return The name of this driver.
   */
  public String getDriverName() {
    return driverName;
  }

  /**
   * Setter method for the driver's name.
   *
   * @param driverName The name to assign to this driver.
   */
  public void setDriverName(String driverName) {
    this.driverName = driverName;
  }

  /**
   * Getter method for the driver's vehicle type.
   *
   * @return The type of vehicle used by this driver.
   */
  public String getVehicleType() {
    return vehicleType;
  }

  /**
   * Setter method for the driver's vehicle type.
   *
   * @param vehicleType The vehicle type to assign to this driver.
   */
  public void setVehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
  }

  /**
   * Getter method for the driver's starting address.
   *
   * @return The starting address of the driver as String.
   */
  public String getStartingAddress() {
    return startingAddress;
  }

  /**
   * Setter method for the driver's starting address.
   *
   * @param startingAddress The starting address of the driver.
   */
  public void setStartingAddress(String startingAddress) {
    this.startingAddress = startingAddress;
  }


}
