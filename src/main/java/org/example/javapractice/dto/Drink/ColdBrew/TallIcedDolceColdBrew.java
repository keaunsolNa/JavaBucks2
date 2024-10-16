package org.example.javapractice.dto.Drink.ColdBrew;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;

@Menu(name = "DolceColdBrew", price = 6000)
@Drink(isCold = true, size = "Tall", ml = 355, icedOnly = true)
@NutritionInformation(kcal = 265, sodium = 29, saturatedFattyAcid = 9, sugar = 29, protein = 8, caffeine = 155)
public class TallIcedDolceColdBrew extends DolceColdBrew {

    public TallIcedDolceColdBrew() {
        super();
    }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(TallIcedDolceColdBrew.class);
    }
}
