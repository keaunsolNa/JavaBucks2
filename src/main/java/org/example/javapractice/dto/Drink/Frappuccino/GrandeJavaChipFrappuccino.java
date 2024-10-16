package org.example.javapractice.dto.Drink.Frappuccino;

import org.example.javapractice.Annotation.*;

@Menu(name = "JavaChipFrappuccino", price = 6800)
@Drink(isCold = true, size = "Grande", ml = 473)
@NutritionInformation(kcal = 460, sodium = 240, saturatedFattyAcid = 12, sugar = 55, protein = 7, caffeine = 130)
@Frappuccino
public class GrandeJavaChipFrappuccino extends JavaChipFrappuccino {

    public GrandeJavaChipFrappuccino() { super(); }

    @Override
    public void getInformation(Class<?> T) {
        super.getInformation(GrandeJavaChipFrappuccino.class);
    }
}
