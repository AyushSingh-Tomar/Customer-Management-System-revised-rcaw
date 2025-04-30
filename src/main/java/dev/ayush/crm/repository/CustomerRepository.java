package dev.ayush.crm.repository;

import dev.ayush.crm.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * CustomerRepository provides data access layer for customer data.
 * This interface extends JpaRepository to provide CRUD operations and custom queries.
 *
 * @author Ayush Singh Tomar
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Finds a customer by email address.
     *
     * @param email Customer's email address
     * @return Customer with the specified email if found
     */
    Optional<Customer> getByEmail(String email);

    /**
     * Finds a customer by phone number.
     *
     * @param phone Customer's phone number
     * @return Customer with the specified phone number if found
     */
    Optional<Customer> getByPhone(String phone);

    /**
     * Lists all customers in a specific city.
     *
     * @param cityId City ID
     * @return All customers with the specified city ID
     */
    List<Customer> getAllByCityId(Long cityId);

    /**
     * Lists all customers in a specific country.
     *
     * @param countryId Country ID
     * @return All customers with the specified country ID
     */
    List<Customer> getAllByCountryId(Long countryId);
} 