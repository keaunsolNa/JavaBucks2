package org.example.javapractice.dto.Espresso;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Espresso;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;
import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

@Menu(name = "IcedCaffeAmericano", price = 5000)
@Drink(isCold = true, size = "Grande", ml = 473)
@NutritionInformation(kcal = 15, sodium = 10, saturatedFattyAcid = 0, sugar = 0, protein = 1, caffeine = 225)
@Espresso
public class GrandeIcedCaffeAmericano implements GetInformation {

    public GrandeIcedCaffeAmericano() {
    }

    public Map<String, Object> getInformationMap() {
        getInformation(GrandeIcedCaffeAmericano.class);
        return informationMap;
    }
}
