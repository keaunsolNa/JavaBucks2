package org.example.javapractice.dto.Drink.ColdBrew;

import org.example.javapractice.Annotation.ColdBrew;
import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

@ColdBrew
public class NitroColdBrew implements GetInformation {

    public NitroColdBrew() {}

    public Map<String, Object> getInformationMap() {
        getInformation(NitroColdBrew.class);
        return informationMap;
    }
}
