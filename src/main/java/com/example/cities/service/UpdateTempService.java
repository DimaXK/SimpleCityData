package com.example.cities.service;

import com.example.cities.exceptions.NotFoundCityException;
import com.example.cities.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UpdateTempService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    TempApiService tempApi;

    @Scheduled(fixedDelay = 60000, initialDelay = 0)
    private void updateAllTemp() {
        cityRepository.findAll().forEach(city -> {
            try {
                city.setTempNow(tempApi.getTemp(city.getName()));
                cityRepository.save(city);
            } catch (NotFoundCityException e) {
                city.setTempNow(null);
                cityRepository.save(city);
                System.out.println("Ошибка обновления погоды");
            }
        });
    }

}
