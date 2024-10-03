package org.example.javapractice.dto.ColdBrew;

import org.example.javapractice.Annotation.*;
import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

@Menu(name = "ColdBrew", price = 5400)
@Drink(isCold = true, size = "Grande", ml = 473)
@NutritionInformation(kcal = 5, sodium = 15, saturatedFattyAcid = 0, sugar = 0, protein = 0, caffeine = 205)
@ColdBrew
public class GrandeColdBrew implements GetInformation {

    public GrandeColdBrew() {
    }

    public Map<String, Object> getInformationMap() {
        getInformation(GrandeColdBrew.class);
        return informationMap;
    }
}
