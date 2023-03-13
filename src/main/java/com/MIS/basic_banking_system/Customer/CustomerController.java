package com.MIS.basic_banking_system.Customer;

import com.MIS.basic_banking_system.Transfer.TransferService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Controller
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;
    private TransferService transferService;

    @GetMapping("/all")
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerService.getAll();
        customers.sort(Customer::compare);
        model.addAttribute("customers", customers);
        return "view_users";
    }

    @GetMapping("/view_customer/id/{customerId}")
    public String create(@PathVariable Integer customerId, Model model) {
        try {
            model.addAttribute("customer", customerService.getCustomerById(customerId));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "view_customer";
    }

    @GetMapping("/id/{id}")
    public String getCustomerById(@PathVariable Integer customerId) {
        try {
            Customer customer = customerService.getCustomerById(customerId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}