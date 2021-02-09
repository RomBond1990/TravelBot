package com.rbondarovich.beans;

import lombok.Data;

import java.util.List;

@Data
public class CityBean {

    private Long id;
    private String name;
    private CountryBean country;
    private List<AttractionBean> attractions;
}
