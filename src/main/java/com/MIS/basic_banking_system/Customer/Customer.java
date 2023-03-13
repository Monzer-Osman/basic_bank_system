package com.MIS.basic_banking_system.Customer;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Data
public class Customer {

    @SequenceGenerator(
            name = "Customer_id_generator",
            sequenceName = "Customer_id_generator",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Customer_id_generator"
    )
    @Id
    private Integer customerId;
    private String email;
    private String firstName;
    private String lastName;
    private Long balance;

    public void subtractBy(Long amount) {
        balance -= amount;
    }

    public void increaseBy(Long amount) {
        balance += amount;
    }

    public Integer compare(Customer customer) {
        if (this.customerId.equals(customer.getCustomerId())) return 0;
        if (this.customerId > customer.getCustomerId()) return 1;
        return -1;
    }
}