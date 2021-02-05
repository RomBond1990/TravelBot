package com.rbondarovich.interfaces;

import com.rbondarovich.beans.LocationBean;

public interface LocationService {

    Iterable<LocationBean> getAllLocations();

    LocationBean getLocationById(Long locationId);

    void saveLocation (LocationBean location);

    void deleteLocation (Long locationId);

}
