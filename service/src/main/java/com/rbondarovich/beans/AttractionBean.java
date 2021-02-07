package com.rbondarovich.beans;

import lombok.Data;

import java.util.List;

@Data
public class AttractionBean {

    private Long id;
    private String name;
    private String text;
    private CityBean city;
    private List<AddressBean> addresses;
}
