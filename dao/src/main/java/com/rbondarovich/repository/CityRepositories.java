package com.rbondarovich.repository;

import com.rbondarovich.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepositories extends JpaRepository <City, Long> {}
