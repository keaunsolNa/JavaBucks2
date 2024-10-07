package org.example.javapractice.dto.Drink.Espresso;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Espresso;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;

@Menu(name = "IcedCaffeAmericano", price = 5000)
@Drink(isCold = true, size = "Grande", ml = 473)
@NutritionInformation(kcal = 15, sodium = 10, saturatedFattyAcid = 0, sugar = 0, protein = 1, caffeine = 225)
@Espresso
public class GrandeIcedCaffeAmericano extends CaffeAmericano {

    public GrandeIcedCaffeAmericano() {
        super();
    }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(GrandeIcedCaffeAmericano.class);
    }
}
