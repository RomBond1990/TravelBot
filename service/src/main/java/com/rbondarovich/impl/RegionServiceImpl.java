package com.rbondarovich.impl;

import com.rbondarovich.beans.RegionBean;
import com.rbondarovich.entity.Region;
import com.rbondarovich.interfaces.RegionService;
import com.rbondarovich.repository.RegionRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepositories regionRepo;
    private final EntityBeanConverterImpl converter;

    @Override
    public Iterable<RegionBean> getAllRegions() {
        List<Region> regions = regionRepo.findAll();
        List<RegionBean> regionBeans = converter.convertToBeanList(regions, RegionBean.class);
        return regionBeans;
    }

    @Override
    public RegionBean getRegionById(Long regionId) {
        Region region = regionRepo.getOne(regionId);
        RegionBean regionBean = converter.convertToBean(region, RegionBean.class);

        return regionBean;
    }

    @Override
    public void saveRegion(RegionBean region) {
        Region regionEntity = converter.convertToEntity(region, Region.class);
        regionRepo.save(regionEntity);
    }

    @Override
    public void deleteRegion(Long regionId) {
        regionRepo.deleteById(regionId);
    }
}
