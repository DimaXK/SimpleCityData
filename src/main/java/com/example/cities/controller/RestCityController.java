package com.example.cities.controller;

import com.example.cities.dto.CityDto;
import com.example.cities.util.CityDtoConverter;
import com.example.cities.exceptions.NotFoundCityException;
import com.example.cities.model.City;
import com.example.cities.repository.CityRepository;
import com.example.cities.service.TempApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class RestCityController {
    @Autowired
    CityRepository cityRepository;
    @Autowired
    TempApiService tempApi;

    @GetMapping("/cities")
    List<City> getCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/cities/{name}")
    Optional<City> getCity(@PathVariable String name) {
        return cityRepository.findAll().stream()
                .filter(dbCity -> name.replace('_', ' ')
                        .equalsIgnoreCase(dbCity.getName().replace('_', ' ')))
                .findFirst();
    }

    @PostMapping("/cities")
    City postCity(@RequestBody CityDto cityDto) throws NotFoundCityException {
        return cityRepository.save((CityDtoConverter.getCity(cityDto)
                .setTempNow(tempApi.getTemp(cityDto.getName()))));
    }


    @DeleteMapping("/cities/{id}")
    String deleteCity(@PathVariable int id) {
        cityRepository.deleteById(id);
        return "delete";
    }
}
