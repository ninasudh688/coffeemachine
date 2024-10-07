/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2024
 * File Name: Shop.java
 * Description:This class is responsible for the methods/attributes of a retail store.
 */

package edu.bu.met.cs665.deliverydriversystem;

import java.util.ArrayList;
import java.util.List;

/**
 * This is Shop class which  is responsible for representing a Shop.
 * Shop is type of concrete Subject class  and implements method of DeliverySubject.
 * It notifies registered Driver objects about new DeliveryRequests
 */
public class Shop implements DeliverySubject {
  private String storeName;
  private String storeLocation;
  private List<DeliveryRequest> deliveryRequests;
  private List<DeliveryObserver> observers;


  /**
   * Create a Shop object using storeName,storeLocation parameters.
   *
   * @param storeName     The name of the shop.
   * @param storeLocation The physical address of the shop.
   */
  public Shop(String storeName, String storeLocation) {
    this.storeName = storeName;
    this.storeLocation = storeLocation;
    this.deliveryRequests = new ArrayList<>();
    this.observers = new ArrayList<>();
  }

  /**
   * Add/Register a new Driver/observer.
   *
   * @param observer The new driver to register.
   */
  @Override
  public void addObserver(DeliveryObserver observer) {
    if (observer == null) {
      // Can't add a NULL observer- it does not exist.
      throw new IllegalArgumentException("Observer cannot be null");
    }
    // Only add observer if not in observer list.
    if (!observers.contains(observer)) {
      observers.add(observer);
    } else {
      System.out.println("Observer already registered.");
    }
  }


  /**
   * Remove a Driver/ observer.
   *
   * @param observer The driver object to remove/unsubscribe.
   */
  @Override
  public void removeObserver(DeliveryObserver observer) {
    if (observer == null) {
      // Can't remove a NULL observer- it does not exist.
      throw new IllegalArgumentException("Observer cannot be null");
    }
    // Can not delete/unsubscribe an observer if not in observer list.
    if (observers.remove(observer)) {
      System.out.println("Observer removed successfully.");
    } else {
      System.out.println("Observer not found.");
    }
  }

  /**
   * Notify all registered Drivers of a new DeliveryRequest.
   *
   * @param deliveryRequest The DeliveryRequest to notify about.
   */
  @Override
  public void notifyObservers(DeliveryRequest deliveryRequest) {
    for (DeliveryObserver observer : observers) {
      // send store details with DeliveryRequest to each Driver
      observer.receiveDeliveryNotification(storeName, storeLocation, deliveryRequest);
    }
  }

  /**
   * Create a new delivery request and notify all observers.
   *
   * @param deliveryAddress       The delivery address for the products.
   * @param productsToBeDelivered The list of products to be delivered.
   */
  public void createDeliveryRequest(String deliveryAddress, List<String> productsToBeDelivered) {
    DeliveryRequest deliveryRequest = new DeliveryRequest(deliveryAddress, productsToBeDelivered);
    deliveryRequests.add(deliveryRequest);
    notifyObservers(deliveryRequest); // Notify all drivers
  }


  /**
   * Getter method for the shop's name.
   *
   * @return The name of the shop.
   */
  public String getStoreName() {
    return storeName;
  }

  /**
   * Setter method for the shop's name.
   *
   * @param storeName The name to assign to this shop.
   */
  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

  /**
   * Getter method for the shop's location.
   *
   * @return The physical location of the shop.
   */
  public String getStoreLocation() {
    return storeLocation;
  }

  /**
   * Setter method for the shop's location.
   *
   * @param storeLocation The location to assign to this shop.
   */
  public void setStoreLocation(String storeLocation) {
    this.storeLocation = storeLocation;
  }

  /**
   * Getter method for the list of delivery requests.
   *
   * @return The list of delivery requests associated with this shop.
   */
  public List<DeliveryRequest> getDeliveryRequests() {
    return deliveryRequests;
  }

  /**
   * Setter method for the list of delivery requests.
   *
   * @param deliveryRequests The list of delivery requests to assign to this shop.
   */
  public void setDeliveryRequests(List<DeliveryRequest> deliveryRequests) {
    this.deliveryRequests = deliveryRequests;
  }

  /**
   * Getter method for the list of observers (drivers).
   *
   * @return The list of observers (drivers) registered with this shop.
   */
  public List<DeliveryObserver> getObservers() {
    return observers;
  }

  /**
   * Setter method for the list of observers/drivers.
   *
   * @param observers The list of observers/drivers that deliver for this shop.
   */
  public void setObservers(List<DeliveryObserver> observers) {
    this.observers = observers;
  }

}
