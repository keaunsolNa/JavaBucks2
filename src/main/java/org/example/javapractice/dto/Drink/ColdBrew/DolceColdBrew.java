package org.example.javapractice.dto.Drink.ColdBrew;

import org.example.javapractice.Annotation.ColdBrew;
import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

@ColdBrew
public class DolceColdBrew implements GetInformation {

    public DolceColdBrew () {

    }

    public Map<String, Object> getInformationMap() {
        getInformation(DolceColdBrew.class);
        return informationMap;
    }
}
