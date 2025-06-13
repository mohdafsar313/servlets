package com.xworkz.weatherapp.repository;


import com.xworkz.weatherapp.dto.WeatherDTO;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WeatherRepoImpl implements WeatherRepo{

    @Override
    public String persist(WeatherDTO weatherDTO) {
        System.out.println("Running persist method in WeatherRepoImpl");
        if(weatherDTO!=null){
            System.out.println("weatherDTO is not null");
            String url = "jdbc:mysql://localhost:3306/weather_forecast";
            String username="root";
            String password="Krishna@2002";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(url,username,password);
                String sql = "insert into weather_info_table (" +
                        "place_name, weather, min_temp, max_temp, cloudy, raining, rain_in_mm, " +
                        "humidity, wind_speed, sun_rise_time, sun_set_time, moon_rise_time, " +
                        "moon_set_time, rain_start_time, rain_end_time, precipitation) " +
                        "values (" +
                        "'" + weatherDTO.getPlaceName() + "', " + "'" + weatherDTO.getWeather() + "', " + weatherDTO.getMinTemp() + ", " + weatherDTO.getMaxTemp() + ", '" + weatherDTO.getCloudy() + "', '" + weatherDTO.getRaining() + "', " + weatherDTO.getRainInMM() + ", " + weatherDTO.getHumidity() + ", " + weatherDTO.getWindSpeed() + ", " + "'" + weatherDTO.getSunRiseTime() + "', " + "'" + weatherDTO.getSunSetTime() + "', " + "'" + weatherDTO.getMoonRiseTime() + "', " + "'" + weatherDTO.getMoonSetTime() + "', " + "'" + weatherDTO.getRainStartTime() + "', " + "'" + weatherDTO.getRainEndTime() + "', " + weatherDTO.getPrecipitation() + ")";

                Statement statement =connection.createStatement();
                statement.executeUpdate(sql);

            } catch (ClassNotFoundException | SQLException e ) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("WeatherDTO is not null");
        }
        return "success";
    }
}
