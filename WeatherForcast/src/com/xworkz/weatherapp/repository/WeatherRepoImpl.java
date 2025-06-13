package com.xworkz.weatherapp.repository;


import com.xworkz.weatherapp.dto.WeatherDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WeatherRepoImpl implements WeatherRepo {

    public WeatherRepoImpl() {
        System.out.println("running in the WeatherRepositoryImple constructor ");

    }


    @Override
    public boolean persist(WeatherDTO dto) {

        System.out.println("persist method in WeatherRepositoryImple" );

        String username = "root";
        String password = "Xworkz@123s";
        String url = "jdbc:mysql://localhost:3306/xworkzz";



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection= DriverManager.getConnection(url,username,password);

            String sql="insert into report values(0,'"+WeatherDTO.getplaceName()+"','"+WeatherDTO.getweather()+"','"+WeatherDTO.getminTemp()+"','"+WeatherDTO.getmaxTemp()+"','"+WeatherDTO.getcloudy()+"','"+WeatherDTO.getraining()+"','"+WeatherDTO.getrain()+"','"+WeatherDTO.gethumidity()+"','"+WeatherDTO.getwindSpeed()+"','"+WeatherDTO.getsunRiseTime()+"','"+WeatherDTO.getsunSetTime()+"','"+WeatherDTO.getmoonRiseTime()+"','"+WeatherDTO.getmoonSetTime()+"','"+WeatherDTO.getrainStartTime()+"','"+WeatherDTO.getrainEndTime()+"','"+WeatherDTO.getprecipitation()+"')";
            Statement statement=connection.createStatement();

            statement.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }



}