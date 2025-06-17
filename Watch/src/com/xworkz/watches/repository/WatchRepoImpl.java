package com.xworkz.watches.repository;

import com.xworkz.watches.dto.WatchDto;

import java.sql.*;
import java.util.Optional;

public class WatchRepoImpl implements WatchRepo {

    public WatchRepoImpl() {
        System.out.println("Running WatchRepoImpl constructor...");
    }

    @Override
    public boolean persist(WatchDto dto) {
        System.out.println("Persisting WatchDTO in WatchRepoImpl...");

        String username = "root";
        String password = "afs313";
        String url = "jdbc:mysql://localhost:3306/xworkz";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/yourdatabase", "root", "yourPass");

            String sql = "INSERT INTO Watches (brand, model, price, mfgDate, smart, warranty) VALUES (?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dto.getBrand());
            preparedStatement.setString(2, dto.getModel());
            preparedStatement.setDouble(3, dto.getPrice());
            preparedStatement.setString(4, dto.getMfgDate());
            preparedStatement.setString(5, dto.getSmart());
            preparedStatement.setInt(6, dto.getWarranty());

           // int rows = preparedStatement.executeUpdate();
            System.out.println("About to execute the insert.");
            int rows = preparedStatement.executeUpdate();
            System.out.println("Execute finished. Rows affected: " + rows);

            if (rows > 0) {
                System.out.println("Watch successfully saved in the database.");
            } else {
                System.out.println("Watch not saved.");
            }
            preparedStatement.close();
            connection.close();



        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


        return true;
    }
    @Override
    public Optional<WatchDto> findById(int id) {
        System.out.println("running findById in dusterRepositoryImpl...");

        return WatchRepo.super.findById(id);
    }
}

