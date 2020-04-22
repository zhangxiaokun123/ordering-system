package com.ly.orderingsystem.mapper;

import com.ly.orderingsystem.entity.City;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMapper {
    List<City> seletAll(Integer page, Integer size);

    Long getTotal();

    City selectById(Integer cityId);

    List<City> getCityByName(String cityName);

    Integer insert(City city);

    Integer update(City city);

    Integer deleteById(Integer cityId);

    Integer getIdByName(String cityName);
}
