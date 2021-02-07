package com.rbondarovich.beans;

import lombok.Data;

@Data
public class AddressBean {

    private Long id;
    private String streetType;
    private String street;
    private String buildingNumber;
    private Double longitude;
    private Double latitude;
    private AttractionBean attraction;
}
