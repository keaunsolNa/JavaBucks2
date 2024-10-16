package org.example.javapractice.dto.Drink.ColdBrew;

import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

public class NitroColdBrew implements GetInformation {

    public NitroColdBrew() {}

    public Map<String, Object> getInformationMap() {
        getInformation(NitroColdBrew.class);
        return informationMap;
    }
}
