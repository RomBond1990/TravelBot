package com.rbondarovich.beans;

import lombok.Data;

import java.util.List;

@Data
public class CountryBean {

    private Long id;
    private String name;
    private List<CityBean> cities;
}
