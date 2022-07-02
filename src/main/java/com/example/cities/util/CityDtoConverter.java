package com.example.cities.util;

import com.example.cities.dto.CityDto;
import com.example.cities.model.City;

public class CityDtoConverter {
    public static City getCity(CityDto cityDto) {
        return new City(cityDto.getName(), cityDto.getPopulation(), cityDto.getCountry(), cityDto.getYear(), cityDto.getSquare());
    }

    public static CityDto getDto(City city) {
        return new CityDto(city.getName(), city.getPopulation(), city.getCountry(), city.getYear(), city.getSquare());
    }
}
