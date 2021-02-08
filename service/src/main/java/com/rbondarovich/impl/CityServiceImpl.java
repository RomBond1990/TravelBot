package com.rbondarovich.impl;

import com.rbondarovich.beans.CityBean;
import com.rbondarovich.entity.City;
import com.rbondarovich.interfaces.CityService;
import com.rbondarovich.repository.CityRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepositories cityRepo;
    private final EntityBeanConverterImpl converter;

    @Override
    public Iterable<CityBean> getAllCities() {

        List<City> cities = cityRepo.findAll();
        List<CityBean> cityBeans = converter.convertToBeanList(cities, CityBean.class);
        return cityBeans;
    }

    @Override
    public CityBean getCityById(Long cityId) {
        City city = cityRepo.getOne(cityId);
        CityBean cityBean = converter.convertToBean(city, CityBean.class);

        return cityBean;
    }

    @Override
    public void saveCity(CityBean city) {
        City cityEntity = converter.convertToEntity(city, City.class);
        cityRepo.save(cityEntity);
    }

    @Override
    public void deleteCity(Long cityId) {
        cityRepo.deleteById(cityId);
    }
}
