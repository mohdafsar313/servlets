package com.xworkz.weatherapp.repository;

import com.xworkz.weatherapp.dto.WeatherDTO;

public interface WeatherRepo {
    String persist(WeatherDTO weatherDTO);
}
