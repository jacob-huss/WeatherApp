package com.tts.weatherapp.service;

import com.tts.weatherapp.models.Response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${api_key}")
    private String apiKey;

    public Response getForecast(String zipCode){
        // makes a call to open weather api with dynamic zipcode and apikey
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&appid"+ apiKey;
        RestTemplate restTemplate = new RestTemplate();
        // makes a call to url
        // puts response in response object
        return restTemplate.getForObject(url, Response.class);

    }
}
