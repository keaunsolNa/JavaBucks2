package org.example.javapractice.dto.Drink.ColdBrew;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;

@Menu(name = "NitroColdBrew", price = 6500)
@Drink(isCold = true, size = "Tall", ml = 473, icedOnly = true)
@NutritionInformation(kcal = 5, sodium = 0, saturatedFattyAcid = 0, sugar = 0, protein = 0, caffeine = 195)
public class TallIcedNitroColdBrew extends NitroColdBrew {

    public TallIcedNitroColdBrew() {
        super();
    }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(TallIcedNitroColdBrew.class);
    }
}
