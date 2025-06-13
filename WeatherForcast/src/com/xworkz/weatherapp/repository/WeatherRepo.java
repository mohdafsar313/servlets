package com.xworkz.weatherapp.repository;

import com.xworkz.weatherapp.dto.WeatherDTO;

public interface WeatherRepo {
    boolean persist(WeatherDTO dto);
}
