package dev.ayush.crm.service;

import dev.ayush.crm.entities.Customer;
import dev.ayush.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of CustomerService interface.
 * Provides concrete implementation of customer-related business logic.
 *
 * @author Ayush Singh Tomar
 * @date July 2024
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getById(long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        if (!customerRepository.existsById(customer.getId())) {
            throw new RuntimeException("Customer not found with id: " + customer.getId());
        }
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found with id: " + id);
        }
        customerRepository.deleteById(id);
    }

    @Override
    public Customer getByEmail(String email) {
        return customerRepository.getByEmail(email)
                .orElseThrow(() -> new RuntimeException("Customer not found with email: " + email));
    }

    @Override
    public Customer getByPhone(String phone) {
        return customerRepository.getByPhone(phone)
                .orElseThrow(() -> new RuntimeException("Customer not found with phone: " + phone));
    }
} 