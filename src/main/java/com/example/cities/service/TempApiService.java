package com.example.cities.service;

import com.example.cities.exceptions.NotFoundCityException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class TempApiService {
    @Value("${api.temp.key}")
    private String key;

    private JSONObject getWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + key + "&units=metric";
        return new JSONObject(restTemplate.getForObject(url, String.class));
    }

    public Double getTemp(String city) throws NotFoundCityException {
        try {
            return Double.valueOf(getWeather(city).getJSONObject("main").get("temp").toString());
        } catch (HttpClientErrorException e) {
            throw new NotFoundCityException("Город введен неправильно");
        }
    }
}
