package com.rbondarovich.repository;

import com.rbondarovich.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepositories extends JpaRepository<Country, Long> {
}
