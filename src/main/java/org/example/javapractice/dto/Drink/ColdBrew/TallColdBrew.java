package org.example.javapractice.dto.Drink.ColdBrew;

import org.example.javapractice.Annotation.ColdBrew;
import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;
import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

@Menu(name = "ColdBrew", price = 4900)
@Drink(isCold = true, size = "Tall", ml = 355)
@NutritionInformation(kcal = 5, sodium = 11, saturatedFattyAcid = 0, sugar = 0, protein = 0, caffeine = 155)
@ColdBrew
public class TallColdBrew implements GetInformation {

    public TallColdBrew() {
    }

    public Map<String, Object> getInformationMap() {
        getInformation(TallColdBrew.class);
        return informationMap;
    }
}
