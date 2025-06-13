package com.xworkz.watches.repository;

import com.xworkz.watches.dto.WatchDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO watches VALUES (0, '" + dto.getBrand() + "', '" + dto.getModel() + "', " +
                    dto.getPrice() + ", '" + dto.getManufactureDate() + "', '" + dto.getIsSmart() + "', " + dto.getWarrantyYears() + ")";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}

