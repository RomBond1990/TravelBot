package com.rbondarovich.controller;

import com.rbondarovich.beans.CityBean;
import com.rbondarovich.interfaces.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/cities",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public ResponseEntity<Iterable<CityBean>> getAllCities() {
        Iterable<CityBean> allCities = cityService.getAllCities();
        ResponseEntity<Iterable<CityBean>> response = new ResponseEntity<>(allCities, HttpStatus.OK);

        return response;
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<CityBean> getCityById(@PathVariable("cityId") Long cityId) {
        CityBean cityBean = cityService.getCityById(cityId);
        ResponseEntity<CityBean> response = new ResponseEntity<>(cityBean, HttpStatus.OK);

        return response;
    }

    @PostMapping
    public ResponseEntity<CityBean> saveCity(@RequestBody CityBean cityBean) {
        cityService.saveCity(cityBean);
        ResponseEntity<CityBean> response = new ResponseEntity<>(cityBean, HttpStatus.OK);

        return response;
    }

    @PutMapping("/{cityId}")
    public ResponseEntity<Void> updateCity(@PathVariable("cityId") @RequestBody CityBean cityBean) {
        cityService.saveCity(cityBean);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<Void> deleteCity(@PathVariable("cityId") Long cityId) {
        cityService.deleteCity(cityId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
