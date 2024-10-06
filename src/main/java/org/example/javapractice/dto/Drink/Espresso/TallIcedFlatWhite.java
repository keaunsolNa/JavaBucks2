package org.example.javapractice.dto.Drink.Espresso;

import org.example.javapractice.Annotation.Drink;
import org.example.javapractice.Annotation.Espresso;
import org.example.javapractice.Annotation.Menu;
import org.example.javapractice.Annotation.NutritionInformation;
import org.example.javapractice.Interface.GetInformation;
import org.example.javapractice.dto.Drink.ColdBrew.GrandeDolceColdBrew;

import java.util.Map;

@Menu(name = "IcedFlatWhite", price = 6100)
@Drink(isCold = true, size = "Tall", ml = 355)
@NutritionInformation(kcal = 120, sodium = 90, saturatedFattyAcid = 3.5, sugar = 6, protein = 6, caffeine = 130)
@Espresso
public class TallIcedFlatWhite extends FlatWhite {

    public TallIcedFlatWhite() {
        super();
    }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(TallIcedFlatWhite.class);
    }
}
