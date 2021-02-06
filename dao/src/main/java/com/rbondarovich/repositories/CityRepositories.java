package com.rbondarovich.repositories;

import com.rbondarovich.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepositories extends JpaRepository <City, Long> {
}
