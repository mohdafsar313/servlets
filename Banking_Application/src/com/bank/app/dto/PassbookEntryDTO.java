package com.bank.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassbookEntryDTO {
    private String date;
    private String type; // Deposit or Withdraw
    private double amount;
    private double balanceAfter;
}
