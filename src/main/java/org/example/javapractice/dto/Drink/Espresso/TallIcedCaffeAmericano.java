package org.example.javapractice.dto.Drink.Espresso;

import org.example.javapractice.Annotation.*;
import org.example.javapractice.Interface.GetInformation;
import org.example.javapractice.dto.Drink.ColdBrew.GrandeDolceColdBrew;

import java.util.Map;

@Menu(name = "IcedCaffeAmericano", price = 4500)
@Drink(isCold = true, size = "Tall", ml = 355)
@NutritionInformation(kcal = 10, sodium = 5, saturatedFattyAcid = 0, sugar = 0, protein = 1, caffeine = 150)
@Espresso
public class TallIcedCaffeAmericano extends CaffeAmericano {

    public TallIcedCaffeAmericano() {
        super();
    }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(TallIcedCaffeAmericano.class);
    }
}
