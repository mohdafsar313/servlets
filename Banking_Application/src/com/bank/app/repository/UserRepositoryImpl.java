package com.bank.app.repository;

import com.bank.app.dto.UserDTO;
import com.bank.app.dto.PassbookEntryDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASSWORD = "afs313";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean save(UserDTO user) {
        String sql = "INSERT INTO users (name, email, password, balance) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            pst.setDouble(4, user.getBalance());

            int rows = pst.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            // 🔥 Add this to see what's really wrong
            System.err.println("Registration Error: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public UserDTO findByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new UserDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getDouble("balance")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateBalance(int userId, double newBalance) {
        String sql = "UPDATE users SET balance = ? WHERE id = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDouble(1, newBalance);
            pst.setInt(2, userId);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean saveTransaction(int userId, String type, double amount, double newBalance) {
        String sql = "INSERT INTO passbook (user_id, type, amount, balance_after, date) VALUES (?, ?, ?, ?, NOW())";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, userId);
            pst.setString(2, type);
            pst.setDouble(3, amount);
            pst.setDouble(4, newBalance);
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean deposit(UserDTO user, double amount) {
        String updateSql = "UPDATE users SET balance = balance + ? WHERE id = ?";
        String passbookSql = "INSERT INTO passbook (user_id, type, amount, balance_after) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement updateStmt = con.prepareStatement(updateSql);
             PreparedStatement logStmt = con.prepareStatement(passbookSql)) {

            updateStmt.setDouble(1, amount);
            updateStmt.setInt(2, user.getId());

            int rows = updateStmt.executeUpdate();
            if (rows > 0) {
                double newBalance = user.getBalance() + amount;
                user.setBalance(newBalance);

                logStmt.setInt(1, user.getId());
                logStmt.setString(2, "Deposit");
                logStmt.setDouble(3, amount);
                logStmt.setDouble(4, newBalance);
                logStmt.executeUpdate();

                return true;
            }

        } catch (SQLException e) {
            System.err.println("Deposit Error: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean withdraw(UserDTO user, double amount) {
        String updateSql = "UPDATE users SET balance = balance - ? WHERE id = ?";
        String passbookSql = "INSERT INTO passbook (user_id, type, amount, balance_after) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement updateStmt = con.prepareStatement(updateSql);
             PreparedStatement logStmt = con.prepareStatement(passbookSql)) {

            updateStmt.setDouble(1, amount);
            updateStmt.setInt(2, user.getId());

            int rows = updateStmt.executeUpdate();
            if (rows > 0) {
                double newBalance = user.getBalance() - amount;
                user.setBalance(newBalance);

                logStmt.setInt(1, user.getId());
                logStmt.setString(2, "Withdraw");
                logStmt.setDouble(3, amount);
                logStmt.setDouble(4, newBalance);
                logStmt.executeUpdate();

                return true;
            }

        } catch (SQLException e) {
            System.err.println("Withdraw Error: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<PassbookEntryDTO> getTransactions(int userId) {
        List<PassbookEntryDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM passbook WHERE user_id = ? ORDER BY date DESC";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new PassbookEntryDTO(
                        rs.getString("date"),
                        rs.getString("type"),
                        rs.getDouble("amount"),
                        rs.getDouble("balance_after")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
