package com.xworkz.weatherapp.service;


import com.xworkz.weatherapp.dto.WeatherDTO;
import com.xworkz.weatherapp.repository.WeatherRepo;
import com.xworkz.weatherapp.repository.WeatherRepoImpl;

public class WeatherServiceImpl implements WeatherService{
    @Override
    public boolean save(WeatherDTO weatherDTO) {

        if (weatherDTO == null) {
            System.out.println("Weather details cannot be null");
            return false;
        }

        String placeName = weatherDTO.getPlaceName();
        if (placeName != null && placeName.length() >= 3 && placeName.length() <= 30) {
            System.out.println("Place name is valid");
        } else {
            System.out.println("Place name must be between 3 and 30 characters");
            return false;
        }

        String weather = weatherDTO.getWeather();
        if (weather != null && !weather.isEmpty()) {
            System.out.println("Weather description is valid");
        } else {
            System.out.println("Weather description cannot be empty");
            return false;
        }

        Float minTemp = weatherDTO.getMinTemp();
        if (minTemp != null && minTemp >= -60 && minTemp <= 60) {
            System.out.println("Min temperature is valid");
        } else {
            System.out.println("Min temperature should be between -60 and 60 Celsius");
            return false;
        }

        Float maxTemp = weatherDTO.getMaxTemp();
        if (maxTemp != null && maxTemp >= -60 && maxTemp <= 70) {
            System.out.println("Max temperature is valid");
        } else {
            System.out.println("Max temperature should be between -60 and 70 Celsius");
            return false;
        }

        String cloudy = weatherDTO.getCloudy();
        if (cloudy != null) {
            System.out.println("Cloudy value is valid");
        } else {
            System.out.println("Cloudy value cannot be null");
            return false;
        }

        String raining = weatherDTO.getRaining();
        if (raining != null) {
            System.out.println("Raining value is valid");
        } else {
            System.out.println("Raining value cannot be null");
            return false;
        }

        Float rainMM = weatherDTO.getRainInMM();
        if (rainMM != null && rainMM >= 0) {
            System.out.println("Rain in MM is valid");
        } else {
            System.out.println("Rain in MM must be non-negative");
            return false;
        }

        Float humidity = weatherDTO.getHumidity();
        if (humidity != null && humidity >= 0 && humidity <= 100) {
            System.out.println("Humidity is valid");
        } else {
            System.out.println("Humidity must be between 0% and 100%");
            return false;
        }

        Float windSpeed = weatherDTO.getWindSpeed();
        if (windSpeed != null && windSpeed >= 0 && windSpeed <= 500) {
            System.out.println("Wind speed is valid");
        } else {
            System.out.println("Wind speed must be between 0 and 500 km/h");
            return false;
        }

        String sunRise = weatherDTO.getSunRiseTime();
        if (sunRise != null && !sunRise.isEmpty()) {
            System.out.println("Sunrise time is valid");
        } else {
            System.out.println("Sunrise time is required");
            return false;
        }

        String sunSet = weatherDTO.getSunSetTime();
        if (sunSet != null && !sunSet.isEmpty()) {
            System.out.println("Sunset time is valid");
        } else {
            System.out.println("Sunset time is required");
            return false;
        }

        String moonRise = weatherDTO.getMoonRiseTime();
        if (moonRise != null && !moonRise.isEmpty()) {
            System.out.println("Moonrise time is valid");
        } else {
            System.out.println("Moonrise time is required");
            return false;
        }

        String moonSet = weatherDTO.getMoonSetTime();
        if (moonSet != null && !moonSet.isEmpty()) {
            System.out.println("MoonSet time is valid");
        } else {
            System.out.println("MoonSet time is required");
            return false;
        }

        String rainStart = weatherDTO.getRainStartTime();
        if (rainStart != null && !rainStart.isEmpty()) {
            System.out.println("Rain start time is valid");
        } else {
            System.out.println("Rain start time is required");
            return false;
        }

        String rainEnd = weatherDTO.getRainEndTime();
        if (rainEnd != null && !rainEnd.isEmpty()) {
            System.out.println("Rain end time is valid");
        } else {
            System.out.println("Rain end time is required");
            return false;
        }

        Float precipitation = weatherDTO.getPrecipitation();
        if (precipitation != null && precipitation >= 0) {
            System.out.println("Precipitation is valid");
        } else {
            System.out.println("Precipitation must be non-negative");
            return false;
        }
        System.out.println("All validations passed");

        WeatherRepo weatherRepo = new WeatherRepoImpl();
        String result = weatherRepo.persist(weatherDTO);
        System.out.println("Persist result: " + result);
        return result.equalsIgnoreCase("success");

    }
}