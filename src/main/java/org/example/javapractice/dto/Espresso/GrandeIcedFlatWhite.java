package org.example.javapractice.dto.Espresso;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Espresso;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;
import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

@Menu(name = "IcedFlatWhite", price = 6100)
@Drink(isCold = true, size = "Grande", ml = 473)
@NutritionInformation(kcal = 165, sodium = 120, saturatedFattyAcid = 4.7, sugar = 12, protein = 8, caffeine = 195)
@Espresso
public class GrandeIcedFlatWhite implements GetInformation {

    public GrandeIcedFlatWhite() {
    }

    public Map<String, Object> getInformationMap() {
        getInformation(GrandeIcedFlatWhite.class);
        return informationMap;
    }
}
