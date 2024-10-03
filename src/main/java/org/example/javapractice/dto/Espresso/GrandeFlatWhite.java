package org.example.javapractice.dto.Espresso;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Espresso;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;
import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

@Menu(name = "FlatWhite", price = 6100)
@Drink(isCold = false, size = "Grande", ml = 473)
@NutritionInformation(kcal = 250, sodium = 190, saturatedFattyAcid = 7, sugar = 19, protein = 12, caffeine = 195)
@Espresso
public class GrandeFlatWhite implements GetInformation {

    public GrandeFlatWhite() {
    }

    public Map<String, Object> getInformationMap() {
        getInformation(GrandeFlatWhite.class);
        return informationMap;
    }
}
