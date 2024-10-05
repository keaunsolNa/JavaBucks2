package org.example.javapractice.dto.Drink.Espresso;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Espresso;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;
import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

@Menu(name = "FlatWhite", price = 6600)
@Drink(isCold = false, size = "Venti", ml = 591)
@NutritionInformation(kcal = 320, sodium = 240, saturatedFattyAcid = 10, sugar = 24, protein = 16, caffeine = 195)
@Espresso
public class VentiFlatWhite implements GetInformation {

    public VentiFlatWhite() {
    }

    public Map<String, Object> getInformationMap() {
        getInformation(VentiFlatWhite.class);
        return informationMap;
    }
}
