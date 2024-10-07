package org.example.javapractice.dto.Drink.Espresso;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Espresso;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;

@Menu(name = "FlatWhite", price = 6100)
@Drink(isCold = false, size = "Grande", ml = 473)
@NutritionInformation(kcal = 250, sodium = 190, saturatedFattyAcid = 7, sugar = 19, protein = 12, caffeine = 195)
@Espresso
public class GrandeFlatWhite extends FlatWhite {

    public GrandeFlatWhite() {
        super();
    }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(GrandeFlatWhite.class);
    }
}
