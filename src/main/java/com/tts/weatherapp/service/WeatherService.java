package com.tts.weatherapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.tts.weatherapp.model.Response;
import com.tts.weatherapp.model.ZipCodes;
import com.tts.weatherapp.repository.ZipCodeRepository;

@Service
public class WeatherService {

    @Value("${api_key}")
    private String apiKey;

    @Autowired
    private ZipCodeRepository zipCodeRepository;

    public Response getForecast(String zipCode) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&units=imperial&appid="
                + apiKey;
        RestTemplate restTemplate = new RestTemplate();

        ZipCodes zipCodeHistory = new ZipCodes();
        zipCodeHistory.setZipCodes(zipCode);
        zipCodeRepository.save(zipCodeHistory);

        try {

            return restTemplate.getForObject(url, Response.class);

        } catch (HttpClientErrorException ex) {
            Response response = new Response();
            response.setName("error");
            return response;
        }

    }

    public Iterable<ZipCodes> findAllZipCode() {
        return zipCodeRepository.findAll();
    }

}