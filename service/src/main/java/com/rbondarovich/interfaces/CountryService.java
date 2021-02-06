package com.rbondarovich.interfaces;

import com.rbondarovich.beans.CountryBean;

public interface CountryService {

    Iterable<CountryBean> getAllCountries();

    CountryBean getCountryById(Long countryId);

    void saveCountry (CountryBean country);

    void deleteCountry (Long countryId);
}
