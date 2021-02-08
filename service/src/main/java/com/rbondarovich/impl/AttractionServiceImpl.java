package com.rbondarovich.impl;

import com.rbondarovich.beans.AttractionBean;
import com.rbondarovich.entity.Attraction;
import com.rbondarovich.interfaces.AttractionService;
import com.rbondarovich.repository.AttractionRepository;
import com.rbondarovich.repository.CityRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AttractionServiceImpl implements AttractionService {
    
    private final AttractionRepository attractionRepo;
    private final EntityBeanConverterImpl converter;
    
    @Override
    public Iterable<AttractionBean> getAllAttractions() {
        List<Attraction> attractions = attractionRepo.findAll();
        List<AttractionBean> attractionBeans = converter.convertToBeanList(attractions, AttractionBean.class);
        return attractionBeans;
    }

    public Iterable<AttractionBean> getAllAttractionsByCityName (String city) {
        List<Attraction> attractions = attractionRepo.findByCity_NameLikeIgnoreCase(city);
        List<AttractionBean> attractionBeans = converter.convertToBeanList(attractions, AttractionBean.class);

        return attractionBeans;
    }

    @Override
    public AttractionBean getAttractionById(Long attractionId) {
        Attraction attraction = attractionRepo.getOne(attractionId);
        AttractionBean attractionBean = converter.convertToBean(attraction, AttractionBean.class);

        return attractionBean;
    }

    @Override
    public void saveAttraction(AttractionBean attraction) {
        Attraction attractionEntity = converter.convertToEntity(attraction, Attraction.class);
        attractionRepo.save(attractionEntity);

    }

    @Override
    public void deleteAttraction(Long attractionId) {
        attractionRepo.deleteById(attractionId);

    }
}
