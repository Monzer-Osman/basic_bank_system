package com.MIS.basic_banking_system.Transfer;

import com.MIS.basic_banking_system.TransferDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transactions")
@AllArgsConstructor
@Slf4j
public class TransferController {
    private TransferService transferService;

    @PostMapping("/transfer")
    public String transferProcess(TransferDto transferDto) {
        try {
            transferService.transfer(transferDto);
            return "redirect:/customers/all";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
