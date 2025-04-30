package dev.ayush.crm.service;

import dev.ayush.crm.entities.Customer;

import java.util.List;

/**
 * CustomerService provides business logic for customer operations.
 * This interface contains CRUD operations for customer data.
 *
 * @author Ayush Singh Tomar
 * @date July 2024
 */
public interface CustomerService {

    /**
     * Retrieves customer information with the specified ID.
     *
     * @param id Customer's ID
     * @return Customer with the specified ID
     */
    Customer getById(long id);

    /**
     * Retrieves all customer information.
     *
     * @return List of customers
     */
    List<Customer> getAll();

    /**
     * Saves a new customer.
     *
     * @param customer Customer to be saved
     * @return Saved customer
     */
    Customer save(Customer customer);

    /**
     * Updates an existing customer's information.
     *
     * @param customer Customer to be updated
     * @return Updated customer
     */
    Customer update(Customer customer);

    /**
     * Deletes the customer record with the specified ID.
     *
     * @param id Customer's ID to be deleted
     */
    void deleteById(long id);

    /**
     * Retrieves customer information by email address.
     *
     * @param email Customer's email address
     * @return Customer with the specified email
     */
    Customer getByEmail(String email);

    /**
     * Retrieves customer information by phone number.
     *
     * @param phone Customer's phone number
     * @return Customer with the specified phone number
     */
    Customer getByPhone(String phone);
} 