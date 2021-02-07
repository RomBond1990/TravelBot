package com.rbondarovich.beans;

import lombok.Data;

import java.util.List;

@Data
public class CountryBean {

    private Long id;
    private String countryName;
    private List<RegionBean> regions;
}
