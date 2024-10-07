package org.example.javapractice.dto.Drink.Espresso;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Espresso;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;

@Menu(name = "FlatWhite", price = 5600)
@Drink(isCold = false, size = "Tall", ml = 355)
@NutritionInformation(kcal = 170, sodium = 130, saturatedFattyAcid = 5, sugar = 13, protein = 8, caffeine = 130)
@Espresso
public class TallFlatWhite extends FlatWhite {

    public TallFlatWhite() {
        super();
    }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(TallFlatWhite.class);
    }
}
