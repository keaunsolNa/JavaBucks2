package org.example.javapractice.dto.Drink.Espresso;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Espresso;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;
import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

@Menu(name = "IcedFlatWhite", price = 6100)
@Drink(isCold = true, size = "Venti", ml = 591)
@NutritionInformation(kcal = 185, sodium = 140, saturatedFattyAcid = 5, sugar = 13, protein = 9, caffeine = 195)
@Espresso
public class VentiIcedFlatWhite implements GetInformation {

    public VentiIcedFlatWhite() {
    }

    public Map<String, Object> getInformationMap() {
        getInformation(VentiIcedFlatWhite.class);
        return informationMap;
    }
}
