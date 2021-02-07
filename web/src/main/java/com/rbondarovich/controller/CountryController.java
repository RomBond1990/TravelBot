package com.rbondarovich.controller;

import com.rbondarovich.beans.CountryBean;
import com.rbondarovich.interfaces.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/countries",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<Iterable<CountryBean>> getAllCountries() {
        Iterable<CountryBean> allCountries = countryService.getAllCountries();
        ResponseEntity<Iterable<CountryBean>> response = new ResponseEntity<>(allCountries, HttpStatus.OK);

        return response;
    }

    @GetMapping("/{countryId}")
    public ResponseEntity<CountryBean> getCountryById(@PathVariable("countryId") Long countryId) {
        CountryBean countryBean = countryService.getCountryById(countryId);
        ResponseEntity<CountryBean> response = new ResponseEntity<>(countryBean, HttpStatus.OK);

        return response;
    }

    @PostMapping
    public ResponseEntity<CountryBean> saveCountry(@RequestBody CountryBean countryBean) {
        countryService.saveCountry(countryBean);
        ResponseEntity<CountryBean> response = new ResponseEntity<>(countryBean, HttpStatus.OK);

        return response;
    }

    @PutMapping("/{countryId}")
    public ResponseEntity<Void> updateCountry(@PathVariable("countryId") @RequestBody CountryBean countryBean) {
        countryService.saveCountry(countryBean);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{countryId}")
    public ResponseEntity<Void> deleteCountry(@PathVariable("countryId") Long countryId) {
        countryService.deleteCountry(countryId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
