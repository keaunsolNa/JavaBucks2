package org.example.javapractice.dto.Drink.Frappuccino;

import org.example.javapractice.Annotation.*;

@Menu(name = "JavaChipFrappuccino", price = 6300)
@Drink(isCold = true, size = "Tall", ml = 355, icedOnly = true)
@NutritionInformation(kcal = 340, sodium = 180, saturatedFattyAcid = 9, sugar = 42, protein = 6, caffeine = 100)
@Frappuccino
public class TallIcedJavaChipFrappuccino extends JavaChipFrappuccino {

    public TallIcedJavaChipFrappuccino() {
        super();
    }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(TallIcedJavaChipFrappuccino.class);
    }
}
