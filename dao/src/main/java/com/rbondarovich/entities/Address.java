package com.rbondarovich.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String streetType;
    private String street;
    private String buildingNumber;
    private Double longitude;
    private Double latitude;
}
