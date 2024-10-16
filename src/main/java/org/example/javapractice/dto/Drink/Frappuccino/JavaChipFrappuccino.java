package org.example.javapractice.dto.Drink.Frappuccino;

import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

public class JavaChipFrappuccino implements GetInformation {

    public JavaChipFrappuccino() {}

    public Map<String, Object> getInformationMap() {
        getInformation(JavaChipFrappuccino.class);
        return informationMap;
    }
}
