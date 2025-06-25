package com.bank.app.service;

import com.bank.app.dto.UserDTO;
import com.bank.app.dto.PassbookEntryDTO;

import java.util.List;

public interface UserService {
    boolean registerUser(UserDTO user);
    UserDTO login(String email, String password);
    boolean deposit(UserDTO user, double amount);
    boolean withdraw(UserDTO user, double amount);
    List<PassbookEntryDTO> getTransactions(UserDTO user);
    boolean isValidRegistration(UserDTO user);
    boolean isValidAmount(double amount);
    boolean isValidLogin(String email, String password);

}
