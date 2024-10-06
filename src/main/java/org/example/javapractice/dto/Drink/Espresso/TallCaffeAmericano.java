package org.example.javapractice.dto.Drink.Espresso;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Espresso;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;
import org.example.javapractice.Interface.GetInformation;
import org.example.javapractice.dto.Drink.ColdBrew.GrandeDolceColdBrew;

import java.util.Map;

@Menu(name = "CaffeAmericano", price = 4500)
@Drink(isCold = false, size = "Tall", ml = 355)
@NutritionInformation(kcal = 10, sodium = 5, saturatedFattyAcid = 0, sugar = 0, protein = 1, caffeine = 150)
@Espresso
public class TallCaffeAmericano extends CaffeAmericano {

    public TallCaffeAmericano() {
        super();
    }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(TallCaffeAmericano.class);
    }
}
