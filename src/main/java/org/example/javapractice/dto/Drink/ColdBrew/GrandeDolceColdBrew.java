package org.example.javapractice.dto.Drink.ColdBrew;

import org.example.javapractice.Annotation.*;

import java.util.Map;

@Menu(name = "ColdBrew", price = 5400)
@Drink(isCold = true, size = "Grande", ml = 473)
@NutritionInformation(kcal = 5, sodium = 15, saturatedFattyAcid = 0, sugar = 0, protein = 0, caffeine = 205)
public class GrandeDolceColdBrew extends DolceColdBrew {

    public GrandeDolceColdBrew() {
        super();
    }

    @Override
    public Map<String, Object> getInformationMap() {
        getInformation(GrandeDolceColdBrew.class);
        return informationMap;
    }
}
