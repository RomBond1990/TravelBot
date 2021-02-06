package com.rbondarovich.repositories;

import com.rbondarovich.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepositories extends JpaRepository<Country, Long> {
}
