package com.bank.app.service;

import com.bank.app.dto.UserDTO;
import com.bank.app.dto.PassbookEntryDTO;
import com.bank.app.repository.UserRepository;
import com.bank.app.repository.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository repo = new UserRepositoryImpl();

    @Override
    public boolean registerUser(UserDTO user) {
        if (!isValidRegistration(user)) return false;
        return repo.save(user);

    }

    @Override
    public UserDTO login(String email, String password) {
        return repo.findByEmailAndPassword(email, password);
    }

    @Override
    public boolean deposit(UserDTO user, double amount) {
        double newBalance = user.getBalance() + amount;
        boolean updated = repo.updateBalance(user.getId(), newBalance);
        if (updated) {
            repo.saveTransaction(user.getId(), "Deposit", amount, newBalance);
            user.setBalance(newBalance);
        }
        if (!isValidAmount(amount)) return false;

        return updated;
    }

    @Override
    public boolean withdraw(UserDTO user, double amount) {
        if (amount > user.getBalance()) return false;
        double newBalance = user.getBalance() - amount;
        boolean updated = repo.updateBalance(user.getId(), newBalance);
        if (updated) {
            repo.saveTransaction(user.getId(), "Withdraw", amount, newBalance);
            user.setBalance(newBalance);
        }
        if (!isValidAmount(amount)) return false;
        return updated;
    }

    @Override
    public List<PassbookEntryDTO> getTransactions(UserDTO user) {
        return repo.getTransactions(user.getId());
    }
    @Override
    public boolean isValidRegistration(UserDTO user) {
        return user.getName() != null && !user.getName().trim().isEmpty()
                && user.getEmail() != null && user.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")
                && user.getPassword() != null && user.getPassword().length() >= 6;
    }

    @Override
    public boolean isValidAmount(double amount) {
        return amount > 0;
    }

    @Override
    public boolean isValidLogin(String email, String password) {
        return email != null && password != null
                && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")
                && password.length() >= 6;
    }

}
