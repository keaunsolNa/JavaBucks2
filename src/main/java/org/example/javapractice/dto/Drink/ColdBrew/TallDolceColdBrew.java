package org.example.javapractice.dto.Drink.ColdBrew;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;

import java.util.Map;

@Menu(name = "ColdBrew", price = 4900)
@Drink(isCold = true, size = "Tall", ml = 355)
@NutritionInformation(kcal = 5, sodium = 11, saturatedFattyAcid = 0, sugar = 0, protein = 0, caffeine = 155)
public class TallDolceColdBrew extends DolceColdBrew {

    public TallDolceColdBrew() {
        super();
    }

    @Override
    public Map<String, Object> getInformationMap() {
        getInformation(TallDolceColdBrew.class);
        return informationMap;
    }
}
