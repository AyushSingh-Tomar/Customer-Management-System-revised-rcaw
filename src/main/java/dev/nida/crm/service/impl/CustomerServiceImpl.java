package dev.nida.crm.service.impl;

import dev.nida.crm.entities.Customer;
import dev.nida.crm.repository.CustomerRepository;
import dev.nida.crm.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Nida Başer
 * July 2024
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Customer getById(long id) {
        return customerRepository.findById(id)
                .orElse(null); //todo: Null dönmek yerine uygun bir exception fırlat
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Customer update(Customer customer) {
        return customerRepository.findById(customer.getId())
                .map(existingCustomer -> {
                    existingCustomer.setFirstName(customer.getFirstName());
                    existingCustomer.setLastName(customer.getLastName());
                    existingCustomer.setEmail(customer.getEmail());
                    existingCustomer.setPhone(customer.getPhone());
                    existingCustomer.setDistrict(customer.getDistrict());
                    existingCustomer.setCity(customer.getCity());
                    existingCustomer.setCountry(customer.getCountry());
                    existingCustomer.setAddress(customer.getAddress());
                    existingCustomer.setNotes(customer.getNotes());
                    return customerRepository.save(existingCustomer);
                }).orElse(null); //todo: Null dönmek yerine uygun bir exception fırlat
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        }
    }

    //todo: getByEmail and getByPhone
}
