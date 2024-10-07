/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2024
 * File Name: DeliverySubject.java
 * Description:This interface is responsible for the methods/attributes of a Delivery Subject.
 */

package edu.bu.met.cs665.deliverydriversystem;

/**
 * DeliverySubject interface implemented by classes that need to maintain observers.
 * DeliverySubject represents the Subject Interface of Observer Pattern.
 * E.g.Shop class will implement this interface to notify & manage delivery requests for drivers.
 */
public interface DeliverySubject {
  /**
   * Method to be implemented to add/register a new observer to get notifications for delivery .
   *
   * @param observer The observer ( AKA Driver) that wants to be notified.
   */
  void addObserver(DeliveryObserver observer);


  /**
   * Method to be implemented to remove/unsubscribe an observer from the notification.
   * Observer can no longer receiving future delivery updates.
   *
   * @param observer The observer AKA Driver to be removed from notifications.
   */
  void removeObserver(DeliveryObserver observer);

  /**
   * Method to be implemented to notify all observers about the delivery request.
   *
   * @param deliveryRequest The delivery request details from store to notify drivers.
   */
  void notifyObservers(DeliveryRequest deliveryRequest);
}