package com.rbondarovich.beans;

import lombok.Data;

import java.util.List;

@Data
public class CityBean {

    private Long id;
    private String cityName;
    private RegionBean region;
    private List<AttractionBean> attractions;
}
