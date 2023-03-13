package com.MIS.basic_banking_system.Customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class CustomerUtils {
    private CustomerService customerService;

    @GetMapping("/createCustomers")
    public String createDummyCustomers() {
        try {
            createCustomer("Ahmed", "Mohammad", "ahmed_mohammad@yahoo.com", 2000);
            createCustomer("Osama", "Alrawhany", "osos_292@yahoo.com", 7000);
            createCustomer("Tommy", "Egan", "tommy_egan@mis-comp.com", 4000);
            createCustomer("James", "Patrick", "james_Patrick@gmail.com", 4000);
            createCustomer("Khalid", "Mater", "khalid82@gmail.com", 3700);
            createCustomer("Sam", "Geliany", "sam_geliany99@mis-comp.com", 8200);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "view_customers";
    }

    public void createCustomer(String firstName, String lastName, String email, Integer balance) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setBalance((long) balance);
        customerService.addCustomer(customer);
    }
}
