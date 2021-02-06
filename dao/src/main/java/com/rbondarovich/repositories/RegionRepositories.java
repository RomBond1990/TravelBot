package com.rbondarovich.repositories;

import com.rbondarovich.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepositories  extends JpaRepository<Region, Long> {
}
