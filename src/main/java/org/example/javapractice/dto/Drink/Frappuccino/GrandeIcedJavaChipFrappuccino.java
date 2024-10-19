package org.example.javapractice.dto.Drink.Frappuccino;

import org.example.javapractice.Annotation.*;

@Menu(name = "JavaChipFrappuccino", price = 6800)
@Drink(isCold = true, size = "Grande", ml = 473, icedOnly = true)
@NutritionInformation(kcal = 460, sodium = 240, saturatedFattyAcid = 12, sugar = 55, protein = 7, caffeine = 130)
@Frappuccino
public class GrandeIcedJavaChipFrappuccino extends JavaChipFrappuccino {

    public GrandeIcedJavaChipFrappuccino() { super(); }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(GrandeIcedJavaChipFrappuccino.class);
    }
}
