package com.rbondarovich;

import com.rbondarovich.beans.AttractionBean;
import com.rbondarovich.beans.CountryBean;
import com.rbondarovich.interfaces.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class NonCommand  {

        private final AttractionService attractionService;

        public String nonCommandExecute (Long chatId, String text) {
            StringBuilder answer = new StringBuilder();
            List<AttractionBean> allAttractions = (ArrayList) attractionService.getAllAttractionsByCityName(text);
            for (AttractionBean bean : allAttractions) {
                answer.append(bean.getName()).append("\n").append(bean.getText()).append("\n\n");
            }

            return new String(answer);
        }
}
