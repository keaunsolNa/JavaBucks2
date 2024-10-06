package org.example.javapractice.dto.Drink.Espresso;

import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

public class IcedCaffeAmericano implements GetInformation {

    public IcedCaffeAmericano () {

    }

    public Map<String, Object> getInformationMap() {
        getInformation(IcedCaffeAmericano.class);
        return informationMap;
    }
}
