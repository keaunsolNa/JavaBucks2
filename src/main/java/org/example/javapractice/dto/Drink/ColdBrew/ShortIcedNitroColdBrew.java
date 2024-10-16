package org.example.javapractice.dto.Drink.ColdBrew;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;

@Menu(name = "NitroColdBrew", price = 6000)
@Drink(isCold = true, size = "Short", ml = 473, icedOnly = true)
@NutritionInformation(kcal = 5, sodium = 0, saturatedFattyAcid = 0, sugar = 0, protein = 0, caffeine = 195)
public class ShortIcedNitroColdBrew extends NitroColdBrew {

    public ShortIcedNitroColdBrew() {
        super();
    }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(ShortIcedNitroColdBrew.class);
    }
}
