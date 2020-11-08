package com.tts.weatherapp.controller;

import com.tts.weatherapp.model.Request;
import com.tts.weatherapp.model.Response;
import com.tts.weatherapp.model.ZipCodes;
import com.tts.weatherapp.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping(value = "/")
    public String getIndex(Model model) {
        Iterable<ZipCodes> zipCodeList = weatherService.findAllZipCode();
        model.addAttribute("zipCodesHistory", zipCodeList);
        model.addAttribute("request", new Request());

        return "index";
    }

    @PostMapping(value = "/")
    public String postIndex(Request request, Model model) {
        Response data = weatherService.getForecast(request.getZipCode());
        model.addAttribute("data", data);
        Iterable<ZipCodes> zipCodeList = weatherService.findAllZipCode();
        model.addAttribute("zipCodePost", zipCodeList);
        return "index";
    }

}
