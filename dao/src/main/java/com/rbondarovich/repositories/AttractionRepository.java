package com.rbondarovich.repositories;

import com.rbondarovich.entities.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {
}
