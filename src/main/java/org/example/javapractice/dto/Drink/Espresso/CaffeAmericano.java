package org.example.javapractice.dto.Drink.Espresso;

import org.example.javapractice.Annotation.Espresso;
import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

@Espresso
public class CaffeAmericano implements GetInformation  {

    public CaffeAmericano() {

    }

    public Map<String, Object> getInformationMap() {
        getInformation(CaffeAmericano.class);
        return informationMap;
    }
}
