package org.example.javapractice.dto.Espresso;

import org.example.javapractice.Annotation.*;
import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

@Menu(name = "IcedCaffeAmericano", price = 4500)
@Drink(isCold = true, size = "Tall", ml = 355)
@NutritionInformation(kcal = 10, sodium = 5, saturatedFattyAcid = 0, sugar = 0, protein = 1, caffeine = 150)
@Espresso
public class TallIcedCaffeAmericano implements GetInformation {

    public TallIcedCaffeAmericano() {
    }

    public Map<String, Object> getInformationMap() {
        getInformation(TallIcedCaffeAmericano.class);
        return informationMap;
    }
}
