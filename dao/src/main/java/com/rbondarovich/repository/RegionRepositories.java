package com.rbondarovich.repository;

import com.rbondarovich.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepositories  extends JpaRepository<Region, Long> {
}
