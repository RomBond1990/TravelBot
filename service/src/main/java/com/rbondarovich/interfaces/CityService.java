package com.rbondarovich.interfaces;

import com.rbondarovich.beans.CityBean;

public interface CityService {

    Iterable<CityBean> getAllCities();

    CityBean getCityById(Long cityId);

    void saveCity (CityBean city);

    void deleteCity (Long cityId);
}
