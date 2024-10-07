/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2024
 * File Name: DeliveryObserver.java
 * Description:This interface is responsible for the methods/attributes of a Delivery Observer.
 */

package edu.bu.met.cs665.deliverydriversystem;

/**
 * DeliveryObserver interface implemented by any classes who want to be notified of changes.
 * DeliveryObserver represents the Observer Interface of Observer Pattern
 * E.g. the Driver class will implement this interface to receive delivery updates.
 */
public interface DeliveryObserver {

  /**
   * Method implement to update/notify delivery Request for drivers that delivery details.
   *
   * @param deliveryRequest DeliveryRequest object containing the delivery information.
   */
  void receiveDeliveryNotification(String storeName, String storeLocation,
                                   DeliveryRequest deliveryRequest);

}
