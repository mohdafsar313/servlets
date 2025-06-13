package com.xworkz.weatherapp.servlet;



import com.xworkz.weatherapp.dto.WeatherDTO;
import com.xworkz.weatherapp.service.WeatherService;
import com.xworkz.weatherapp.service.WeatherServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns="/weather", loadOnStartup = 1)
public class WeatherServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Running doPost method in WeatherServlet");

        String placeName = req.getParameter("placeName");
        String weather = req.getParameter("weather");
        String minTemp = req.getParameter("minTemp");
        String maxTemp = req.getParameter("maxTemp");
        String cloudy = req.getParameter("cloudy");
        String raining = req.getParameter("raining");
        String rainMM = req.getParameter("rainMM");
        String humidity = req.getParameter("humidity");
        String windSpeed = req.getParameter("windSpeed");
        String sunriseTime = req.getParameter("sunriseTime");
        String sunsetTime = req.getParameter("sunsetTime");
        String moonRiseTime = req.getParameter("moonRiseTime");
        String moonSetTime = req.getParameter("moonSetTime");
        String rainStartTime = req.getParameter("rainStartTime");
        String rainEndTime = req.getParameter("rainEndTime");
        String precipitation = req.getParameter("precipitation");

        WeatherDTO weatherDTO = new WeatherDTO();
        weatherDTO.setPlaceName(placeName);
        weatherDTO.setWeather(weather);
        weatherDTO.setMinTemp(Float.parseFloat(minTemp));
        weatherDTO.setMaxTemp(Float.parseFloat(maxTemp));
        weatherDTO.setCloudy(cloudy);
        weatherDTO.setRaining(raining);
        weatherDTO.setRainInMM(Float.valueOf(rainMM));
        weatherDTO.setHumidity(Float.valueOf(humidity));
        weatherDTO.setWindSpeed(Float.valueOf(windSpeed));
        weatherDTO.setSunRiseTime(sunriseTime);
        weatherDTO.setSunSetTime(sunsetTime);
        weatherDTO.setMoonRiseTime(moonRiseTime);
        weatherDTO.setMoonSetTime(moonSetTime);
        weatherDTO.setRainStartTime(rainStartTime);
        weatherDTO.setRainEndTime(rainEndTime);
        weatherDTO.setPrecipitation(Float.valueOf(precipitation));


        WeatherService weatherService = new WeatherServiceImpl();
        boolean saved = weatherService.save(weatherDTO);

        if(saved){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WeatherSuccess.jsp");

            req.setAttribute("message", "Details saved successfully");
            req.setAttribute("info", weatherDTO);
            requestDispatcher.forward(req, resp);
        }else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WeatherForm.jsp");

            req.setAttribute("message", "Save failed");
            requestDispatcher.forward(req, resp);
        }
    }
}
