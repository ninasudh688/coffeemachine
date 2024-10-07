/**
 * Name: Nina Sudheesh
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/04/2024
 * File Name: DeliveryRequest.java
 * Description:This interface is responsible for the methods/attributes of a Delivery Request.
 */

package edu.bu.met.cs665.deliverydriversystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DeliveryRequest {
  private String deliveryAddress;
  private List<String> productsToBeDelivered;
  private LocalDateTime deliveryCreatedOn; // Timestamp of when the delivery was created.
  private String deliveryStatus; // Current status of the delivery.

  /**
   * Create a DeliveryRequest object using parameters.
   *
   * @param deliveryAddress       The delivery address of customer for the products.
   * @param productsToBeDelivered The list of products included in this delivery request.
   */
  public DeliveryRequest(String deliveryAddress, List<String> productsToBeDelivered) {
    this.deliveryAddress = deliveryAddress;
    this.productsToBeDelivered = new ArrayList<>(productsToBeDelivered);
    this.deliveryCreatedOn = LocalDateTime.now(); // Set the current time
    this.deliveryStatus = "created delivery"; // Initial status
  }


  /**
   * Getter method for the deliveryAddress.
   *
   * @return The customer delivery address for this delivery request as a String.
   */
  public String getDeliveryAddress() {
    return deliveryAddress;
  }

  /**
   * Setter method for the deliveryAddress.
   *
   * @param deliveryAddress The Customer's delivery address as a String.
   */
  public void setDeliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }

  /**
   * Getter method for productsToBeDelivered.
   *
   * @return A list of String products to be delivered in this delivery request.
   */
  public List<String> getProductsToBeDelivered() {
    return productsToBeDelivered;
  }

  /**
   * Setter method for productsToBeDelivered.
   *
   * @param productsToBeDelivered A List of Strings products to be delivered.
   */
  public void setProductsToBeDelivered(List<String> productsToBeDelivered) {
    this.productsToBeDelivered = productsToBeDelivered;
  }

  /**
   * Gets the timestamp of when this delivery request was created.
   *
   * @return A LocalDateTime object = the time of the delivery request.
   */
  public LocalDateTime getDeliveryCreatedOn() {
    return deliveryCreatedOn;
  }

  /**
   * Sets the timestamp of when this delivery request was created.
   *
   * @param deliveryCreatedOn A LocalDateTime object = new created time of the delivery request.
   */
  public void setDeliveryCreatedOn(LocalDateTime deliveryCreatedOn) {
    this.deliveryCreatedOn = deliveryCreatedOn;
  }

  /**
   * Gets the current status of this delivery request.
   *
   * @return The delivery status as a String (ex: "pending"/ "completed").
   */
  public String getDeliveryStatus() {
    return deliveryStatus;
  }

  /**
   * Sets the delivery status.
   *
   * @param deliveryStatus The new status of the delivery request as a String.
   */
  public void setDeliveryStatus(String deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
  }

}
