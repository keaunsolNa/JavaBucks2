package org.example.javapractice.dto.Drink.Espresso;

import org.example.javapractice.Annotation.Espresso;
import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

@Espresso
public class FlatWhite implements GetInformation {

    public FlatWhite () {

    }

    public Map<String, Object> getInformationMap() {
        getInformation(FlatWhite.class);
        return informationMap;
    }
}
