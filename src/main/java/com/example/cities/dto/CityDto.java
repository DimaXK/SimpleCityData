package com.example.cities.dto;

import java.io.Serializable;
import java.util.Objects;

public class CityDto implements Serializable {
    private final String name;
    private final int population;
    private final String country;
    private final int year;
    private final int square;

    public CityDto(String name, int population, String country, int year, int square) {
        this.name = name;
        this.population = population;
        this.country = country;
        this.year = year;
        this.square = square;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public int getSquare() {
        return square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDto entity = (CityDto) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.population, entity.population) &&
                Objects.equals(this.country, entity.country) &&
                Objects.equals(this.year, entity.year) &&
                Objects.equals(this.square, entity.square);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population, country, year, square);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "population = " + population + ", " +
                "country = " + country + ", " +
                "year = " + year + ", " +
                "square = " + square + ")";
    }
}
