package com.MIS.basic_banking_system.Transfer;

import com.MIS.basic_banking_system.Customer.Customer;
import com.MIS.basic_banking_system.Customer.CustomerRepository;
import com.MIS.basic_banking_system.Exceptions.InsufficientBalanceException;
import com.MIS.basic_banking_system.TransferDto;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransferService {
    private CustomerRepository customerRepository;
    public void transfer(TransferDto transferDto) throws Exception{
        Optional<Customer> senderOptional = customerRepository.findByEmail(transferDto.senderEmail);
        Optional<Customer> receiverOptional = customerRepository.findByEmail(transferDto.receiverEmail);

        if(senderOptional.isPresent() && receiverOptional.isPresent()){
            if(senderOptional.get().getBalance() >= transferDto.amount) {
                senderOptional.get().subtractBy(transferDto.amount);
                receiverOptional.get().increaseBy(transferDto.amount);
                customerRepository.save(senderOptional.get());
                customerRepository.save(receiverOptional.get());
            } else {
                throw new InsufficientBalanceException("Insufficient Balance ...!");
            }
        }
    }
}
