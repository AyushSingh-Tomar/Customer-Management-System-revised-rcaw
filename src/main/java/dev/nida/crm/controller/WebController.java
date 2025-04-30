package dev.ayush.crm.controller;

import dev.ayush.crm.entities.Customer;
import dev.ayush.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Web controller for handling web page requests.
 * 
 * @author Ayush Singh Tomar
 */
@Controller
public class WebController {

    private final CustomerService customerService;

    @Autowired
    public WebController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Add data for dashboard
        model.addAttribute("currentPage", "dashboard");
        model.addAttribute("customerCount", customerService.getAll().size());
        model.addAttribute("companyCount", 0); // TODO: Implement company service
        model.addAttribute("activeOfferCount", 0); // TODO: Implement offer service
        model.addAttribute("pendingPaymentCount", 0); // TODO: Implement payment service
        
        // Add empty recent activities for now
        model.addAttribute("recentActivities", java.util.Collections.emptyList());
        
        return "dashboard";
    }

    @GetMapping("/customers")
    public String customers(Model model) {
        model.addAttribute("currentPage", "customers");
        model.addAttribute("customers", customerService.getAll());
        return "customers/list";
    }

    @GetMapping("/customers/new")
    public String newCustomer(Model model) {
        model.addAttribute("currentPage", "customers");
        model.addAttribute("customer", new Customer());
        return "customers/form";
    }

    @GetMapping("/customers/{id}/edit")
    public String editCustomer(@PathVariable Long id, Model model) {
        model.addAttribute("currentPage", "customers");
        Customer customer = customerService.getById(id);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "customers/form";
        }
        return "redirect:/customers";
    }

    @PostMapping("/customers")
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @PostMapping("/customers/{id}")
    public String updateCustomer(@PathVariable Long id, @ModelAttribute Customer customer) {
        customer.setId(id);
        customerService.update(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customers/{id}/delete")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return "redirect:/customers";
    }

    // TODO: Add other page handlers
} 