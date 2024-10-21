package org.example.javapractice.dto.Drink.ColdBrew;

import org.example.javapractice.Annotation.ColdBrew;
import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;

@Menu(name = "DolceColdBrew", price = 7000)
@Drink(isCold = true, size = "Venti", ml = 591, icedOnly = true)
@NutritionInformation(kcal = 375, sodium = 42, saturatedFattyAcid = 12, sugar = 42, protein = 11, caffeine = 205)
@ColdBrew
public class VentiIcedDolceColdBrew extends DolceColdBrew {

    public VentiIcedDolceColdBrew() {
        super();
    }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(VentiIcedDolceColdBrew.class);
    }
}
