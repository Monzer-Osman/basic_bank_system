package com.MIS.basic_banking_system;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransferDto {
    public String senderEmail;
    public String receiverEmail;
    public Long amount;
}
