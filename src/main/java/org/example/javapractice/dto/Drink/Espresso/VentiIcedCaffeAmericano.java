package org.example.javapractice.dto.Drink.Espresso;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Espresso;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;

@Menu(name = "IcedCaffeAmericano", price = 5500)
@Drink(isCold = true, size = "Venti", ml = 591)
@NutritionInformation(kcal = 25, sodium = 10, saturatedFattyAcid = 0, sugar = 0, protein = 1, caffeine = 300)
@Espresso
public class VentiIcedCaffeAmericano extends CaffeAmericano {

    public VentiIcedCaffeAmericano() {
        super();
    }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(VentiIcedCaffeAmericano.class);
    }
}
