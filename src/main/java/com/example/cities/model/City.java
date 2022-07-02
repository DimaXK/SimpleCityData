package com.example.cities.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer population;
    private String country;
    private Integer year;
    private Integer square;
    private Double tempNow;


    public City setTempNow(Double tempNow) {
        this.tempNow = tempNow;
        return this;
    }

    public City(String name, int population, String country, int year, int square) {
        this.name = name;
        this.population = population;
        this.country = country;
        this.year = year;
        this.square = square;
    }

    public City() {

    }


    public String getName() {
        return name;
    }


    public Integer getPopulation() {
        return population;
    }


    public String getCountry() {
        return country;
    }


    public Integer getYear() {
        return year;
    }

    public Integer getSquare() {
        return square;
    }


}
