package com.rbondarovich.repository;

import com.rbondarovich.entity.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AttractionRepository extends JpaRepository<Attraction, Long> {

    List<Attraction> findByCity_NameLikeIgnoreCase(String city);
}
