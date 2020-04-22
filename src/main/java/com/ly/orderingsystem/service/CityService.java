package com.ly.orderingsystem.service;

import com.ly.orderingsystem.entity.City;
import com.ly.orderingsystem.model.Page;

public interface CityService {
    Page getCities(Integer page, Integer size);

    City getCity(Integer cityId);

    String addCity(City city);

    String updateCity(City city);

    String deleteCity(Integer cityId);
}
