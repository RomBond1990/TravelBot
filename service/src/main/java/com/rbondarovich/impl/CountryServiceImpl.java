package com.rbondarovich.impl;

import com.rbondarovich.beans.CountryBean;
import com.rbondarovich.entity.Country;
import com.rbondarovich.interfaces.CountryService;
import com.rbondarovich.repository.CountryRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepositories countryRepo;
    private final EntityBeanConverterImpl converter;

    @Override
    public Iterable<CountryBean> getAllCountries() {
        List<Country> countries = countryRepo.findAll();
        List<CountryBean> countryBeans = converter.convertToBeanList(countries, CountryBean.class);
        return countryBeans;
    }

    @Override
    public CountryBean getCountryById(Long countryId) {
        Country country = countryRepo.getOne(countryId);
        CountryBean countryBean = converter.convertToBean(country, CountryBean.class);

        return countryBean;
    }

    @Override
    public void saveCountry(CountryBean country) {
        Country countryEntity = converter.convertToEntity(country, Country.class);
        countryRepo.save(countryEntity);
    }

    @Override
    public void deleteCountry(Long countryId) {
        countryRepo.deleteById(countryId);
    }
}
