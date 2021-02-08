package com.rbondarovich.repository;

import com.rbondarovich.entity.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {

    Attraction findByCity();
}
