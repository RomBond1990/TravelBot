package com.rbondarovich.interfaces;

import com.rbondarovich.beans.RegionBean;

public interface RegionService {

    Iterable<RegionBean> getAllRegions();

    RegionBean getRegionById(Long regionId);

    void saveRegion (RegionBean region);

    void deleteRegion (Long regionId);
}
