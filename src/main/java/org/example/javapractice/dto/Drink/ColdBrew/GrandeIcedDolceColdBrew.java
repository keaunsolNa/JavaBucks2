package org.example.javapractice.dto.Drink.ColdBrew;

import org.example.javapractice.Annotation.*;

@Menu(name = "DolceColdBrew", price = 6500)
@Drink(isCold = true, size = "Grande", ml = 473, icedOnly = true)
@NutritionInformation(kcal = 375, sodium = 42, saturatedFattyAcid = 12, sugar = 42, protein = 11, caffeine = 205)
public class GrandeIcedDolceColdBrew extends DolceColdBrew {

    public GrandeIcedDolceColdBrew() {
        super();
    }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(GrandeIcedDolceColdBrew.class);
    }
}
