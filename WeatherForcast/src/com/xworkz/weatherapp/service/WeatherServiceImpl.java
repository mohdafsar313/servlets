package com.xworkz.weatherapp.service;


import com.xworkz.weatherapp.dto.WeatherDTO;
import com.xworkz.weatherapp.repository.WeatherRepo;
import com.xworkz.weatherapp.repository.WeatherRepoImpl;

public class WeatherServiceImpl implements WeatherService{
    public WeatherServiceImpl()
    {
        System.out.println("Running in the WeatherServiceImple constructor ");
    }

    @Override
    public boolean save(WeatherDTO dto)
    {
        System.out.println("save method in WeatherServiceImple class");


        WeatherRepo weatherRepository=new WeatherRepoImpl();
        return weatherRepository.persist(dto);
    }
}