package com.rbondarovich;

import com.rbondarovich.beans.AttractionBean;
import com.rbondarovich.beans.CityBean;
import com.rbondarovich.interfaces.AttractionService;
import com.rbondarovich.interfaces.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class NonCommand {

    private final AttractionService attractionService;
    private final CityService cityService;

    public String nonCommandExecute(Long chatId, String text) {
        StringBuilder answer = new StringBuilder();
        List<AttractionBean> allAttractions = (ArrayList<AttractionBean>) attractionService.getAllAttractionsByCityName(text);
        if (!allAttractions.isEmpty()) {
            for (AttractionBean bean : allAttractions) {
                String city = bean.getCity().getName();
                String country = bean.getCity().getCountry().getName();
                answer.append(city).append("(").append(country).append(")\n");
                answer.append(bean.getName()).append("\n").append(bean.getText()).append("\n\n");
            }
        } else {
            answer.append("Извините, информации о достопримечательностях такого города у нас нет. Обратите внимание на другие города:");
            List<CityBean> allCities = (ArrayList<CityBean>) cityService.getAllCities();
            for (CityBean bean : allCities) {
                answer.append("\n").append(bean.getName());
            }
        }

        return new String(answer);
    }
}
