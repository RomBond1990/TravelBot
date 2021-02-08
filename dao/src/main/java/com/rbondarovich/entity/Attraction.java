package com.rbondarovich.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@Table
@Data
@NoArgsConstructor
public class Attraction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_city_id")
    private City city;
}
