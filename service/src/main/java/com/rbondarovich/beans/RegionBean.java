package com.rbondarovich.beans;


import lombok.Data;

import java.util.List;

@Data
public class RegionBean {

    private Long id;
    private String regionName;
    private CountryBean country;
    private List<CityBean> cities;
}
