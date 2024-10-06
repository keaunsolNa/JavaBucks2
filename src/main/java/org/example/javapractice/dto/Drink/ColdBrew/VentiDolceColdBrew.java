package org.example.javapractice.dto.Drink.ColdBrew;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;

import java.util.Map;

@Menu(name = "ColdBrew", price = 5900)
@Drink(isCold = true, size = "Venti", ml = 591)
@NutritionInformation(kcal = 5, sodium = 17, saturatedFattyAcid = 0, sugar = 0, protein = 0, caffeine = 250)
public class VentiDolceColdBrew extends DolceColdBrew {

    public VentiDolceColdBrew() {
        super();
    }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(VentiDolceColdBrew.class);
    }
}
