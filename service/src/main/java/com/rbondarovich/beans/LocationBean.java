package com.rbondarovich.beans;

import lombok.Data;

@Data
public class LocationBean {

    private Long id;
    private String country;
    private String region;
    private String city;
}
