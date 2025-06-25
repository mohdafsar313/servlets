package com.bank.app.repository;

import com.bank.app.dto.UserDTO;
import com.bank.app.dto.PassbookEntryDTO;

import java.util.List;

public interface UserRepository {
    boolean save(UserDTO user);
    UserDTO findByEmailAndPassword(String email, String password);
    boolean updateBalance(int userId, double newBalance);
    boolean saveTransaction(int userId, String type, double amount, double newBalance);
    boolean deposit(UserDTO user, double amount);        // Deposit funds
    boolean withdraw(UserDTO user, double amount);
    List<PassbookEntryDTO> getTransactions(int userId);


}
