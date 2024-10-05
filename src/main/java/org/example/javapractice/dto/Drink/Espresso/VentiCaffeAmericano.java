package org.example.javapractice.dto.Drink.Espresso;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Espresso;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;
import org.example.javapractice.Interface.GetInformation;

import java.util.Map;

@Menu(name = "CaffeAmericano", price = 5500)
@Drink(isCold = false, size = "Venti", ml = 591)
@NutritionInformation(kcal = 25, sodium = 10, saturatedFattyAcid = 0, sugar = 0, protein = 1, caffeine = 300)
@Espresso
public class VentiCaffeAmericano implements GetInformation {

    public VentiCaffeAmericano() {
    }

    public Map<String, Object> getInformationMap() {
        getInformation(VentiCaffeAmericano.class);
        return informationMap;
    }
}
