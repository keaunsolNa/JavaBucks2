package org.example.javapractice.dto.Drink.Espresso;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Espresso;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;
import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

@Menu(name = "FlatWhite", price = 5600)
@Drink(isCold = false, size = "Tall", ml = 355)
@NutritionInformation(kcal = 170, sodium = 130, saturatedFattyAcid = 5, sugar = 13, protein = 8, caffeine = 130)
@Espresso
public class TallFlatWhite implements GetInformation {

    public TallFlatWhite() {
    }

    public Map<String, Object> getInformationMap() {
        getInformation(TallFlatWhite.class);
        return informationMap;
    }
}
