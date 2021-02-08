package com.rbondarovich.interfaces;

import com.rbondarovich.beans.AttractionBean;

public interface AttractionService {

    Iterable<AttractionBean> getAllAttractions();

    Iterable<AttractionBean> getAllAttractionsByCityName (String city);

    AttractionBean getAttractionById(Long attractionId);

    void saveAttraction (AttractionBean attraction);

    void deleteAttraction (Long attractionId);

}
